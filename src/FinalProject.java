import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {
	
	
	
	public static void main(String[] args) {
		
		Student students[] = new Student[50];
		School schools[] = new School[20];
		ArrayList<String> Admission = new ArrayList<String>();
		
		FinalProject proj = new FinalProject();
		
		try {
			students = proj.getStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			schools = proj.getSchools();
		} catch (IOException | InvalidRequirementException e) {
			e.printStackTrace();
		}
		
		proj.sortStudents(students);
		proj.doEnrollment(schools, students);

	}
	
	public Student[] getStudents() throws IOException{
		File file = new File("studentData1.txt");
		Scanner input = new Scanner(file);
		Student students[] = new Student[50];
		
		int i = 0;
		while(input.hasNext()) {
			
			Student std = new Student();
			String name = input.next();
			Double grade = Double.valueOf(input.next());
			String choice1 = input.next();
			String choice2 = input.next();
			String choice3 = input.next();
			
			std.setName(name);
			try {
				std.setGrade(grade);
			} catch (InvalidGradeException e) {
				
				e.printStackTrace();
			}
			std.setChoice1(choice1);
			std.setChoice2(choice2);
			std.setChoice3(choice3);
			std.setEnrolledStatus(false);
			
			students[i++] = std;
		}
		
		input.close();
		
		return students;
	}
	
	public School[] getSchools() throws IOException, InvalidRequirementException{
		File file = new File("schoolData.txt");
		Scanner input = new Scanner(file);
		School schools[] = new School[20];
		
		int i = 0;
		while(input.hasNext()) {
			
			School sch = new School();
			String name = input.next();
			int quota = Integer.valueOf(input.next());
			Double req = Double.valueOf(input.next());
			
			sch.setName(name);
			sch.setQuota(quota);
			sch.setRequirement(req);
			
			schools[i++] = sch;
		}
		
		input.close();
		
		return schools;
	}
	
	public void sortStudents(Student[] students) {
		
		for(int i = 0; i < students.length; i++) {
			Student temp;
			for(int j = i; j < students.length; j++) {
				if(students[i].getGrade() < students[j].getGrade()) {
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}
	
	public void doEnrollment(School[] sch, Student[] std) {
		
		for(int i = 0; i < 3; i++) {	
			for(School school: sch ) {
				for(Student student: std) {
					if(i == 0) {//For choice 1
						String choice = student.getChoice1();
						double grade = student.getGrade();
						if((student.getEnrolledStatus() == false) && grade >= school.getRequirement()) {
							if(school.getName().equals(choice) && (school.isFull() == false)) {
								student.setEnrolledStatus(true);
								school.updateEnrolled();
								school.updateEnrolledStudents(student);
								
							}
						}
					}
					
					if(i == 1) {//For choice 2
						String choice = student.getChoice2();
						double grade = student.getGrade();
						if((student.getEnrolledStatus() == false) && grade >= school.getRequirement()) {
							if(school.getName().equals(choice) && (school.isFull() == false)) {
								student.setEnrolledStatus(true);
								school.updateEnrolled();
								school.updateEnrolledStudents(student);
								System.out.println("adding 2");
							}
						}
					}
					
					if(i == 2) { //For choice 3
						String choice = student.getChoice3();
						double grade = student.getGrade();
						if((student.getEnrolledStatus() == false) && grade >= school.getRequirement()) {
							if(school.getName().equals(choice) && (school.isFull() == false)) {
								student.setEnrolledStatus(true);
								school.updateEnrolled();
								school.updateEnrolledStudents(student);
								System.out.println("adding 3");
							}
						}
					}
				}
			}
			
		}
	}
	
	
}
