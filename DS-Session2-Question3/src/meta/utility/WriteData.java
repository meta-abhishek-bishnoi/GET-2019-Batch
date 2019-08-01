/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 * This Class Write Data To Excel File from Queue
 */
package meta.utility;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteData {
	public static boolean writeData(MyQueue<Student> students){
		if(students==null){
			throw new AssertionError("Can't Perform On Null Object");
		}
		final String filePath = "admission.xls";
		 WritableWorkbook workBook = null;
		  try{
			  /**
			   * code to write into excel file
			   */
			  workBook = Workbook.createWorkbook(new File(filePath));
			  WritableSheet excelSheet = workBook.createSheet("list Students", 0); // creating sheet
			  /**
			   * adding label
			   */
			  Label label = new Label(0, 0, "Rank");
			  excelSheet.addCell(label);
			  label = new Label(1, 0, "Student Id");
			  excelSheet.addCell(label);
			  label = new Label(2, 0, "Student Name");
			  excelSheet.addCell(label);
			  label = new Label(3, 0, "Course Id");
			  excelSheet.addCell(label);
			  label = new Label(4, 0, "Course Name");
			  excelSheet.addCell(label);
			  int index=1;
			  /**
			   * writing all values to cells
			   */
			  while(students.size()!=0){
				  Student student = students.remove();
				  Number rank = new Number(0,index,student.getRank());
				  Label id = new Label(1,index,student.getStudentId());
				  Label name = new Label(2,index,student.getStudentName());
				  Label courseId = new Label(3,index,student.getCourseId());
				  Label courseName = new Label(4,index,student.getCourseName());
				  index++;
				  excelSheet.addCell(rank);
				  excelSheet.addCell(id);
				  excelSheet.addCell(name);
				  excelSheet.addCell(courseId);
				  excelSheet.addCell(courseName);
			  }
	          workBook.write(); // writing to workbook
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
		return true;
	}
}
