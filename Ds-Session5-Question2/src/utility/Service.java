package utility;

import java.util.List;

public class Service {
	Employee head;
	Employee last = null;
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public boolean addEmployee(Employee employee){
		if(employee == null){
			throw new AssertionError("Employee Can't Be Null");
		}
		if(last==null){
			head = employee;
			last = employee;
		}else{
			last.next = employee;
			last = last.next;
		}
		return true;
	}
	public void sort(){
		Employee current = head;
		Employee index = null;
		Employee temporary;
		while (current != null) {
			index = current.next;
			while (index != null) {
				if (current.getSalary() < index.getSalary()) {
					temporary = current;
					current = index;
					index = temporary;
				}
				if (current.getSalary() == index.getSalary()) {/*In case salary is equal then the one having the lower age would be given preference*/
					if (current.getAge() >= index.getAge()) {//Comparing age
						temporary = current;
						current = index;
						index = temporary;
					}
				}
				index = index.next;
			}
			current = current.next;
		}

	}
	/**
	 * 
	 */
	public int size(){
		int size=0;
		Employee current = head;
		while(current != null){
			size++;
			current = current.next;
		}
		return size;
	}
	/**
	 * 
	 */

}
