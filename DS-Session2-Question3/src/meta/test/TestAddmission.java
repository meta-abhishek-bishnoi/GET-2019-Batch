/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 */
package meta.test;

import static org.junit.Assert.assertTrue;
import meta.utility.Allot;
import meta.utility.Course;
import meta.utility.MyQueue;
import meta.utility.Student;
import meta.utility.WriteData;

import org.junit.Test;

public class TestAddmission {
	
	@Test
	public void addObjectToQueue_HappyFlow(){
		MyQueue<Course> queue = new MyQueue<Course>();
		assertTrue(queue.add(new Course("A","A",1)));
		assertTrue(queue.add(new Course("B","B",0)));
		assertTrue(queue.add(new Course("AB","AB",4)));
		assertTrue(queue.add(new Course("BD","BD",5)));
	}
	
	@Test(expected = AssertionError.class)
	public void  addObject_Exception_NullObbject(){
		MyQueue<Course> queue = new MyQueue<Course>();
		assertTrue(queue.add(null));
	}
	
	@Test
	public void testLoadingFiles_HappyFlow(){
		Allot allot = new Allot();
		assertTrue(allot.isLoading());
	}
	
	@Test
	public void testWritingFiles_HappyFlow(){
		Allot allot = new Allot();
		MyQueue<Student> students = allot.allotCources();
		assertTrue(WriteData.writeData(students));
	}
	
	@Test (expected = AssertionError.class)
	public void testWritingFiles_Exception_WhenQueueIsNull(){
		assertTrue(WriteData.writeData(null));
	}
}
