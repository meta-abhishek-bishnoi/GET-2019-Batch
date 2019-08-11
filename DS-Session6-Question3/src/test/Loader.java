package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class Loader {
	public List<Integer> loadData(String string){
		List<Integer> list = new ArrayList<Integer>();
		String filePath = string;
		Workbook workBook = null;
		try{
			  workBook = Workbook.getWorkbook(new File(filePath));
			  Sheet sheet = workBook.getSheet(0);
			  int row = sheet.getColumn(0).length; // to get element in a cell
			  int col = sheet.getRow(0).length;
			  for(int i=1; i<row; i++){
				  for(int j=0; j<col; j++){
					  Cell current = sheet.getCell(j,i);
					  if(!current.equals(""))
						  list.add(Integer.parseInt(current.getContents()));
				  }
			  }
		  }catch(Exception  exception){
			  exception.printStackTrace();
		  }finally{
			  if(workBook!=null){
					workBook.close();
			  }
		  }
		return list;
	}
}
