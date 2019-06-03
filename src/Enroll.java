
public class Enroll {

	public static void main(String[] args) {
		Student[] suList = new Student[99];
		School[] scList = new School[50];
		int studentNumber = 3;
		int schoolNumber = 2;
		
		suList[0] = new Student("Y",99,"A","N/A","N/A");
		suList[1] = new Student("Z",99,"B","A","N/A");
		suList[2] = new Student("X",100,"B","A","N/A");
		
		scList[0] = new School("A",1);
		scList[1] = new School("B",1);
		
		//Bubble Sort Students
		for(int i=0; i<studentNumber-1; i++) {
			for(int j=0; j<studentNumber-i-1; j++) {
				if(suList[j].getScore()<suList[j+1].getScore()) {
					Student temp = suList[j];
					suList[j] = suList[j+1];
					suList[j+1] = temp;
				}
			}
		}
		
		//Assign Students 
		for(int i=0; i<studentNumber; i++) {
			for(int j=0; j<3; j++) {
				if(!suList[i].isAssign()) {
					for(int k=0; k<schoolNumber; k++) {
						if(suList[i].getWish(j).equals(scList[k].getName()))
							suList[i].setAssign(scList[k].enroll(suList[i].getName(), suList[i].getScore()));
					}
				}
			}
		}
		
		//Print Admission List
		for(int i=0; i<schoolNumber; i++) {
			scList[i].printList();
		}

	}

}
