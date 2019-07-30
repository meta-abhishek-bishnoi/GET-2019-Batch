package meta.utility;

public class ClassQueue implements Queue{
	Course queueCourse[];
	int insertIndex=0;
	int deteletIndex=0;
	public ClassQueue(int size){
		queueCourse = new Course[size];
	}

	@Override
	public boolean add(Object t) {
		if(insertIndex<=size()-1){
			queueCourse[insertIndex] = (Course)t;
			insertIndex++;
		}else{
			return false;
		}
		return true;
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public int size() {
		return queueCourse.length;
	}
}
