package meta.test;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
public class WriteStudentToExcel {
		public static void main(String[] args) {
			final String filePath = "course.xls";
			  WritableWorkbook workBook = null;
			  try{
				  workBook = Workbook.createWorkbook(new File(filePath));
				  WritableSheet excelSheet = workBook.createSheet("course", 0);
				  Label label = new Label(0, 0, "Course Id");
				  excelSheet.addCell(label);
				  label = new Label(1, 0, "Course Name");
				  excelSheet.addCell(label);
				  label = new Label(2, 0, "Available Seat");
				  excelSheet.addCell(label);
				  String courseId[] = {"CS","IT","EC","EE","ME","CE","BC","BCS"};
				  String course[]={"B.Tech-CSE","B.Tech-IT","B.Tech-ECE","B.Tech-EE","B.Tech-ME","B.Tech-Civil","BCA","BSC-CSE"};
				  int seats[]={70,45,40,40,70,40,25,25};
				  for(int i=1; i<=8; i++){
					  //Number courseNo = new Number(0, i, i);
					  Label id = new Label(0,i,courseId[i-1]);
					  Label courseName= new Label(1,i,course[i-1]);
					  Number seat = new Number(2,i,seats[i-1]);
					  //excelSheet.addCell(courseNo);
					  excelSheet.addCell(id);
					  excelSheet.addCell(courseName);
					  excelSheet.addCell(seat);
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
