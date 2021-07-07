package meta.utility;

public class Employee{

	int employeeId;
	String employeeName;
	String employeeAddress;
	public Employee(int employeeId, String employeeName, String employeeAddress){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}
	@Override
	public boolean equals(Object o){
		return (o instanceof Employee) && this.employeeId == ((Employee)o).employeeId;
	}
	@Override
	public int hashCode(){
		return this.employeeId;
	}
}
