package meta.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import meta.utility.Employee;
import meta.utility.NaturalSort;
import meta.utility.SortByName;
import meta.utility.UniqueEmployee;

public class Main {
	public static void main(String[] args) {
		List<NaturalSort> listNaturalSort = new ArrayList<NaturalSort>();
		List<SortByName> listSortByName = new ArrayList<SortByName>();
		for(Employee employee : EmployeeList.getEmployees()){
			listNaturalSort.add(new NaturalSort(employee));
			listSortByName.add(new SortByName(employee));
		}
		Collections.sort(listNaturalSort);
		System.out.println("Natural Order:");
		for(NaturalSort sort: listNaturalSort){
			System.out.println(sort.getEmployeeId()+" "+sort.getEmployeeName()+" "+sort.getEmployeeAddress());
		}
		Collections.sort(listSortByName);
		System.out.println("Sort By Name Order:");
		for(SortByName sort: listSortByName){
			System.out.println(sort.getEmployeeId()+" "+sort.getEmployeeName()+" "+sort.getEmployeeAddress());
		}
		UniqueEmployee ue = new UniqueEmployee();
		for(Employee employee : EmployeeList.getEmployees()){
			ue.addEmployee(employee);
		}
		System.out.println("Employees After Removing Duplicate");
		Set<Employee> newList = ue.getEmployee();
		for(Employee employee: newList){
			System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getEmployeeAddress());
		}
		
	}
}
