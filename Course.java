package extra_assignment;

import java.util.*;

public class Course {

	/** Attributes */
	private String name;
	private String id; //course id
	private int start; //date start course
	private int end; //date end course
	public Map <Integer, Student> students; //students attending
	
	
	/** Constructor */
	public Course(String na, String idIn, int st, int en) {
		name = na;
		id = idIn;
		start = st;
		end = en;
		students = new HashMap<Integer, Student>();
	}
	
	
	/** Methods */
	public void setName(String nameIn) { name = nameIn; }
	
	public String getName() { return name; }
	
	public void setId(String idIn) { id = idIn; }
	
	public String getId() { return id; }
	
	public void setStart(int startIn) { start = startIn; }
	
	public int getStart() { return start; }
	
	public void setEnd(int endIn) { end = endIn; }
	
	public int getEnd() { return end; }
	
	public boolean enroll(Student studentIn) {
		Integer keyIn = studentIn.getNumber();
		
		if (studentIn.getStart() > start) {
			return false;
		}
		
		if (students.containsKey(keyIn)) {
			return false;
		}
		students.put(keyIn, studentIn);
		studentIn.courses.put(getId(), this);
		return true;
	}
	
	public boolean withdraw(Student studentIn) {
		if (students.remove(studentIn.getNumber()) != null) {
			studentIn.courses.remove(getId());
			return true;
		}
		return false;
	}
	
	public boolean checkStudent(Integer numberIn) {
		if (students.get(numberIn) != null) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (students.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int totalStudents() {
		return students.size();
	}
	
	public Set<Student> getCourses() {
		Set<Student> studentSet = new HashSet<Student>();
		Set<Integer> keys = students.keySet();
		
		for (Integer id : keys) {
			Student temp = students.get(id);
			studentSet.add(temp);
		}
		
		return studentSet;
	}
	
	public String toString() {
		String s = name + " profile: \n" + getId() + ", " + getName() + "\n" + "Students:" + "\n";
		Set<Integer> keys = students.keySet();
		
		for (Integer number : keys) {
			s += number + " " + students.get(number).getName() + "\n";
		}
		return s;
	}
}
