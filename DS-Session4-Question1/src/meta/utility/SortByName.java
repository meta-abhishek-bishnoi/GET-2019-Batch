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
	@Override
	public int compareTo(SortByName obj) {
		return this.employee.getEmployeeName().compareTo(obj.employee.getEmployeeName());
	}

	
}
