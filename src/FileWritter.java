import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;

//DO NOT RUN THIS CLASS!!!!
public class FileWritter {

	public static void main(String[] args) {
		
		FileWritter write = new FileWritter();
		Scanner scan = new Scanner(System.in);
		
		
		for(int i = 0; i < 50; i++) {
			double randomReq = ThreadLocalRandom.current().nextInt(30, 100);
			int randomInt = ThreadLocalRandom.current().nextInt(20, 500);
			try {
				String info;
				info = scan.nextLine();
				write.schoolFileWriter(info + " " + randomReq);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void schoolFileWriter(String data) throws IOException{
		BufferedWriter writer = new BufferedWriter( new FileWriter("studentData1.txt", true));
		writer.append(data);
		writer.newLine();
		writer.close();
	}

}
