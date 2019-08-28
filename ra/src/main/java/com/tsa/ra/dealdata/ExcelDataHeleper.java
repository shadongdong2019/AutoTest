package com.tsa.ra.dealdata;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tsa.ra.project.ReadPropertiesParam;

public class ExcelDataHeleper {
	ReadPropertiesParam rp = new ReadPropertiesParam("ca");
	public  String url =  rp.url;
	public  int paramStartRowNum = rp.paramStartRowNum;
	public  int paramEndRowNum = rp.paramEndRowNum;
	public  int paramStartColNum = rp.paramStartColNum;
	public  int paramIsrunColNum = rp.paramIsrunColNum;
	public  String excelPath =  rp.excelPath;
	public  int excelSheetId = rp.excelSheetId;
    GetMapParam getMapParam = new GetMapParam(excelPath,excelSheetId);

    
    @DataProvider(name="ra_ca_data")
    public Object[][] dataMethod() throws Exception{
    	System.out.println("excelSheetId:"+excelSheetId);
        System.out.println("paramStartColNum:"+paramStartColNum);
        List<Map<String, String>> paramList = getMapParam.getParamKeyValue(paramStartRowNum,paramEndRowNum,paramStartColNum,paramIsrunColNum);
        Object[][] caseArray = new Object[paramList.size()][];
        for(int i=0; i<paramList.size(); i++){
        	caseArray[i] = new Object[]{paramList.get(i)};
        }        
        return caseArray;
    }
}

