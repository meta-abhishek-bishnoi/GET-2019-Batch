package meta.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import meta.utility.Employee;
import meta.utility.NaturalSort;
import meta.utility.SortByName;
import meta.utility.UniqueEmployee;

public class TestEmployee {
	@BeforeClass
	public static void start(){
		DataEmployees.setDataSet();
	}
	List<Employee> dataEmployee = DataEmployees.dataEmployee;
	List<NaturalSort> sortedEmployeeId = DataEmployees.sortedEmployeeId;
	List<SortByName> sortedEmployeeName = DataEmployees.sortedEmployeeName;
	Set<Employee> uniqueEmployee = DataEmployees.uniqueEmployee;
	@Test
	public void sordById_HappyFlow() {
		List<NaturalSort> dataSet = new ArrayList<NaturalSort>();
		// adding data into List<Natural Sort
		for(Employee employee: dataEmployee){
			dataSet.add(new NaturalSort(employee));
		}
		// sorting as per id
		Collections.sort(dataSet);
		/**
		 * here we are checking id and employee name if they both are not same means 
		 * actual and expected employees are different.
		 */
		for(int i=0; i<dataSet.size(); i++){
			NaturalSort expected = sortedEmployeeId.get(i);
			NaturalSort actual = dataSet.get(i);
			int expectedId = expected.getEmployeeId();
			String expectedEmpName = expected.getEmployeeName();
			int actualId = actual.getEmployeeId();
			String actualEmpName = actual.getEmployeeName();
			// fails if condition is true
			if((expectedId != actualId) && (expectedEmpName != actualEmpName)){
				fail();
			}
		}
	}
	
	@Test
	public void sordByName_HappyFlow() {
		List<SortByName> dataSet = new ArrayList<SortByName>();
		// adding data into List<Natural Sort
		for(Employee employee: dataEmployee){
			dataSet.add(new SortByName(employee));
		}
		// sorting as per id
		Collections.sort(dataSet);
		/**
		 * here we are checking id and employee name if they both are not same means 
		 * actual and expected employees are different.
		 */
		for(int i=0; i<dataSet.size(); i++){
			SortByName expected = sortedEmployeeName.get(i);
			SortByName actual = dataSet.get(i);
			int expectedId = expected.getEmployeeId();
			String expectedEmpName = expected.getEmployeeName();
			int actualId = actual.getEmployeeId();
			String actualEmpName = actual.getEmployeeName();
			// fails if condition is true
			if((expectedId != actualId) && (expectedEmpName != actualEmpName)){
				fail();
			}
		}
	}
	
	@Test (expected = AssertionError.class)
	public void SortById_Exception_EmployeeIsNull(){
		new SortByName(null);
	}
	@Test (expected = AssertionError.class)
	public void SortByName_Exception_EmployeeIsNull(){
		new SortByName(null);
	}
	@Test (expected = AssertionError.class)
	public void uniqueEmployee_Exception_EmployeeIsNull(){
		UniqueEmployee ue = new UniqueEmployee();
		ue.addEmployee(null);
	}
}
