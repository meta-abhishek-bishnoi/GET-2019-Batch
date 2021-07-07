package meta.consolTest;

import meta.utility.Allot;
import meta.utility.Course;
import meta.utility.Loader;
import meta.utility.MyQueue;
import meta.utility.Student;
import meta.utility.WriteData;

public class Main {

	public static void main(String[] args) {
		Allot allot = new Allot();
		MyQueue<Student> students = allot.allotCources();
		WriteData.writeData(students);
	}

}
