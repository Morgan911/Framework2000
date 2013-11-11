package com.sikachov.framework.helpers.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ExcelReader implements IReader{
	 private String inputFile;

	  public ExcelReader(String inputFile) {
	    this.inputFile = inputFile;
	  }
	
	@Override
	public Object[][] read() {
		Object[][] o = null;
		File input = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(input);
			Sheet sheet = w.getSheet(0);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			o = new Object[rows][columns];
			System.out.println("ROWS = " +rows);
			System.out.println("COLUMNS = " +columns);
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < columns; j++){
					System.out.println( i + " <<<--->>>  " +j);
					Cell cell = sheet.getCell(j, i);
					o[i][j] = cell.getContents();
					System.out.println(cell.getContents());
				}
			}
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		return o;
	}

}
