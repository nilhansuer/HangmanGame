import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	String name;
	String dateAndTime;
	String hangmanStr;
	int hangmanSize;
	int timeElapsed; 
	
	
	public WriteFile(String name, String dateAndTime, String hangmanStr, int hangmanSize, int timeElapsed ) throws IOException {
		
		this.name = name;
		this.dateAndTime = dateAndTime;
		this.hangmanStr = hangmanStr;
		this.hangmanSize = hangmanSize;
		this.timeElapsed = timeElapsed; 
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
		      fw = new FileWriter("files\\scores.txt", true);
		      bw = new BufferedWriter(fw);
		      pw = new PrintWriter(bw);
		      
		      pw.println("Name: " + name + "\n" + "Date and Time: " + dateAndTime + "\n" + "Hangman String: " + hangmanStr + "\n" +
	    		  		"Hangman String Size: " + hangmanSize + " characters" + "\n" + "Time Elapsed: " + timeElapsed + " seconds\n" + "--------------------------\n");
		      System.out.println("Data is succesfully written." );
		      pw.flush();
		      
		} catch (IOException e) {
		      System.out.println("Data couldn't be written!");
		      e.printStackTrace();
		    }
		finally {
			pw.close();
			bw.close();
			fw.close();
		}
	}
}
