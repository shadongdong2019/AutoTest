package com.tsa.ra.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.tsa.ra.dealdata.ExcelDataHeleper;

import cn.tsa.CertAPIDemo;
import cn.tsa.certapi.webservice.cfca.CfcaCertAPIDemo;
public class RaTestCase {
	
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
    	System.out.println("************************************");
    	System.out.println(param);
    	System.out.println(url);
    	String resString = cert.certApiDemo(param, url);
    	System.out.println(resString);
    	System.out.println("************************************");
		Assert.assertNotEquals("", resString);
	}
	
	public String callCaInterface() throws Exception {
		ExcelDataHeleper edh = new ExcelDataHeleper();
		edh.dataMethod();
    	return edh.url;
	}
}
