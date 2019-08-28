package com.tsa.ra.testcase;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.tsa.ra.dealdata.ExcelDataHeleper;
import com.tsa.ra.log.Log;

import cn.tsa.CertAPIDemo;
import cn.tsa.certapi.webservice.cfca.CfcaCertAPIDemo;
public class RaTestCase {
	String[] removeArray = new String[]{"IsRun","CaseID","TestTarget","CaseDesc","ExpectRes","ExpectValue","ResultValue","IsPass"};
	
    @BeforeClass
	public void beforeClass() throws Exception{
	}
	@BeforeTest
	public void beforeTest() throws Exception {

	}
	@Test(dataProvider="ra_ca_data",dataProviderClass= ExcelDataHeleper.class)
	public void caTest(Map<String,String> param) throws Exception {
		String url =callCaInterface();
    	//CertAPIDemo cert = new CertAPIDemo();
		CfcaCertAPIDemo cert = new CfcaCertAPIDemo();
		String IsRun = "";
		String CaseID = "";
		String TestTarget = "";
		String CaseDesc = "";
		String ExpectRes = "";
		String ExpectValue = "";
		String ResultValue = "";
		String IsPass = "";
		for(String s:removeArray) {
			if(s.equals("IsRun")) {
				IsRun = param.get(s);
			}else if(s.equals("CaseID")) {
				CaseID = param.get(s);
			}else if(s.equals("TestTarget")) {
				TestTarget = param.get(s);
			}else if(s.equals("CaseDesc")) {
				CaseDesc = param.get(s);
			}else if(s.equals("ExpectRes")) {
				ExpectRes = param.get(s);
			}else if(s.equals("ExpectValue")) {
				ExpectValue = param.get(s);
			}else if(s.equals("ResultValue")) {
				ResultValue = param.get(s);
			}else if(s.equals("IsPass")) {
				IsPass = param.get(s);
			}
			param.remove(s);
		}

    	String resString = cert.certApiDemo(param, url);
    	Log.info(resString);
    	
    	Reporter.log("用例编号="+CaseID);
    	Reporter.log("测试目的="+TestTarget);
    	Reporter.log("用例描述="+CaseDesc);
    	Reporter.log("接口请求地址="+url);
		Reporter.log("请求参数="+param.toString());
		Reporter.log("预期结果="+ExpectValue);
		Reporter.log("响应结果="+resString);
		String is_false = ExpectValue.split("_")[0];
		if(is_false.equals("false")) {
			ExpectValue = ExpectValue.split("_")[1];
			Boolean t =resString.contains(ExpectValue);
			Assert.assertEquals(resString.contains(ExpectValue), false);
		}else {
			Boolean t =resString.contains(ExpectValue);
			Assert.assertEquals(resString.contains(ExpectValue), true);
		}

		//Assert.assertNotEquals("", resString);
		TimeUnit.SECONDS.sleep(1);//秒
	}
	
	public String callCaInterface() throws Exception {
		ExcelDataHeleper edh = new ExcelDataHeleper();
		edh.dataMethod();
    	return edh.url;
	}
}
