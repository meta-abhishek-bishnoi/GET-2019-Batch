/**
 * This is Structure Class Of Employee Which provides various methods 
 * @author Abhishek Bishnoi
 * @since Aug 3, 2019
 */
package meta.utility;

public class Employee{

	int employeeId;
	String employeeName;
	String employeeAddress;
	/**
	 * This Constructor is used for setting variable of employee
	 * @param employeeId
	 * @param employeeName
	 * @param employeeAddress
	 */
	public Employee(int employeeId, String employeeName, String employeeAddress){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	/**
	 * Getter Method of Employee id
	 * @return
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}
	/**
	 * @java.lang.Override
	 * Method Overriding for checking object  on the basis of employee id
	 * If Employee id is same for 2 objects then they are duplicate for each other
	 */
	@Override
	public boolean equals(Object o){
		return (o instanceof Employee) && this.employeeId == ((Employee)o).employeeId;
	}
	/**
	 * @java.lang.Override
	 * Method Overriding for getting Object of Object
	 * Here Hashcode is employee id itself
	 */
	@Override
	public int hashCode(){
		return this.employeeId;
	}
}
