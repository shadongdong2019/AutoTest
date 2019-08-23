package cn.tsa;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;

//import cn.hutool.crypto.digest.DigestUtil;

public class ThreadTest extends Thread {
	@Override
	public void run() {
		String url = "http://192.168.50.172:8088/service/CertAPI?wsdl";
//		String url = "http://101.201.254.163:18088/service/CertAPI?wsdl";
		CertAPI service;
		try {
			service = new CertAPIService(new URL(url)).getCertAPIPort();
//		System.out.println(service.hashCode());
		LinkedHashMap <String, String> param = new LinkedHashMap<String, String>();
		param.put("password", "111111");//必填项
		//C=CN,ST=Beijing,L=Beijing,O=TopCA RDCenter,OU=TopCA,CN=xxx
		param.put("subject", "CN=" +  "联合信任");//必填项
		param.put("period", "3");                     //必填项 day:1-30,month:1-12,year:1-3
		param.put("username", "hy");              // if(cardType in ("身份证","护照","港澳通行证","台胞证")){ 为必填项}
		param.put("periodType", "year");               //必填项 day, month,year
		param.put("cardType", "身份证");         //必填项 "身份证","护照","港澳通行证","台胞证","组织机构代码证","统一社会信用代码"
//		param.put("cardType", "组织机构代码证");         //必填项 "身份证","护照","港澳通行证","台胞证","组织机构代码证","统一社会信用代码"
		param.put("cardNumber", "210106198308231925"); //必填项
		param.put("email", "hanyaaaa@163.com");        //必填项
//		param.put("caOrg", "ECCA");                   //非必填项，默认随机,  TWCA:天威, SHECA:上海CA，ECCA颐信CA,
		
//		String sign = sign(param);
//		String json = JSON.toJSONString(param);
//		long l = System.currentTimeMillis();
		
//		for(int i = 0; i < 1000; i++){
//			Result result = service.handle("1b261066cf0f7dd1f63e35d4ad0cd127", json, sign);// 设置pin码密钥，并获取证书
//		System.out.println(result.getCode()); // 打印结果状态码 0 成功, 1 参数错误, 2 pin码验证失败, 3套餐用尽, 其他, "制证失败
//		}
//		System.out.println(System.currentTimeMillis() - l);

	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

//	public static String sign(LinkedHashMap <String, String> param) {
//		return DigestUtil.md5Hex(joinParam(param));
//	}
//
//	public static Boolean checkSign(LinkedHashMap <String, String> param, String sign) {
//		return DigestUtil.md5Hex(joinParam(param)).equals(sign);
//	}
//
//	private static String joinParam(LinkedHashMap <String, String> param) {
//		StringBuffer paramStr = new StringBuffer();
//		Set<String> keys = param.keySet();
//		for (String key : keys) {
//			paramStr.append(key).append("=").append(param.get(key)).append("&");
//		}
//		String str = paramStr.substring(0, paramStr.length() - 1);
//		return str;
//	}
}
