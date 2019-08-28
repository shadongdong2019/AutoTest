package com.tsa.ra.dealdata;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.tsa.ra.utils.OperationExcel;
import cn.tsa.*;
public class GetMapParam {
    public  OperationExcel oExcel = new OperationExcel();
    public  DealCaseData dCaseData = new DealCaseData();
    public String filename;
    public int sheetid;
	public GetMapParam() {
		
	}
	public GetMapParam(String filename) {
		this.filename = filename;
		this.sheetid = 0;
	}
	public GetMapParam(String filename,int sheetid) {
		this.filename = filename;
		this.sheetid = sheetid;
	}

    public  Map<String,String> getParamKeyValue(DealCaseData paramNameList,DealCaseData paramNameValue){
    	Map<String,String> param = new  HashMap<String, String>();
    	return param;
    }
    public  List<Map<String,String>> getParamKeyValue(int paramStartRowNum,int paramEndRowNum,int paramStartColNum,int paramIsrunColNum) throws IOException{
    	List<Map<String,String>> caseList = new ArrayList<Map<String,String>>();
    	List<String> paramNameList= dCaseData.getParamEnName(this.filename,this.sheetid,paramStartRowNum, paramStartColNum);
    	List<List<String>> paramValueList= dCaseData.getParamValue(this.filename,this.sheetid,paramStartRowNum+1,paramStartColNum,paramIsrunColNum);
//    	System.out.println("paramStartRowNum+1:"+paramStartRowNum+1);
//    	System.out.println("paramStartColNum:"+paramStartColNum);
//    	System.out.println("paramIsrunColNum:"+paramIsrunColNum);
    	int keyLen = (paramNameList != null) ? paramNameList.size() : 0;
    	for(List<String> paramValue:paramValueList){
    		Map<String,String> param = new  LinkedHashMap<String, String>();
    		int valLen = (paramValue != null ) ? paramValue.size() : 0;
        	int len = keyLen;
        	// 确保以最小的list集合长度为rs的长度, 防止 NullPointerException 异常
	    	if(len > valLen) {
	    		len = valLen;
	    	}
	    	// 保存到Map中, for循环遍历效率较高
	    	for(int i=0; i<len; i++) {
	    		if(paramValue.get(i) != null && paramValue.get(i) !="" ) {
	    			if(paramValue.get(i).equals("空")) {
	    				param.put(paramNameList.get(i), "");
	    			}else {
	    				param.put(paramNameList.get(i), paramValue.get(i));
	    			}
	    		}
	    	}
	    	if(param.size()>0) {
	    		caseList.add(param)	;
	    	}
    	}
    	return caseList; 
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//    	String url = "http://47.93.11.109:8088/service/CertAPI";
//    	System.out.println(getParamKeyValue());
//    	CertAPIDemo cert = new CertAPIDemo();
//    	for(Map<String,String> param:getParamKeyValue()) {
//    		cert.certApiDemo(param, url);
//    	}
    	
    	//getParamKeyValue();
    }
}
