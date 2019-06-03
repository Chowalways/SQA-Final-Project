
public class School {
	private String name;
	private int quota = 0;
	private int quotaAdded = 0;
	private int lowScore = 999;
	private String[] enrollList = new String[99];
	private int enrollNumber = 0;
	
	public School(String n, int q) {
		name = n;
		quota = q;
	}
	
	public boolean isFull() {
		if(enrollNumber>=quota)
			return true;
		else
			return false;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean enroll(String name, int score) {
		if(isFull()) {
			if(score==lowScore && quotaAdded<2) {
				enrollList[enrollNumber] = name + " " + Integer.toString(score);
				quotaAdded += 1;
				enrollNumber +=1;
				return true;
			}else {
				return false;
			}
		}else {
			enrollList[enrollNumber] = name + " " + Integer.toString(score);
			lowScore = score;
			enrollNumber +=1;
			return true;
		}
	}
	
	public void printList() {
		System.out.println(name + "的錄取名單:");
		for(int i=0; i<enrollNumber; i++) {
			System.out.println(enrollList[i]);
		}
		System.out.printf("錄取率: %1.1f%%  缺額率: %1.1f%%\n\n", 
				(double)enrollNumber/(double)quota*100, 100-(double)enrollNumber/(double)quota*100);
	}

}
