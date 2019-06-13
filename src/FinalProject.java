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
		
		//To test if new enrollment status works
		for(int i = 0; i < schools.length; i++) {
			ArrayList<Student> stud = schools[i].getEnrolledStudents(); 
			for(Student std: stud) {
				System.out.println(std.getName());
			}
		}

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
		
		/*
		 * MY LOGIC
		 * 
		 * for student in students
		 *  	for choice in choices
		 *  		if student is enrolled break out of for loop
		 *  		if need to go to next choice break out of loop
		 *  		for school in schools
		 *  			do switch case on student choice from choice one to choice three
		 *  			if all requirements ok then add student to school and update info
		 *  			if all requirements ok but the school is full break out of this for loop and say we need to go to next choice
		 * */

		for(Student student: std) {

			for(int i = 0; i < 3; i++) {
				boolean goToNextChoice = false;
				double grade = student.getGrade();
				if(student.getEnrolledStatus() == true)
					break;
				for(School school: sch) {
					if(goToNextChoice)
						break;
					if(student.getEnrolledStatus() == true)
						break;
					
					switch(i) {
					case 0:
						if(grade >= school.getRequirement() && school.getName().equals(student.getChoice1()) && school.isFull() == false) {
							student.setEnrolledStatus(true);
							school.updateEnrolled();
							school.updateEnrolledStudents(student);
						}else if(grade >= school.getRequirement() && school.getName().equals(student.getChoice1()) && school.isFull() == true){
							goToNextChoice = true;
						}
					break;
					case 1:
						if(grade >= school.getRequirement() && school.getName().equals(student.getChoice2()) && school.isFull() == false) {
							student.setEnrolledStatus(true);
							school.updateEnrolled();
							school.updateEnrolledStudents(student);
						}else if(grade >= school.getRequirement() && school.getName().equals(student.getChoice2()) && school.isFull() == true){
							goToNextChoice = true;
						}
					break;
					case 2:
						if(grade >= school.getRequirement() && school.getName().equals(student.getChoice3()) && school.isFull() == false) {
							student.setEnrolledStatus(true);
							school.updateEnrolled();
							school.updateEnrolledStudents(student);
						}else if(grade >= school.getRequirement() && school.getName().equals(student.getChoice3()) && school.isFull() == true){
							goToNextChoice = true;
						}
					break;
					default:
						break;
						
					}
				}
			}
		}
	}
	
	
}
