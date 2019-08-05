package utility;

public class Employee {
	int empid;
	String name;
	int salary;
	int age;
	Employee next;
	public Employee(int empid, String name, int salary, int age){
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public int getEmpid() {
		return empid;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public int getAge() {
		return age;
	}
	
}
