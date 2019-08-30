package com.tsa.ra.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 遍历excel，sheet参数
 */
public class OperationExcel {
    public static String filePath_g;
    public static int sheetId_g;
    public OperationExcel(){

    }
    public OperationExcel(String filePath,int sheetId){
        this.filePath_g = filePath;
        this.sheetId_g = sheetId;
    }

    public static Sheet getExcelSheetObject() throws IOException {
        /**
         * 获取excel表格指定sheet页的数据对像，方法不携带参数
         * filePath_g：new对像时初始化
         * sheetId_g：new对像时初始化
         * */
        //根据路径创建File类对象--这里路径即使错误也不会报错，因为只是产生File对象，还并未与计算机文件读写有关联
        File file = new File(filePath_g);
        FileInputStream fis;
        try
        {
            fis=new FileInputStream(file);//与根据File类对象的所代表的实际文件建立链接创建fileInputStream对象
        }
        catch (FileNotFoundException e)
        {
            fis=null;
            System.out.println("文件不存在或者文件不可读或者文件是目录");
        }

        Workbook wb = null;
        wb = WorkbookFactory.create(fis);//把excel数据读取到wb中
        fis.close();
        Sheet sh = wb.getSheetAt(sheetId_g);//读取指定sheet页的数据，sheet页从0开始
        return sh;
    }



    public static Sheet getExcelSheetObject(String filePath,int sheetId) throws IOException {
        /**
         * 获取excel表格指定sheet页的数据对像，方法携带参数
         * filePath_g：对像调用方法时传入
         * sheetId_g：对像调用方法时传入
         * */
        //根据路径创建File类对象--这里路径即使错误也不会报错，因为只是产生File对象，还并未与计算机文件读写有关联
        File file = new File(filePath);
        FileInputStream fis;
        try
        {
            fis=new FileInputStream(file);//与根据File类对象的所代表的实际文件建立链接创建fileInputStream对象
        }
        catch (FileNotFoundException e)
        {
            fis = null;
            System.out.println("文件不存在或者文件不可读或者文件是目录");
        }

        Workbook wb = null;
        wb = WorkbookFactory.create(fis);//把excel数据读取到wb中
        fis.close();
        Sheet sh = wb.getSheetAt(sheetId);//读取指定sheet页的数据，sheet页从0开始
        return sh;
    }

    public static int getSheetRows() throws IOException {
        /**
         * 获取Excel表格指定sheet页的行数
         * */

        Sheet sh = getExcelSheetObject();
        int numberrow = sh.getPhysicalNumberOfRows();//获取excel表指定sheet页的行数，获取的是物理行数
        return numberrow;
    }
    public static int getSheetRowsNum() throws IOException {
        /**
         * 获取Excel表格指定sheet页的最后一行行号（第一行行号为0）
         * */

        Sheet sh = getExcelSheetObject();
        int numberrow = sh.getLastRowNum();//获取excel表指定sheet页的行数，获取的是物理行数，也就是不包括那些空行（隔行）的情况
        return numberrow;
    }
    public static int getSheetCols(int rowNum) throws IOException {
        /**
         * 获取Excel表格指定sheet页指定行有值的列数（无值列不计数）
         * */

        Sheet sh = getExcelSheetObject();
        int numbercols = sh.getRow(rowNum).getPhysicalNumberOfCells();;//获取excel表指定sheet页指定行的列数，获取的是物理列数，也就是不包括那些空行（隔行）的情况
        return numbercols;
    }

    public static int getSheetColsNum(int rowNum) throws IOException {
        /**
         * 获取Excel表格指定sheet页指定行的最后一列列号（无值列计数在内）
         * */

        Sheet sh = getExcelSheetObject();
        int numbercols = sh.getRow(rowNum).getLastCellNum();//获取excel表指定sheet页指定行的列数，获取的是物理列数，也就是不包括那些空行（隔行）的情况
        return numbercols;
    }


    public static Row getRowVlues(int rowNum) throws IOException {
        /**
         * 获取指定行数据
         * */
        Sheet sh = getExcelSheetObject();
        Row rowObject =sh.getRow(rowNum);
        return rowObject;
    }

    public static Row getColVlues(int rowNum) throws IOException {
        /**
         * 获取指定行列数据
         * */
        Sheet sh = getExcelSheetObject();
        Row rowObject =sh.getRow(rowNum);
        return rowObject;
    }

    public static Cell getCellValue(int rowNum,int colNum) throws IOException {
        /**
         * 获取Excel表格指定单元格内容
         * rowNum:表示指定行号
         * colNum：表示指定列号
         * */
        Sheet sh = getExcelSheetObject();
        Row  rowObject =sh.getRow(rowNum);//获取行值
        Cell cell=rowObject.getCell(colNum);//获取单元格值
        return cell;
    }

    public static Boolean setCellValue(int rowNum,int colNum,String value) throws IOException {
        Boolean flag=false;
        Sheet sh = getExcelSheetObject();
        Cell cell= sh.getRow(rowNum).getCell(colNum);
        try{
            cell.setCellValue(value);
            flag=true;
        }catch (Exception e){
            flag=false;
            System.out.printf("写入excel表指定单元格数据失败，失败原因=<%s>",e);
        }
        return flag;

    }
    //遍历excel，sheet参数
    public static Object[][] readExData(String filePath,int sheetId) throws IOException{
        //根据路径创建File类对象--这里路径即使错误也不会报错，因为只是产生File对象，还并未与计算机文件读写有关联
        File file = new File(filePath);
    	//File file = new File("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx");
        FileInputStream fis;
        try
        {
            fis=new FileInputStream(file);//与根据File类对象的所代表的实际文件建立链接创建fileInputStream对象
        }
        catch (FileNotFoundException e)
        {
            fis=null;
            System.out.println("文件不存在或者文件不可读或者文件是目录");
        }

        Workbook wb = null;
        wb = WorkbookFactory.create(fis);//把excel数据读取到wb中
        fis.close();
        Sheet sh = wb.getSheetAt(sheetId);//读取指定sheet页的数据，sheet页从0开始
        int numberrow = sh.getPhysicalNumberOfRows();//获取excel表指定sheet页的行数，获取的是物理行数，也就是不包括那些空行（隔行）的情况
        int numbercell = sh.getRow(0).getLastCellNum();

        Object[][] dttData = new Object[numberrow][numbercell];
        for(int i=0;i<numberrow;i++){
            if(null==sh.getRow(i)||"".equals(sh.getRow(i))){
                continue;
            }
            for(int j=0;j<numbercell;j++) {
                if(null==sh.getRow(i).getCell(j)||"".equals(sh.getRow(i).getCell(j))){
                    continue;
                }
                Cell cell = sh.getRow(i).getCell(j);
                cell.setCellType(CellType.STRING);
                dttData[i][j] = cell.getStringCellValue();
            }
        }
        return dttData;
    }

    public static void main(String[] args) throws IOException {
        OperationExcel oe = new OperationExcel();
        OperationExcel oee = new OperationExcel("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",0);
        Object[][] alldata = oe.readExData("/home/ma/eclipse-workspace/AutoTest/ra/src/main/java/com/tsa/ra/casefile/ra_case.xlsx",0);
        for(int i=0;i<alldata.length;i++){
            for(int j=0;j<alldata[i].length;j++){
               // System.out.println(alldata[i][j]);
            }
        }
        System.out.println(oee.getSheetRows());//获取物理行数
        System.out.println(oee.getSheetRowsNum());//获取最后一行行号（第一行行号为0）
        System.out.println(oee.getSheetCols(1));//获取指定行有值的列数
        System.out.println(oee.getSheetColsNum(1));//获取指定行最后一列列号
        System.out.println(oee.getRowVlues(1).getCell(0));//获取指定行指定列单元格内的数据
        System.out.println(oee.getCellValue(1,0));//获取指定行指定列单元格内的数据
       // System.out.println(oee.setCellValue(77,0,"sssss"));


    }
}
