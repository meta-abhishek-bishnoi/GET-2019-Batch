package meta.test;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadFromExcel {
	public static void main(String[] args) {
		final String filePath = "course.xls";
		  Workbook workBook = null;
		  try{
			  workBook = Workbook.getWorkbook(new File(filePath));
			  Sheet sheet = workBook.getSheet(0);
			  int row = sheet.getColumn(0).length; // to get element in a cell
			  int col = sheet.getRow(0).length;
			  for(int i=1; i<row; i++){
				  for(int j=0; j<col; j++){
					  Cell current = sheet.getCell(j,i);
					  System.out.print(current.getContents()+" ");
				  }
				  System.out.println();
			  }
		  }catch(IOException | BiffException  exception){
			  exception.printStackTrace();
		  }finally{
			  if(workBook!=null){
					workBook.close();
			  }
		  }
	}
}
