
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class FinalProjectTest {

	
	FinalProject proj = new FinalProject();
	Student[] students = new Student[50];
	School[] schools = new School[20];
	FinalProject toMock;
	
	@Before
	public void init() {
		//proj = new FinalProject();
		
	}
	
	
	@Test
	public void testGetStudents() throws InvalidGradeException {
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
	public void testGetSchools() {
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		assertNotNull(schools);
		assertEquals(20, schools.length);
	}
	
	@Test
	public void testSchoolQuota() {
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
	
	@Test(expected = InvalidRequirementException.class)
	public void testSchoolReq() throws InvalidRequirementException { //test the minimum grade grade required
		try{
			schools = proj.getSchools();
		}catch(IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		for(School school: schools) {
			assertTrue(school.getRequirement() >= 50.0 && school.getRequirement() < 100.0);
			school.setRequirement(40.0);
		}
	}
	
	@Test
	public void testSchoolIsFull() {
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
	
	@Test(expected = InvalidGradeException.class)
	public void testStudentGrade() throws InvalidGradeException { 
		try{
			students = proj.getStudents();
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(Student std: students) {
			
				std.setGrade(150.0);
		
		}
	}

	@Test
	public void testDoEnrollment() throws InvalidRequirementException, InvalidGradeException {
		School[] schools = new School[1];
		Student[] students = new Student[1];
		
		
		Student std1 = new Student();
		std1.setName("john");
		std1.setGrade(80.0);
		std1.setChoice1("FCU");
		std1.setChoice2("BHS");
		std1.setChoice3("WAHS");
		
		School sch1 = new School();
		sch1.setName("FCU");
		sch1.setQuota(2);
		sch1.setRequirement(60);
	
		students[0] = std1;
		schools[0] = sch1;
		

		proj.doEnrollment(schools, students);
		for(School sch: schools) {
			assertFalse(sch.getEnrolledStudents().isEmpty());
		}
		
		ArrayList<Student> stud = schools[0].getEnrolledStudents(); 
		assertTrue(stud.size() == 1);
	}

}
