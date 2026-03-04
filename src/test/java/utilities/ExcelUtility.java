package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	
	public int getRowCount(String xlsheet) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowCount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet= wb.getSheet(xlsheet);
		int cellCount=sheet.getRow(rownum).getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public String getcellData(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet= wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		String data;
		
		try
		{
			//data=cell.toString();
			DataFormatter formatter= new DataFormatter();
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		
		if(xlfile.exists())
		{
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			wb.write(fo);
		}
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(xlsheet)==-1)
			wb.createSheet(xlsheet);
		sheet= wb.getSheet(xlsheet);
			
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
	public void fillGreenColor(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet= wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style =wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	
	}
	
	
	public void fillRedColor(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet= wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style =wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	
	}

}
