import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class AcceptanceTest {
	
	FinalProject project;
	
	ArrayList<Student> students; // Student class has getters for: <Student name, Grade, Choice 1, Choice 2, Choice 3, isAccepted>
	ArrayList<School> schools;  // School class has getters for : <School name, school acceptance Quota and school minimum grade>
	
	@Before
	void init() {//initialize variables
		students = project.getStudents;
		schools = project.getSchools;
		assertNotNull(students);
		assertNotNull(schools);
	}

	@Test
	void testSchoolQuota() throws NumberFormatException {// check the quota of each school
		for(School school: schools) {
			assertTrue(school.getQuota > 0);
			assertTrue(school.getQuota < 200); //Is an upper limit necessary?
			try {
				int temp = Integer.parseInt(school.getQuota.toString());
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
	}
	
	@Test
	void testSchoolReq() { //test the minimum grade grade required
		School sc = new School();
		sc.setRequirement(60.0);
		assertEquals(sc.getRequirement, 60.0);
		
		for(School school: schools) {
			assertTrue(school.getRequirement >= 50.0 && school.getRequirement < 100.0);
		}
	}
	
	@Test
	void testSchoolIsFull() { //check if school is full
		School temp = new School();
		temp.setQuota(0);
		assertEquals(temp.isFull, true);
	}
	
	@Test
	void testSchoolHasSpace() { // check if there is still any space
		School temp = new School();
		temp.setQuota(5);
		
		assertEquals(temp.isFull, false);
	}
	
	@Test
	void testStudentGrades() { // test student grades
		for(Student student : students) {
			assertTrue(student.getGrade >= 40.0);
			assertTrue(student.getGrade <= 100.0);
			
		}
		Student tempStd = new Student();
		tempStd.setGrade = 59.0;
		assertEquals(tempStd.getGrade, 59.0);
	}
	
	@Test
	void testStudentChoices() throws StudentChoicesException{ // this is a custom Exception that inherits from Exception class
		try {
			for(Student student : students) {
				assertTrue(student[1] > 1);
				assertTrue(student[2] > 1);
				assertTrue(student[3] > 1);
				assertTrue(student[1] < 20);
				assertTrue(student[2] < 20);
				assertTrue(student[3] < 20);
				
			}
		}catch(StudentChoicesException stex) {
			stex.printStackTrace();
		}
		
	}
	
	@Test
	void testStudentIsAccepted() {
		Student std = new Student();
		std.setStatus(true);
		asssertTrue(std.getStatus);
		for(Student student: students) {
			assertTrue(student.getStatus == true || student.getStatus == false);
		}
	}
	
	@Test
	void doAcceptance() { // test the process of students applying to school and the results
		ArrayList<School> schools = new ArrayList<School>;
		ArrayList<Student> students = new ArrayList<Student>;
		School school = new School();
		School school2 = new School();
		School school3 = new School();
		School school4 = new School();
		School school5 = new School();
		Student student = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		school.addInfo("FCU", 50, 60.0);
		school2.addInfo("NCU", 200, 55.0);
		school3.addInfo("TCU", 1, 60.0);
		school4.addInfo("NCCU", 150, 70.0);
		school5.addInfo("TKU", 20, 80.0);
		student.addInfo("Jack", 86.3, "FCU", "TCU", "NCCU", false);
		student2.addInfo("Tony", 59.0, "TCU", "NCU", "FCU", false);
		student3.addInfo("Fred", 0.0, "NCU", "TCU", "NCCU", false);
		student4.addInfo("Tom", 75.0, "TCU", "TCU", "NCCU", false);
		schools.add(school);
		schools.add(school2);
		schools.add(school3);
		schools.add(school4);
		students.add(student);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		project.calResults(schools, students);
		assertEquals(project.schoolsApplied, 4);
		assertEquals(project.studentsAccepted, 3);
		assertEquals(project.schoolsFull, 1);
		assertTrue(school3.isFull);
		assertFalse(school.isFull);
		assertTrue(student.isAccepted);
		assertFalse(student3.isAccepted);
	}
	
	//TODO: 

}
