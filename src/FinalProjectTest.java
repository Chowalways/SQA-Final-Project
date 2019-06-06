import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FinalProjectTest {

	
	FinalProject proj = new FinalProject();
	Student[] students = new Student[50];
	School[] schools = new School[20];
	FinalProject toMock;
	
	@Before
	public void init() {
		//proj = new FinalProject();
		
	}
	
	
	@Test
	void testGetStudents() throws InvalidGradeException {
		toMock = mock(FinalProject.class);
		try{
			students = proj.getStudents();
		}catch(IOException e) {
			e.printStackTrace();
		}
		assertNotNull(students);
		assertEquals(50, students.length);
		Student std1 = new Student();
		std1.setName("john");
		std1.setGrade(80.0);
		std1.setChoice1("FCU");
		std1.setChoice2("BHS");
		std1.setChoice3("WAHS");
		Student std2 = new Student();
		std2.setName("Jack");
		std2.setGrade(60.0);
		std2.setChoice1("NTPU");
		std2.setChoice2("FCU");
		std2.setChoice3("NTU");
		Student std3 = new Student();
		std3.setName("Sammy");
		std3.setGrade(65.0);
		std3.setChoice1("KKU");
		std3.setChoice2("NTSU");
		std3.setChoice3("FLU");
		
		Student[] students = new Student[3];
		students[0] = std1;
		students[1] = std2;
		students[2] = std3;
		try {
			when(toMock.getStudents()).thenReturn(students);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(students[0].getChoice1(), "FCU");
		assertTrue(students[2].getGrade() > 50.0);
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
