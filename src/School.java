import java.util.ArrayList;

public class School {
	private String name;
	private int quota;
	private double requirement;
	private boolean isFull = false;
	private int enrolled = 0;
	private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
	
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setQuota(int q) {
		this.quota = q;
	}
	public void setRequirement(double r) throws InvalidRequirementException{
		if(r < 55.0 || r > 100.0)
			throw new InvalidRequirementException(" Not a valid Value");
		else
			this.requirement = r;
	}
	
	public void updateEnrolled() {
		this.enrolled+= 1;
	}
	
	public void updateEnrolledStudents(Student student) {
		this.enrolledStudents.add(student);
	}

	
	//getter
	public String getName() {
		return name;
	}
	public int getQuota() {
		return quota;
	}
	public double getRequirement() {
		return requirement;
	}
	
	public boolean isFull() {
		if(quota == enrolled)
			return true;
		else
			return false;
	}
	
	public ArrayList<Student> getEnrolledStudents(){
		return enrolledStudents;
	}
	
}
