
public class Student implements Comparable<Object>{
	private String name;
	private double grade;
	private String choice1;
	private String choice2;
	private String choice3;
	private boolean status;
	
	public Student(){
		name = "N/A";
		grade = 60;
		choice1 = "N/A";
		choice2 = "N/A";
		choice3 = "N/A";
		status = false;
	}
	
	//setter
	public void setName(String n) {
		name = n;
	}
	public void setGrade(double g) {
		grade = g;
	}
	public void setChoice1(String c1) {
		choice1 = c1;
	}
	public void setChoice2(String c2) {
		choice2 = c2;
	}
	public void setChoice3(String c3) {
		choice3 = c3;
	}
	public void setStatus(boolean s) {
		status = s;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public double getGrade() {
		return grade;
	}
	public String getChoice1() {
		return choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public boolean getStatus() {
		return status;
	}
	
	public boolean isAccepted() {
		return status;
	}
	
	public void addInfo(String n, double g, String c1, String c2, String c3, boolean s) {
		name = n;
		grade = g;
		choice1 = c1;
		choice2 = c2;
		choice3 = c3;
		status = s;
	}
	
	@Override
	public int compareTo(Object obj) {
		Student other = (Student)obj;
		if(this.grade > other.grade) {
			return -1;
		}else if(this.grade < other.grade) {
			return 1;
		}else{
			return 0;
		}
	}
	
}
