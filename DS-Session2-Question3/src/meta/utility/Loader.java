package meta.utility;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.Type;
import jxl.read.biff.BiffException;

public class Loader {
	/**
	 * @return
	 */
	public MyQueue<Course> loadCourses(){
		MyQueue<Course> courses = new MyQueue<Course>();
		String filePath = "course.xls";
		Workbook workBook = null;
		try{
			  workBook = Workbook.getWorkbook(new File(filePath));
			  Sheet sheet = workBook.getSheet(0);
			  int row = sheet.getColumn(0).length; // to get element in a cell
			  int col = sheet.getRow(0).length;
			  for(int i=1; i<row; i++){
					  String id = sheet.getCell(0,i).getContents();
					  String name = sheet.getCell(1,i).getContents();
					  NumberCell capacity = (NumberCell) sheet.getCell(2,i);
					  double available = capacity.getValue();
					  courses.add(new Course(id, name, (int)available));
			  }
		  }catch(IOException | BiffException  exception){
			  exception.printStackTrace();
		  }finally{
			  if(workBook!=null){
					workBook.close();
			  }
		  }
		return courses;
	}
	/**
	 * @return
	 */
	public MyQueue<Student> loadStudents(){
		MyQueue<Student> students = new MyQueue<Student>();
		String filePath = "shortlist.xls";
		Workbook workBook = null;
		try{
			  workBook = Workbook.getWorkbook(new File(filePath));
			  Sheet sheet = workBook.getSheet(0);
			  int row = sheet.getColumn(0).length; // to get element in a cell
			  int col = sheet.getRow(0).length;
			  for(int i=1; i<row; i++){
				      NumberCell cellRank = (NumberCell)sheet.getCell(0,i);
				      int rank = (int) cellRank.getValue();
					  String studentId = sheet.getCell(1,i).getContents();
					  String studentName = sheet.getCell(2,i).getContents();
					  String course[] = new String[5];
					  course[0] = sheet.getCell(3,i).getContents();
					  course[1] = sheet.getCell(4,i).getContents();
					  course[2] = sheet.getCell(5,i).getContents();
					  course[3] = sheet.getCell(6,i).getContents();
					  course[4] = sheet.getCell(7,i).getContents();
					  students.add(new Student(rank,studentId,studentName,course));
			  }
		  }catch(IOException | BiffException  exception){
			  exception.printStackTrace();
		  }finally{
			  if(workBook!=null){
					workBook.close();
			  }
		  }
		return students;
	}
}
