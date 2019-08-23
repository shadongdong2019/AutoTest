package cn.tsa.certapi.webservice.cfca;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
//import java.util.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import cn.hutool.json.JSONObject;

//import sun.misc.BASE64Decoder;
import java.util.Base64.Decoder;

public class CfcaCertAPIDemo {
	/**
	* 
	*
	**/
	public static void main(String[] args) throws Exception {
		makecert();
	}
	public static void makecert()throws Exception {
		String url = "";
//		url = "http://123.56.207.157:8022/service/CertAPI?wsdl";
//		url = "http://ra.tsa.cn/service/CertAPI?wsdl";
//		url = "http://192.168.50.172:18088/service/CertAPI?wsdl";
		url = "http://192.168.50.172:18088/service/CfcaCertAPI?wsdl";
		url = "http://47.93.11.109:8088/service/CfcaCertAPI";
		for (int i = 0; i < 1; i++) {
			CfcaCertAPI service = new CfcaCertAPIService(new URL(url)).getCfcaCertAPIPort();
			Map<String, String> param = new HashMap<String, String>();
//			                       d6b56bf9c11caff2
			// 964fc628
			param.put("password", "111222");// 必填项
			param.put("username", "北京技术服务有限公司");//必填项
			// C=CN,ST=Beijing,L=Beijing,O=TopCA RDCenter,OU=TopCA,CN=xxx
//			param.put("subject", "o=北京技术服务有限公司,ou=测试专用,cn=23464567575675634XE-北京技术服务有限公司");// 必填项
			param.put("period", "1"); // 必填项 day:1-30,month:1-12,year:1-5
			param.put("periodType", "year"); // 必填项 day, month,year
			//证件类型,  个人
//			  居民身份证("0"), 护照("1"), 军人身份证("2"), 股东代码证("5"), 社会保障卡("6"),
//			  武装警察身份证件("A"), 港澳居民往来内地通行证("B"), 台湾居民来往大陆通行证("C"), 户口簿("E"),
//			  临时居民身份证("F"), 警察警官证("G"), 社会团体登记证书("J"), 民办非企业登记证书("K"),  外国人永久居留证("P"),
			  //证件类型,  企业
//			  工商登记证("3"), 税务登记证("4"), 组织机构代码证("7"), 企业营业执照("8"), 法人代码证("9"), 
//			  事业单位法人证书("H"), 外国地区企业常驻代表机构登记证("L"), 政府批文("M"), 统一社会信用代码证("N");
			param.put("cardType", "0"); 
			param.put("cardNumber", "111111111111111"); // 必填项
			param.put("email", "tsa@tsa.cn"); // 非必填项」

			
			//公司专用
//			param.put("password", "111222");// 必填项
//			param.put("username", "北京联合信任技术服务有限公司");
//			param.put("subject", "o=北京联合信任技术服务有限公司,ou=版权保护,cn=9111010578020234XE-北京联合信任技术服务有限公司");// 必填项
//			param.put("period", "1"); // 必填项 day:1-30,month:1-12,year:1-3
//			param.put("periodType", "year"); // 必填项 day, month,year
//			param.put("cardType", "统一社会信用代码"); // 必填项 "身份证","护照","港澳通行证","台胞证","组织机构代码证","统一社会信用代码"
//			param.put("cardNumber", "9111010578020234XE"); // 必填项
			

			String json = JSON.toJSONString(param);
			String sign = sign(param);
			System.out.println(sign);
			if (checkSign(param, sign)) {
				// 设置pin码密钥，并获取证书
				Result result = service.handle("0096d530b10a8b3dcf2ab1b6fd2e9c2b", json, sign);
				JSONObject jsonObj = JSONObject.parseObject(result.getParam());
				String pfx = jsonObj.getString("pfx");
				String md5 = jsonObj.getString("sign");
				System.out.println(JSONObject.toJSON(result).toString());
//				System.out.println("checkResult(pfx, md5) = " + (checkResult(pfx, md5)));
				if (checkResult(pfx, md5)) {
					System.out.println("ok");
					Base64.Decoder bd = Base64.getDecoder();
					byte[] cert = bd.decode(pfx);
					//BASE64Decoder bd = new BASE64Decoder();
					//byte[] cert = bd.decodeBuffer(pfx);
					FileOutputStream fos = new FileOutputStream(new File("/home/ma/cert_test/ca/111222.pfx"));
					fos.write(cert);
					fos.flush();
					fos.close();
				} else {
					System.out.println("errorerrorerrorerrorerrorerrorerrorerrorerrorerr");
				}
			}
		}
	}

	public static boolean checkResult(String pfx, String md5) throws NoSuchAlgorithmException {
		try {
			String result = "";
			result = md5Hex(pfx);
			if (result.equalsIgnoreCase(md5)) {
				return true;
			}
			result = "";
			// 指定加密的方式为MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 进行加密运算
			byte bytes[] = md.digest(pfx.getBytes());
			for (int i = 0; i < bytes.length; i++) {
				// 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
				String str = Integer.toHexString(bytes[i] & 0xFF);
				if (str.length() == 1) {
					str += "F";
				}
				result += str;
			}
			return result.equalsIgnoreCase(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String sign(Map<String, String> param) throws NoSuchAlgorithmException {
//		return DigestUtils.md5Hex(joinParam(param));
		return md5Hex(joinParam(param));
	}

	public static Boolean checkSign(Map<String, String> param, String sign) throws NoSuchAlgorithmException {
//		return DigestUtils.md5Hex(joinParam(param)).equals(sign);
		return md5Hex(joinParam(param)).equals(sign);
	}

	public static String md5Hex(String param) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(param.getBytes());
		byte[] secretBytes = md.digest();
		// 将加密后的数据转换为16进制数字
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		int length = md5code.length();
		for (int i = 0; i < 32 - length; i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

	private static String joinParam(Map<String, String> param) {
		StringBuffer paramStr = new StringBuffer();
		Set<String> keys = param.keySet();
		Iterator<String> it = keys.iterator();

		List<String> myList = new ArrayList<String>();
		while (it.hasNext())
			myList.add(it.next());

		Collections.sort(myList, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String key : myList) {
			paramStr.append(key).append("=").append(param.get(key)).append("&");
		}
		String str = paramStr.substring(0, paramStr.length() - 1);
		//System.out.print(str);
		return str;
	}
}
