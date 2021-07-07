/**
 * @author Abhishek Bishnoi
 * This class Contains test cases
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import utility.Employee;
import utility.Service;

public class TestClass {

	private static int resultEmployeeId[] = {5,3,1,4,2};
	private static Service service = new Service();
	@BeforeClass
	public static void init(){
		service.addEmployee(new Employee(1,"ABC",29000,24));
		service.addEmployee(new Employee(2,"ABC",25000,26));
		service.addEmployee(new Employee(3,"ABC",29000,22));
		service.addEmployee(new Employee(4,"ABC",27000,22));
		service.addEmployee(new Employee(5,"ABC",35000,26));
	}
	@Test
	public void addEmployee_HappyFlow() {
		assertTrue(new Service().addEmployee(new Employee(0,"Abhi",25000,22)));
	}
	@Test (expected=AssertionError.class)
	public void addEmployee_Exception_NullValue() {
		assertTrue(new Service().addEmployee(null));
	}
	@Test
	public void sortEmployees(){
		service.sort();
		List<Employee> employees = service.getList();
		for(int i=0; i<employees.size(); i++){
			System.out.println(employees.get(i).getEmpid());
			//assertEquals(resultEmployeeId[i],employees.get(i).getEmpid());
		}
	}
}
