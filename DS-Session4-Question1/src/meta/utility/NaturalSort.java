package meta.utility;


public class NaturalSort implements Comparable<NaturalSort> {

	Employee employee;
	public NaturalSort(Employee employee){
		if(employee==null){
			throw new AssertionError(MESSAGES.NULL_OBJECT);
		}
		this.employee = employee;
	}
	public int getEmployeeId() {
		return this.employee.getEmployeeId();
	}

	public String getEmployeeName() {
		return this.employee.getEmployeeName();
	}

	public String getEmployeeAddress() {
		return this.employee.getEmployeeAddress();
	}
	
	@Override
	public int compareTo(NaturalSort o2) {
		return this.employee.getEmployeeId()-o2.employee.getEmployeeId();
	}
}
