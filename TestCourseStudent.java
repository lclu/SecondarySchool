package extra_assignment;

public class TestCourseStudent {

	public static void main(String[] args) {
		
		//create basis
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
				
		System.out.println("\n");
		
		
		//first test
		System.out.println("-- Test 1: \n Testing Student class \n");
				
		System.out.println("- Add all the courses to Mary\'s profile:");

		System.out.print("Mary.enroll(Calculus); " + Mary.enroll(Calculus) +"\n");
				
		System.out.print("Mary.enroll(Analysis); " + Mary.enroll(Analysis) +"\n");

		System.out.print("Mary.enroll(Algebra); " + Mary.enroll(Algebra) + ", because course starts before Mary's first year" +"\n");

		System.out.print("Mary.enroll(Statistics); " + Mary.enroll(Statistics) + ", because course starts before Mary's first year" +"\n");
		
		System.out.println();
		
		System.out.println("- " + Mary.toString());
		
		System.out.println("- Amount of courses Mary is enrolled in: " + Mary.totalCourses());
		System.out.println("- Mary's courses list is empty: " + Mary.isEmpty());
		System.out.println("- Mary is enrolled in Analysis: " + Mary.checkCourse("TW1070"));
		
		
		System.out.println("- Mary is not taking Analysis anymore: ");
		System.out.println("Mary.withdraw(Analysis): " + Mary.withdraw(Analysis));
		
		System.out.println();
		
		System.out.println("- " + Mary.toString());
				
		System.out.println();
		
		System.out.println("- " + Susan.toString());
		
		System.out.println("- Amount of courses Susan is enrolled in: " + Susan.totalCourses());
		System.out.println("- Susan's courses list is empty: " + Susan.isEmpty());
		System.out.println("- Susan is enrolled in Analysis: " + Susan.checkCourse("TW1070"));
		
		System.out.println();
		
		//second test
		System.out.println("-- Test 2: \n Testing Course class \n");
				
		System.out.println("- Add all the students to Calculus\'s profile:");
		
		System.out.print("Calculus.enroll(Susan); " + Calculus.enroll(Susan) + ", because course starts before Susan's first year" +"\n");
				
		System.out.print("Calculus.enroll(James); " + Calculus.enroll(James) +"\n");

		System.out.print("Calculus.enroll(Mary); " + Calculus.enroll(Mary) + ", because already enrolled. \n");

		System.out.print("Calculus.enroll(David); " + Calculus.enroll(David) +"\n");
		
		System.out.println();
		
		System.out.println("- " + Calculus.toString());
				
		System.out.println("- Amount of students enrolled: " + Calculus.totalStudents());
		System.out.println("- Calculus' students list is empty: " + Calculus.isEmpty());
		System.out.println("- James is enrolled in Analysis: " + Calculus.checkStudent(1843));
		
		System.out.println();
		
		System.out.println("- " + Algebra.toString());
				
		System.out.println("- Amount of students enrolled: " + Algebra.totalStudents());
		System.out.println("- Algebra's students list is empty: " + Algebra.isEmpty());
		System.out.println("- James is enrolled in Algebra: " + Algebra.checkStudent(1843));
		
		System.out.println("- James is not taking Analysis anymore: ");
		System.out.println("Calculus.withdraw(James): " + Calculus.withdraw(James));

		System.out.println();
		
		System.out.println("- " + Calculus.toString());

	}

}
