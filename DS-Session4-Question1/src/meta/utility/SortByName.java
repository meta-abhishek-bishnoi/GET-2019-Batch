/**
 * This Class Defines ComapreTo() for Name Wise Sorting
 * @author Abhishek Bishnoi
 * @since Aug 3, 2019
 */
package meta.utility;

import java.util.Comparator;

public class SortByName implements Comparable<SortByName>{

	Employee employee;
	public SortByName(Employee employee){
		if(employee==null){
			throw new AssertionError(MESSAGES.NULL_OBJECT);
		}
		this.employee = employee;
	}
	public int getEmployeeId() {
		return employee.getEmployeeId();
	}

	public String getEmployeeName() {
		return employee.getEmployeeName();
	}

	public String getEmployeeAddress() {
		return employee.getEmployeeAddress();
	}
	/**
	 * @java.lang.Override
	 * Method Overriding for defining comparing objects 
	 * on the basis of employee name 
	 */
	@Override
	public int compareTo(SortByName obj) {
		return this.employee.getEmployeeName().compareTo(obj.employee.getEmployeeName());
	}

	
}
