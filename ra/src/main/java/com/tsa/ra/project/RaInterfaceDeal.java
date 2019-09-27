package com.tsa.ra.project;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.tsa.ra.dealdata.GetMapParam;

import cn.tsa.*;
public class RaInterfaceDeal {
//	 ReadPropertiesParam rp = new ReadPropertiesParam("ca");
	 public static String url = ReadPropertiesParam.url;
	 public static int paramNameStartRowNum = ReadPropertiesParam.paramNameStartRowNum;
	 public static int paramNameEndRowNum = ReadPropertiesParam.paramNameEndRowNum;
	 public static int paramValueStartRowNum = ReadPropertiesParam.paramValueStartRowNum;
	 public static int paramValuEndRowNum = ReadPropertiesParam.paramValuEndRowNum;
	 public static int paramStartColNum = ReadPropertiesParam.paramStartColNum;
	 public static int paramIsrunColNum = ReadPropertiesParam.paramIsrunColNum;
	 public  void calledRaInterface() throws IOException, NoSuchAlgorithmException{
		 //		 Object object_str = Class.forName(className).newInstance(); 
		 //		 object_str.

		 GetMapParam getMapParam = new GetMapParam();
		 List<Map<String,String>> caseList= getMapParam.getParamKeyValue(paramNameStartRowNum,paramNameEndRowNum,paramValueStartRowNum,paramValuEndRowNum,paramStartColNum,paramIsrunColNum);
		 CertAPIDemo cert = new CertAPIDemo();
    	 for(Map<String,String> param:caseList) {
    		cert.certApiDemo(param, url);
    	 }
	 }

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		//calledRaInterface();
		System.out.print("http://39.107.66.190:9999/v2/api/confirm/callback?id=12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf12345ascdf1231".length());
	}
}
