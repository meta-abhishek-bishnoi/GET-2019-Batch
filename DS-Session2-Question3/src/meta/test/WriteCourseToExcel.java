package meta.test;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
public class WriteCourseToExcel {
		public static void main(String[] args) {
			final String filePath = "shortlist.xls";
			  WritableWorkbook workBook = null;
			  try{
				  workBook = Workbook.createWorkbook(new File(filePath));
				  WritableSheet excelSheet = workBook.createSheet("shortlisted", 0);
				  Label label = new Label(0, 0, "Rank");
				  excelSheet.addCell(label);
				  label = new Label(1, 0, "Student Id");
				  excelSheet.addCell(label);
				  label = new Label(2, 0, "Full Name");
				  excelSheet.addCell(label);
				  label = new Label(3, 0, "Choice 1");
				  excelSheet.addCell(label);
				  label = new Label(4, 0, "Choice 2");
				  excelSheet.addCell(label);
				  label = new Label(5, 0, "Choice 3");
				  excelSheet.addCell(label);
				  label = new Label(6, 0, "Choice 4");
				  excelSheet.addCell(label);
				  label = new Label(7, 0, "Choice 5");
				  excelSheet.addCell(label);
				 String StudentId[]={"Meta-05","Meta-09","Meta-20","Meta-14","Meta-15",
						 "Meta-25","Meta-04","Meta-01","Meta-11","Meta-17","Meta-12","Meta-02"};
				 String studentName[]={"Abhishek","Babbar","Yatika","Manoj","Bharat","Rahul",
						 "Harsh","Radheshyam","Bharti","kiran","Arav","Sahil"};
				 String course[]={"B.Tech-CSE","B.Tech-IT","B.Tech-ECE","B.Tech-EE","B.Tech-ME","B.Tech-Civil","BCA","BSC-CSE"};
				  for(int i=1; i<=8; i++){
					  Number rank = new Number(0, i, i);
					  Label id = new Label(1,i,StudentId[i-1]);
					  Label name= new Label(2,i,studentName[i-1]);
					  Label choice1=new Label(3,i,course[(1+i+7)%7]);
					  Label choice2=new Label(4,i,course[(2+i+7)%7]);
					  Label choice3=new Label(5,i,course[(3+i+7)%7]);
					  Label choice4=new Label(6,i,course[(4+i+7)%7]);
					  Label choice5=new Label(7,i,course[(5+i+7)%7]);
					  excelSheet.addCell(rank);
					  excelSheet.addCell(id);
					  excelSheet.addCell(name);
					  excelSheet.addCell(choice1);
					  excelSheet.addCell(choice2);
					  excelSheet.addCell(choice3);
					  excelSheet.addCell(choice4);
					  excelSheet.addCell(choice5);
					  
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
