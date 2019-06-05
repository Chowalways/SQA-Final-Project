import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FinalProjectTest {

	
	FinalProject proj = new FinalProject();
	Student[] students = new Student[50];
	School[] schools = new School[20];
	
	@Before
	void init() {
		//proj = new FinalProject();
	}
	
	
	@Test
	void testGetStudents() {
		try{
			students = proj.getStudents();
		}catch(IOException e) {
			e.printStackTrace();
		}
		assertNotNull(students);
		assertEquals(50, students.length);
	}

	@Test
	void testGetSchools() {
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		assertNotNull(schools);
		assertEquals(20, schools.length);
	}
	
	@Test
	void testSchoolQuota() {
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		for(School sch: schools) {
			assertTrue(sch.getQuota() > 0);	
			assertTrue(sch.getQuota() < 1000);
		}
		
	}
	
	@Test
	void testSchoolReq() { //test the minimum grade grade required
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		for(School school: schools) {
			assertTrue(school.getRequirement() >= 50.0 && school.getRequirement() < 100.0);
			assertThrows(InvalidRequirementException.class, ()-> {
				school.setRequirement(40.0);
			});
		}
	}
	
	@Test
	void testSchoolIsFull() {
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		int tempVal = schools[1].getQuota();
		for(int i = 0; i < tempVal; i++) {
			schools[1].updateEnrolled();
		}
		assertTrue(schools[1].isFull());
	}
	
	@Test
	void testStudentGrade() { 
		try{
			students = proj.getStudents();
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(Student std: students) {
			assertThrows(InvalidGradeException.class, ()-> {
				std.setGrade(150.0);
			});
		}
	}

	@Test
	void testSortStudents() {
		fail("Not yet implemented");
	}

	@Test
	void testDoEnrollment() {
		fail("Not yet implemented");
	}

}
