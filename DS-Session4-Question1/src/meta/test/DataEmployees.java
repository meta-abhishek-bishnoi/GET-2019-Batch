package meta.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import meta.utility.Employee;
import meta.utility.NaturalSort;
import meta.utility.SortByName;

public class DataEmployees {
	public static List<Employee> dataEmployee;
	public static List<NaturalSort> sortedEmployeeId;
	public static List<SortByName> sortedEmployeeName;
	public static Set<Employee> uniqueEmployee;
	public static void setDataSet(){
		dataEmployee = new ArrayList<Employee>();
		sortedEmployeeId = new ArrayList<NaturalSort>();
		sortedEmployeeName = new ArrayList<SortByName>();
		uniqueEmployee = new HashSet<Employee>();
		Employee emp1 = new Employee(1,"Abhishek Bishnoi","SGNR");
		Employee emp2 = new Employee(2,"Manoj Sharma","JPR");
		Employee emp3 = new Employee(1,"Abhishek Bishnoi","SGNR");
		Employee emp4 = new Employee(3,"Yatika Bansal","JPR");
		Employee emp5 = new Employee(4,"Shresh Khandewal","JPR");
		dataEmployee.add(emp1);
		dataEmployee.add(emp2);
		dataEmployee.add(emp3);
		dataEmployee.add(emp4);
		dataEmployee.add(emp5);
		//
		sortedEmployeeId.add(new NaturalSort(emp1));
		sortedEmployeeId.add(new NaturalSort(emp3));
		sortedEmployeeId.add(new NaturalSort(emp2));
		sortedEmployeeId.add(new NaturalSort(emp4));
		sortedEmployeeId.add(new NaturalSort(emp5));
		//
		sortedEmployeeName.add(new SortByName(emp1));
		sortedEmployeeName.add(new SortByName(emp3));
		sortedEmployeeName.add(new SortByName(emp2));
		sortedEmployeeName.add(new SortByName(emp5));
		sortedEmployeeName.add(new SortByName(emp4));
		//
		uniqueEmployee.add(emp1);
		uniqueEmployee.add(emp2);
		uniqueEmployee.add(emp4);
		uniqueEmployee.add(emp5);
	}
}
