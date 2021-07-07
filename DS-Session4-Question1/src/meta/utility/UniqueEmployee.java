package meta.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmployee {
	Employee employee;
	Set<Employee> employeeSet = new HashSet<Employee>();
	public boolean addEmployee(Employee employee){
		if(employee==null){
			throw new AssertionError(MESSAGES.NULL_OBJECT);
		}
		this.employee = employee;
		//System.out.println(employeeSet.add(employee));
		return employeeSet.add(employee);
	}
	
	public Set<Employee> getEmployee(){
		return  employeeSet;
	}
	
}
