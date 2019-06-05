import java.util.ArrayList;
import java.util.Collections;

public class FinalProject {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<School> schools = new ArrayList<School>();
	private ArrayList<String> Admission = new ArrayList<String>();
	
	public FinalProject() {
		School school = new School();
		School school2 = new School();
		School school3 = new School();
		School school4 = new School();
		Student student = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		school.addInfo("FCU", 50, 60.0);
		school2.addInfo("NCU", 199, 60.0);
		school3.addInfo("TCU", 1, 60.0);
		school4.addInfo("NCCU", 150, 70.0);
		student.addInfo("Jack", 86.3, "FCU", "TCU", "NCCU", false);
		student2.addInfo("Tony", 59.0, "TCU", "NCU", "FCU", false);
		student3.addInfo("Fred", 50.0, "NCU", "TCU", "NCCU", false);
		student4.addInfo("Tom", 75.0, "TCU", "TCU", "NCCU", false);
		schools.add(school);
		schools.add(school2);
		schools.add(school3);
		schools.add(school4);
		students.add(student);
		students.add(student2);
		students.add(student3);
		students.add(student4);
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public ArrayList<School> getSchools(){
		return schools;
	}
	
	public void enroll(School school, Student student) {
		student.setStatus(true);
		school.setQuota(school.getQuota()-1);
		if(school.isFull()) {
			school.setRequirement(student.getGrade());
		}
		Admission.add(school.getName() + ": " + student.getName());
	}
	
	public void calResults(ArrayList<School> sc, ArrayList<Student> st) {
		students = st;
		schools = sc;
		Collections.sort(students);
		
		//Calculate Result
		for(Student student : students) {
			for(School school : schools) {
				if(!student.isAccepted() && student.getChoice1().equals(school.getName()) && student.getGrade()>=school.getRequirement() && school.getQuota()>-2) {
					enroll(school, student);
				}
			}
			for(School school : schools) {
				if(!student.isAccepted() && student.getChoice2().equals(school.getName()) && student.getGrade()>=school.getRequirement() && school.getQuota()>-2) {
					enroll(school, student);
				}
			}
			for(School school : schools) {
				if(!student.isAccepted() && student.getChoice3().equals(school.getName()) && student.getGrade()>=school.getRequirement() && school.getQuota()>-2) {
					enroll(school, student);
				}
			}
		}
		
		//Print Result
		Collections.sort(Admission);
		for(String str : Admission) {
			System.out.println(str);
		}
	}
	
	public int schoolsApplied() {
		return schools.size();
	}
	
	public int studentsApplied() {
		return students.size();
	}
	
	public int studentsAccepted() {
		int accepted = 0;
		for(Student student : students) {
			if(student.getStatus()) {
				accepted += 1;
			}
		}
		return accepted;
	}
	
	public int schoolsFull() {
		int full = 0;
		for(School school : schools) {
			if(school.isFull()) {
				full += 1;
			}
		}
		return full;
	}
}
