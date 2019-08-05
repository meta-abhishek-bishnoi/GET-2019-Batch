/**
 * This Class Defines a Structure for Adding Unique Employees 
 * Where Uniqueness defines from Employee Id
 * @author Abhishek Bishnoi
 * @since Aug 3, 2019
 */
package meta.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmployee {
	Employee employee;
	Set<Employee> employeeSet = new HashSet<Employee>();
	/**
	 * This Function add unique employees to Set
	 * @param employee Object Of Employee
	 * @return true or false value
	 * @exception AssertionError
	 */
	public boolean addEmployee(Employee employee){
		if(employee==null){
			throw new AssertionError(MESSAGES.NULL_OBJECT);
		}
		this.employee = employee;
		//System.out.println(employeeSet.add(employee));
		return employeeSet.add(employee);
	}
	/**
	 * This Function is use to getting Set<Employee>
	 * @return
	 */
	public Set<Employee> getEmployee(){
		return  employeeSet;
	}
	
}
