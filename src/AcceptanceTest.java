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
	ArrayList<School> schools; // this is a hash map!!
	
	@Before
	void init() {
		students = project.getStudents;
		schools = project.getSchools;
		assertNotNull(students);
		assertNotNull(schools);
	}

	@Test
	void testSchoolQuota() throws NumberFormatException {
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
	void testSchoolReq() {
		School sc = new School();
		sc.setRequirement(60.0);
		assertEquals(sc.getRequirement, 60.0);
		
		for(School school: schools) {
			assertTrue(school.getRequirement >= 50.0 && school.getRequirement < 100.0);
		}
	}
	
	@Test
	void testSchoolIsFull() {
		School temp = new School();
		temp.setQuota(0);
		assertEquals(temp.isFull, true);
	}
	
	@Test
	void testSchoolHasSpace() {
		School temp = new School();
		temp.setQuota(5);
		
		assertEquals(temp.isFull, false);
	}
	
	@Test
	void testStudentGrades() {
		for(Student student : students) {
			assertTrue(student.getGrade >= 40.0);
			assertTrue(student.getGrade <= 100.0);
			
		}
		Student tempStd = new Student();
		tempStd.setGrade = 59.0;
		assertEquals(tempStd.getGrade, 59.0);
	}
	
	@Test
	void testStudentChoices() throws StudentChoicesException{
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
	
	//TODO: implement mockito test case. I totally forgot how to install mockito

}
