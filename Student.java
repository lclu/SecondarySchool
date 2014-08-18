package extra_assignment;

import java.util.*;

public class Student {

	/** Attributes */
	private String name; 
	private Integer number; //studentid
	private int start; //date start schoolcareer
	public Map <String, Course> courses; //attending courses
	
	
	/** Constructor */
	public Student(String na, Integer nu, int st) {
		name = na;
		number = nu;
		start = st;
		courses = new HashMap<String, Course>();
	}
	
	
	/** Methods */
	public void setName(String nameIn) { name = nameIn; }
	
	public String getName() { return name; }
	
	public void setNumber(Integer numberIn) { number = numberIn; }
	
	public Integer getNumber() { return number; }
	
	public void setStart(int startIn) { start = startIn; }
	
	public int getStart() { return start; }
	
	public boolean enroll(Course courseIn) {
		String keyIn = courseIn.getId();
		
		//check if course is given at the same time student is attending school
		if (courseIn.getStart() < start) {
			return false;
		}
		
		//check if already following course
		if (courses.containsKey(keyIn)) {
			return false;
		}
		courses.put(keyIn, courseIn); //add course to student's list
		courseIn.students.put(getNumber(), this); //add student to course's list
		return true;
	}
	
	public boolean withdraw(Course courseIn) {
		if (courses.remove(courseIn.getId()) != null) { //remove course from student's list succesful
			courseIn.students.remove(getNumber()); //remove student from course's list
			return true;
		}
		return false;
	}
	
	public boolean checkCourse(String idIn) {
		if (courses.get(idIn) != null) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (courses.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int totalCourses() {
		return courses.size();
	}
	
	public Set<Course> getCourses() {
		Set<Course> courseSet = new HashSet<Course>();
		Set<String> keys = courses.keySet();
		
		for (String id : keys) {
			Course temp = courses.get(id);
			courseSet.add(temp);
		}
		
		return courseSet;
	}
	
	public String toString() {
		String s = name + " profile: \n" + getNumber() + ", " + getName() + "\n" + "Courses:" + "\n";
		Set<String> keys = courses.keySet();
		
		for (String id : keys) {
			s += id + " " + courses.get(id).getName() + "\n";
		}
		return s;	
	}
	
}
