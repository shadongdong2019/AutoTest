package com.tsa.ra.project;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadPropertiesParam {
	//解析配置文件使用
	 public static ResourceBundle bundle = ResourceBundle.getBundle("ra", Locale.CHINA);
	 public static String url = bundle.getString("test.ra.url");
	 public static String className = bundle.getString("test.ra.ca_class");
	 public static String methodName = bundle.getString("test.ra.ca_class_method");
	 public static int paramStartRowNum = Integer.parseInt(bundle.getString("test.ra.param.start.row"));
	 public static int paramEndRowNum = Integer.parseInt(bundle.getString("test.ra.param.end.row"));
	 public static int paramStartColNum = Integer.parseInt(bundle.getString("test.ra.param.start.col"));
	 public static int paramIsrunColNum = Integer.parseInt(bundle.getString("test.ra.param.isrun.col"));
	 public static String excelPath = bundle.getString("test.ra.excel.path");
	 public static int excelSheetId = Integer.parseInt(bundle.getString("test.ra.excel.sheetid"));
//	 public static void dealPropertiesParam() {
//		 try {
//			 paramStartRowNum = Integer.parseInt(bundle.getString("test.ra.param.start.row"));
//		 }catch(Exception e){
//			 paramStartRowNum = 0;
//		 }
//		 try {
//			 paramEndRowNum = Integer.parseInt(bundle.getString("test.ra.param.end.row = 0"));
//		 }catch(Exception e){
//			 paramEndRowNum = 0;
//		 }
//		 try {
//			 paramStartColNum = Integer.parseInt(bundle.getString("test.ra.param.start.col"));
//
// 		 }catch(Exception e){
//			 paramStartColNum = 0;
//		 }
//		 try {
//			 paramIsrunColNum = Integer.parseInt(bundle.getString("test.ra.param.isrun.col"));
//		 }catch(Exception e){
//			 paramIsrunColNum = 0;
//		 }
//		 try {
//			 excelSheetId = Integer.parseInt(bundle.getString("test.ra.excel.sheetid"));
//		 }catch(Exception e){
//			 excelSheetId = 0;
//		 }
//		 System.out.println("**************************");
//		 System.out.println(paramStartColNum);
//	 }

}
