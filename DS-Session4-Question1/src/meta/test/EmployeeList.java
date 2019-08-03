package meta.test;

import java.util.ArrayList;
import java.util.List;

import meta.utility.Employee;

public class EmployeeList {
	public static List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"Abhishek Bishnoi","Raisinghnagar"));
		list.add(new Employee(2,"Yatika Bansal","Jodhpur"));
		list.add(new Employee(8,"Tarun Verma","Bikaner"));
		list.add(new Employee(12,"Ram Narayan","Jodhpur"));
		list.add(new Employee(4,"Monika Suthar","Suratgarh"));
		list.add(new Employee(1,"Abhishek Bishnoi","Raisinghnagar"));
		return list;
	}
}
