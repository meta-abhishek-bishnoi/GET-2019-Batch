package meta.model;
/**
 * This Class for Student following pojo's
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019 
 *
 */
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String email;
	private String className;
	private int age;
	public Student() {
		super();
	}
	public Student(String firstName, String lastName, String fatherName,
			String email, String className, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.className = className;
		this.age = age;
	}
	
	public Student(int id, String firstName, String lastName,
			String fatherName, String email, String className, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.className = className;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
