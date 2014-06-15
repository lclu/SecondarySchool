package extra_assignment;

public class Test {

	public static void main(String[] args) {
		Student Jan = new Student("Jan Vries", 100, 2014);
		Student Piet = new Student("Piet Bakker", 102, 2012);
		Student Henk = new Student("Henk Visser", 107, 2010);
		
		Course Analyse = new Course("Analyse", "TW1070", "01-09-2013", "01-01-2014");
		Course Kans = new Course("Kansrekening", "TW1080", "01-09-2012", "01-01-2013");
		Course Algebra = new Course("Algebra", "TW1060", "01-09-2010", "01-01-2011");
		
		Jan.addCourse(Analyse);
		Jan.addCourse(Algebra);
		
		Kans.addStudent(Henk);
		Kans.addStudent(Piet);
		

		System.out.println(Jan.toString());
		System.out.println(Analyse.toString());
		
		System.out.println("Jan is not taking any courses: " + Jan.isEmpty());
		System.out.println("Jan is taking TW1080: " + Jan.checkCourse("TW1080"));

		System.out.println();
		
		System.out.println("Jan is not taking Analyse anymore: ");
		Jan.removeCourse(Analyse);
		System.out.println(Jan.toString());
		System.out.println(Analyse.toString());

		System.out.println();
		
		System.out.println(Kans.isEmpty());
		System.out.println(Kans.toString());
	}

}
