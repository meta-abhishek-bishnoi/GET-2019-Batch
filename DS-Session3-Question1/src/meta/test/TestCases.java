/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This class contains all test cases of Directory System
 */
package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import utility.Directory;
import utility.Service;

public class TestCases {

	@Test
	public void mkdirTest_HappyFlow() {
		Date date=java.util.Calendar.getInstance().getTime();
		Directory root = new Directory("root", null, date,"root");
		List<String> directories = Arrays.asList(new String[]{"test1","test2"});
		assertTrue(Service.createDir(directories, root));
	}

	@Test(expected = AssertionError.class)
	public void addChildMap_Exception_DirectoryObjectIsNull(){
		Date date=java.util.Calendar.getInstance().getTime();
		Directory root = new Directory("root", null, date,"root");
		root.addDirectoryToMap(null);
	}
	
	@Test
	public void cdTest_HappyFlow(){
		Date date=java.util.Calendar.getInstance().getTime();
		Directory root = new Directory("root", null, date,"root");
		List<String> directories = Arrays.asList(new String[]{"abhi","meta"});
		Service.createDir(directories, root);
		String expectd = "root/abhi";
		String actual = Service.changeDir("abhi", root).getPath();
		assertEquals(expectd,actual);
	}
	
	@Test(expected = AssertionError.class)
	public void getDateTest_Exception_DateIsNull(){
		Service.getDate(null);
	}
	
	@Test
	public void findTest_HappyFlow(){
		Date date=java.util.Calendar.getInstance().getTime();
		Directory root = new Directory("root", null, date,"root");
		List<String> directories = Arrays.asList(new String[]{"abhi","meta","metacube"});
		Service.createDir(directories, root);
		String expectd = "root/meta"+"\n"+"root/metacube"+"\n";
		String actual = Service.findDir("meta", root);
		assertEquals(expectd,actual);
	}
}
