
public class School {
	private String name;
	private int quota;
	private double requirement;
	
	public School() {
		name = "N/A";
		quota = 0;
		requirement = 100;
	}
	
	//setter
	public void setName(String n) {
		name = n;
	}
	public void setQuota(int q) {
		quota = q;
	}
	public void setRequirement(double r) {
		requirement = r;
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
		if(quota<=0)
			return true;
		else
			return false;
	}
	
	public void addInfo(String n, int q, double r) {
		name = n;
		quota = q;
		requirement = r;
	}
	
}
