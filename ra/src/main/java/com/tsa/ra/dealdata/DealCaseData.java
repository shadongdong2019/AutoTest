package com.tsa.ra.dealdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.tsa.ra.utils.OperationExcel;

public class DealCaseData {
    public static ResourceBundle bundle;//解析配置文件使用
    public static OperationExcel oExcel = new OperationExcel();
    public static List<String> getParamEnName(int paramRowNum,int paramColNum) throws IOException {
        /**
         * paramRowNum:表示指定excel表中参数名所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数名开始的列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",3);
        List<String> caseParamNameList=new ArrayList<String>();
        
        for(int j=paramColNum;j<alldata[paramRowNum].length;j++){
            String paramName = (String) alldata[paramRowNum][j];
            String[] paramNameArray = paramName.split("-");
            String paramEnName=paramNameArray[1];
            caseParamNameList.add(paramEnName);
        }
        //System.out.println(caseParamNameList);
        return caseParamNameList;
    }

    public static List<Object> getParamValue(int paramRowNumStart,int paramColNum) throws IOException {
        /**
         * paramRowNumStart:表示指定excel表中参数值所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",3);
        List<Object> caseAllParamValueList=new ArrayList<Object>();
        //List<List<String>> caseAllParamValueList=new ArrayList<List<String>>();
        for(int i=paramRowNumStart;i<alldata.length;i++){
        	List<String> caseParamValueList=new ArrayList<String>();
            for(int j=paramColNum;j<alldata[i].length;j++){
                String paramValue = (String) alldata[i][j];
                caseParamValueList.add(paramValue);
               // System.out.println(caseParamValueList);
            }
            caseAllParamValueList.add(caseParamValueList);
        }
        System.out.println(caseAllParamValueList);
        return caseAllParamValueList;
    }

    public static List<List<String>> getParamValue(int paramRowNumStart,int paramColNum,int isRunNum) throws IOException {
        /**
         * paramRowNumStart:表示指定excel表中参数值所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * isRunNum:表示是否运行标志的所在列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",3);
        //List<Object> caseAllParamValueList=new ArrayList<Object>();
        List<List<String>> caseAllParamValueList=new ArrayList<List<String>>();
        for(int i=paramRowNumStart;i<alldata.length;i++){
        	List<String> caseParamValueList=new ArrayList<String>();
        	String isRun = (String) alldata[i][isRunNum];
        	if(isRun.toLowerCase().equals("yes")){
	            for(int j=paramColNum;j<alldata[i].length;j++){
	                String paramValue = (String) alldata[i][j];
	                caseParamValueList.add(paramValue);
	               // System.out.println(caseParamValueList);
	            }
	            caseAllParamValueList.add(caseParamValueList);
            }
        	
        }
        System.out.println(caseAllParamValueList);
        return caseAllParamValueList;
    }

    
    public static List<Object> getParamValue(int paramRowNumStart,int paramRowNumEnd,int paramColNum,int isRunNum) throws IOException {
        /**
         * paramRowNumStart:表示指定excel表中参数值所在行号（0表示第一行）
         * paramRowNumEnd:表示指定excel表中参数值结束行号（0表示第一行）
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * isRunNum:表示是否运行标志的所在列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",3);
        //List<List<String>> caseAllParamValueList=new ArrayList<List<String>>();
        List<Object> caseAllParamValueList=new ArrayList<Object>();
        int endNum;
        if(paramRowNumEnd>alldata.length){
            endNum = alldata.length;
        }else{
            endNum = paramRowNumEnd;
        }

        for(int i=paramRowNumStart;i<endNum;i++){
        	List<String> caseParamValueList=new ArrayList<String>();
            String isRun = (String) alldata[i][isRunNum];
            if(isRun.toLowerCase().equals("yes")){
                for(int j=paramColNum;j<alldata[i].length;j++){
                    String paramValue = (String) alldata[i][j];
                    caseParamValueList.add(paramValue);
                }
                caseAllParamValueList.add(caseParamValueList);
            }
          //  System.out.println(caseParamValueList);
        }
        System.out.println(caseAllParamValueList);
        return caseAllParamValueList;
    }

    public static void main(String[] args) throws IOException {
        getParamEnName(0,7);
        getParamValue(1,7);
        getParamValue(1,7,0);
        getParamValue(1,3,7,0);
    }
}
