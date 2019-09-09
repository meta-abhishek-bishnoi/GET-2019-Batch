package test;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
public class WriteCourseToExcel {
		public static void main(String[] args) {
			final String filePath = "testSet.xls";
			  WritableWorkbook workBook = null;
			  try{
				  workBook = Workbook.createWorkbook(new File(filePath));
				  WritableSheet excelSheet = workBook.createSheet("set1", 0);
				  int arrayData[] = {57, 26, 86, 56, 17};
				  for(int i=0; i<=arrayData.length; i++){
					  Number rank = new Number(i, 0, i);
					  excelSheet.addCell(rank);
				  }
		          workBook.write();
			  }catch(IOException | WriteException exception){
				  exception.printStackTrace();
			  }finally{
				  if(workBook!=null){
					  try {
						workBook.close();
					} catch (WriteException | IOException e) {
						e.printStackTrace();
					}
				  }
			  }
		}
}
