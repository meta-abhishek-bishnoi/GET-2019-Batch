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
	public List<Employee> sort(){
		Employee firstFollower;
		Employee first;
		Employee lastFollower;
		Employee last;
		int size = size();
		for(int i=0; i<size()-2; i++){
			for(int j=i+1; j<size()-1; j++){
				if(i == 0){
					
				}
			}
		}
		return null;
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
}
