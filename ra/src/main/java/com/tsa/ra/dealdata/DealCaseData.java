package com.tsa.ra.dealdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.tsa.ra.utils.OperationExcel;

public class DealCaseData {
    public static ResourceBundle bundle;//解析配置文件使用
    public static OperationExcel oExcel = new OperationExcel();
    public static List<String> getParamEnName(String filepath,int sheetid, int paramRowNum,int paramColNum) throws IOException {
        /**
         * paramRowNum:表示指定excel表中参数名所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数名开始的列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData(filepath,sheetid);
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

    public static List<Object> getParamValue(String filepath,int sheetid,int paramRowNumStart,int paramColNum) throws IOException {
        /**
         * paramRowNumStart:表示指定excel表中参数值所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData(filepath,sheetid);
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

    public static List<List<String>> getParamValue(String filepath,int sheetid,int paramRowNumStart,int paramRowNumEnd,int paramColNum,int isRunNum) throws IOException {
        /**
         * filepath:表示 excel表格路径
         * sheetid：表示sheetid,从0开始
         * paramRowNumStart:表示指定excel表中参数值开始行号（0表示第一行）
         * paramRowNumEnd：表示指定excel表中参数值结束行号，不包含小于此行号
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * isRunNum:表示是否运行标志的所在列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData(filepath,sheetid);
        //List<Object> caseAllParamValueList=new ArrayList<Object>();
        List<List<String>> caseAllParamValueList=new ArrayList<List<String>>();
        int endRowNum =0;
        if(paramRowNumEnd>0 && paramRowNumEnd<alldata.length ) {
        	endRowNum = paramRowNumEnd;
        }else {
        	endRowNum = alldata.length;
        }
        	
        for(int i=paramRowNumStart;i<endRowNum;i++){
        	List<String> caseParamValueList=new ArrayList<String>();
        	String isRun = (String) alldata[i][isRunNum];
//        	System.out.println("第"+i+"行："+isRun);
//        	System.out.println("是否运行值："+isRun.toLowerCase());
        	if(isRun.toLowerCase().equals("yes")){
	            for(int j=paramColNum;j<alldata[i].length;j++){
	                String paramValue = (String) alldata[i][j];
	                caseParamValueList.add(paramValue);
//	                System.out.println("第"+i+"行,第"+j+"列："+paramValue);
//	                System.out.println(caseParamValueList);
	            }
	            caseAllParamValueList.add(caseParamValueList);
            }
        	
        }
//        System.out.println("所有行："+alldata.length);
//        System.out.println("开始行号："+paramRowNumStart);
//        System.out.println("结束行号："+endRowNum);
//        System.out.println("测试用例集合："+caseAllParamValueList);
        return caseAllParamValueList;
    }

    
    public static List<List<String>> getParamValue(String filepath,int sheetid,int paramRowNumStart,int paramRowNumEnd,int paramColNum) throws IOException {
        /**
         * paramRowNumStart:表示指定excel表中参数值所在行号（0表示第一行）
         * paramColNum:表示指定excel表中参数值开始的列号（0表示第一列）
         * isRunNum:表示是否运行标志的所在列号（0表示第一列）
         * */
        Object[][] alldata = oExcel.readExData(filepath,sheetid);
        //List<Object> caseAllParamValueList=new ArrayList<Object>();
        List<List<String>> caseAllParamValueList=new ArrayList<List<String>>();
        for(int i=paramRowNumStart;i<alldata.length;i++){
        	List<String> caseParamValueList=new ArrayList<String>();
        	String isRun = (String) alldata[i][1];
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


    public static void main(String[] args) throws IOException {
//        getParamEnName(0,7);
//        getParamValue(1,7);
//        getParamValue(1,7,0);
//        getParamValue(1,3,7,0);
    }
}
