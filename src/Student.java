
public class Student {
	private String name;
	private int score;
	private String[] wishList = new String[3];
	private boolean assign = false;
	
	public Student(String n, int s, String w1, String w2, String w3) {
		name = n;
		score = s;
		wishList[0] = w1;
		wishList[1] = w2;
		wishList[2] = w3;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getWish(int i) {
		return wishList[i];
	}
	
	public boolean isAssign() {
		return assign;
	}
	
	public void setAssign(boolean b) {
		assign = b;
	}

}
