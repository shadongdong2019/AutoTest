package com.tsa.ra.dealdata;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tsa.ra.project.ReadPropertiesParam;

public class ExcelDataHeleper {
	//ReadPropertiesParam rp = new ReadPropertiesParam("ra");
	public static String url =  ReadPropertiesParam.url;
	public static int paramNameStartRowNum = ReadPropertiesParam.paramNameStartRowNum;
	public static int paramNameEndRowNum = ReadPropertiesParam.paramNameEndRowNum;
	public static int paramValueStartRowNum = ReadPropertiesParam.paramValueStartRowNum;
	public static int paramValuEndRowNum = ReadPropertiesParam.paramValuEndRowNum;
	public static int paramStartColNum = ReadPropertiesParam.paramStartColNum;
	public static int paramIsrunColNum = ReadPropertiesParam.paramIsrunColNum;
	public static String excelPath =  ReadPropertiesParam.excelPath;
	public static int excelSheetId = ReadPropertiesParam.excelSheetId;
    GetMapParam getMapParam = new GetMapParam(excelPath,excelSheetId);

    
    @DataProvider(name="ra_ca_data")
    public Object[][] dataMethod() throws Exception{
    	System.out.println("excelSheetId:"+excelSheetId);
        System.out.println("paramStartColNum:"+paramStartColNum);
        List<Map<String, String>> paramList = getMapParam.getParamKeyValue(paramNameStartRowNum,paramNameEndRowNum,paramValueStartRowNum,paramValuEndRowNum,paramStartColNum,paramIsrunColNum);
        Object[][] caseArray = new Object[paramList.size()][];
        for(int i=0; i<paramList.size(); i++){
        	caseArray[i] = new Object[]{paramList.get(i)};
        }        
        return caseArray;
    }
}

