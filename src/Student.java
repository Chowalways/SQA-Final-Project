
public class Student {
	private String name;
	private double grade;
	private String choice1;
	private String choice2;
	private String choice3;
	private boolean status;
	
	//setter
	public void setName(String n) {
		this.name = n;
	}
	public void setGrade(double g) throws InvalidGradeException {
		if(g < 0.0 || g > 100.0)
			throw new InvalidGradeException("not a valid Grade");
		else
			this.grade = g;
	}
	public void setChoice1(String c1) {
		this.choice1 = c1;
	}
	public void setChoice2(String c2) {
		this.choice2 = c2;
	}
	public void setChoice3(String c3) {
		this.choice3 = c3;
	}
	public void setEnrolledStatus(boolean s) {
		this.status = s;
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
	public boolean getEnrolledStatus() {
		return status;
	}
	
}
