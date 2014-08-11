package extra_assignment;

public class SchoolSystem {
	
	/** Attributes */
	 AvlTree students;
	 AvlTree courses;
	
	/** Constructor */
	public SchoolSystem() {
		students = new AvlTree();
		courses = new AvlTree();
	}
	
	/** Methods */
	
	public boolean addStudent(Student v) {
		
		if (students.insert(v.getNumber(), v)) {
			return true;
		}
		return false;
	}
	
	public String isEmpty() {
		if (students.isEmpty()) {
			if (courses.isEmpty()) {
				return "There are no students and courses.";
			}
			return "There are courses in the system.";
		}
		if (courses.isEmpty()) {
			return "There are students in the system."; 
		}
		return "There are students and courses in the system.";
	}
	
	public void makeEmpty() {
		students.makeEmpty();
		courses.makeEmpty();
	}
	
	
	public boolean addCourse(Course v) {
		return courses.insert(v.getId(), v);
	}
	
	public Object removeStudent(Student v) {
		return (students.remove(v.getNumber()).getValue() instanceof Student);
	}
	
	public Object removeCourse(Course v) {
		return (courses.remove(v.getId()).getValue() instanceof Course);
	}
	
	public int numberStudents() {
		return students.countNodes();
	}
	
	public int numberCourses() {
		return courses.countNodes();
	}
	
	public boolean search(Object k) {
		if (k instanceof Integer) {
			return students.search(k);
			}

		if (k instanceof String) {
			return courses.search(k);
			}

		return false;
	}
	
	public void toStringStudents() {
		students.inorder();
	}
	
	public void toStringCourses() {
		courses.inorder();
	}
	
}
