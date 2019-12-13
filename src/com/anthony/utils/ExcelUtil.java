package com.anthony.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setExcelFile(String xlfile,String xlsheet) throws Exception {

	    try {
	      
	       FileInputStream ExcelFile = new FileInputStream(xlfile);
	       wb = new XSSFWorkbook(ExcelFile);
	       ws = wb.getSheet(xlsheet);
	    }catch (Exception e) {

	    	throw (e);
	    }

	}
	
	/**
	 * 获取行数
	 * @param xlfile
	 * @param xlsheet
	 * @return
	 * @throws IOException
	 */
	public static int getRowCount(String xlfile, String xlsheet) throws IOException{
	    fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    int rowcount = ws.getLastRowNum();
	    wb.close();
	    fi.close();
	    return rowcount;
	}
	
	/**
	 * 获取cell行数
	 * @param xlfile
	 * @param xlsheet
	 * @param rownum
	 * @return
	 * @throws IOException
	 */
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException{

	    fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    row = ws.getRow(rownum);
	    int cellcount = row.getLastCellNum();
	    wb.close();
	    fi.close();
	    return cellcount;

	}
	
	/**
	 * 获取单元格里面字符串内容
	 * @param xlfile Excel文件路径
	 * @param xlsheet sheet名称，默认是sheet1
	 * @param rownum  行号
	 * @param colnum  列号
	 * @return        返回�?个单元格里面字符串内�?
	 * @throws IOException
	 */
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {

	    fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    row = ws.getRow(rownum);
	    cell = row.getCell(colnum);
	    String data;
	    
	    try {
	        DataFormatter formatter = new DataFormatter();
	        String cellData = formatter.formatCellValue(cell);
	        return cellData;
	    } catch (Exception e) {
	    	data = "";
	    }
	    wb.close();
	    fi.close();
	    return data;
	}
	
	/**
	 * 给单元格设置内容
	 * @param xlfile  Excel文件路径名称
	 * @param xlsheet Excel默认sheet名称，默认是sheet1
	 * @param rownum  行号
	 * @param colnum  列号
	 * @param data    �?要写入的字符串数�?
	 * @throws IOException
	 */
	public static void setCellData(String xlfile,String xlsheet, int rownum, int colnum, String data) throws IOException {

	    fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    row = ws.getRow(rownum);
	    cell = row.getCell(colnum);
	    cell.setCellValue(data);
	    fo = new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();

	}
	
}
