package extra_assignment;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class TestSystem {

	public static void main(String[] args) {
		
		//create basis
		System.out.println("- Create a new school system");
	
		System.out.print("SchoolSystem secondary = new SchoolSystem();");
		SchoolSystem secondary = new SchoolSystem();
		
		System.out.println("\n");
		
		System.out.println("- Create new students");
		
		System.out.println("Student Susan = new Student(\"Susan White\", 4382, 20160901);");
		Student Susan = new Student("Susan White", 4382, 20160901);
		System.out.println("Student James = new Student(\"James Smith\", 1843, 20140901);");
		Student James = new Student("James Smith", 1843, 20140901);
		System.out.println("Student Mary = new Student(\"Mary Brown\", 5931, 20120901);");
		Student Mary = new Student("Mary Brown", 5931, 20120901);
		System.out.println("Student David = new Student(\"David Miller\", 7592, 20100901);");
		Student David = new Student("David Miller", 7592, 20100901);
		
		System.out.println();
		
		System.out.println("- Create new courses");
		
		System.out.println("Course Calculus = new Course(\"Calculus\", \"TW1080\", 20150101, 20150630);");
		Course Calculus = new Course("Calculus", "TW1080", 20150101, 20150630);
		System.out.println("Course Analysis = new Course(\"Analysis\", \"TW1070\", 20130101, 20130630);");
		Course Analysis = new Course("Analysis", "TW1070", 20130101, 20130630);
		System.out.println("Course Algebra = new Course(\"Algebra\", \"TW1060\", 20110101, 20110630);");
		Course Algebra = new Course("Algebra", "TW1060", 20110101, 20110630);
		System.out.println("Course Statistics = new Course(\"Statistics\", \"TW1050\", 20090101, 20090630);");
		Course Statistics = new Course("Statistics", "TW1050", 20090101, 20090630);
				
		System.out.println();
		
		//first test
		System.out.println("-- Test 1: Add students and courses to the system: \n");
		
		System.out.println("Is the school system empty?: " + secondary.isEmpty());
		
		System.out.println();
	
		System.out.println("secondary.addStudent(Susan); " + secondary.addStudent(Susan));
		System.out.println("secondary.addStudent(James); " + secondary.addStudent(James));
		System.out.println("secondary.addStudent(Mary); " + secondary.addStudent(Mary));
		//System.out.println("secondary.addStudent(David); " + secondary.addStudent(David));
		
		System.out.println();
		
		System.out.println("Is the school system empty? " + secondary.isEmpty());
		
		System.out.println();
		
		System.out.println("Number of students: " + secondary.numberStudents() + "\n");
		
		System.out.println("- Students in system: ");
		secondary.toStringStudents();
		System.out.println();
		
		System.out.println("David (7592) is in the system: " + secondary.search(7592));
		System.out.println("Mary (5931) is in the system: " + secondary.search(5931));
		
		System.out.println();

		System.out.println("secondary.addCourse(Calculus); " + secondary.addCourse(Calculus));
		System.out.println("secondary.addCourse(Analysis); " + secondary.addCourse(Analysis));
		//System.out.println("secondary.addCourse(Algebra); " + secondary.addCourse(Algebra));
		//System.out.println("secondary.addCourse(Statistics); " + secondary.addCourse(Statistics));
					
		System.out.println();
		
		System.out.println("Is the school system empty? " + secondary.isEmpty());
		
		System.out.println();
		
		System.out.println("Number of courses: " + secondary.numberCourses() + "\n");
		
		System.out.println("- Courses in system: ");
		secondary.toStringCourses();
		System.out.println();
		
		
		//second test
		System.out.println("-- Test 2: Removing students and courses from the system: \n");
		
		System.out.println("secondary.removeStudent(Susan); " + secondary.removeStudent(Susan) + "\n");
		
		//System.out.println(secondary.students.searchStudent((Integer)4382, secondary.students.getRoot()));
		//System.out.println(secondary.students.searchStudent((Integer)5931, secondary.students.getRoot()));
		
		//System.out.println("secondary.students.remove(4382)");
		//System.out.println(secondary.students.remove(4382));
		
		System.out.println("Susan (4382) is in the system: " + secondary.search(4382));
		System.out.println("David (7592) is in the system: " + secondary.search(7592));
		System.out.println("Mary (5931) is in the system: " + secondary.search(5931));
		
		System.out.println("Number of students: " + secondary.numberStudents() + "\n");
		
		System.out.println("- Students in system: ");
		secondary.toStringStudents();
		System.out.println();
		
		
		System.out.println();
		
		System.out.println("Number of courses: " + secondary.numberCourses() + "\n");
		
		System.out.println("- Courses in system: ");
		secondary.toStringCourses();
		System.out.println();
		
		//empty system
		System.out.println("- Empty the system.");
		System.out.println("secondary.makeEmpty();");
		secondary.makeEmpty();
		System.out.println();
		
		System.out.println("Is the school system empty? " + secondary.isEmpty());
		
	}
}
