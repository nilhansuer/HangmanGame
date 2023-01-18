import java.io.IOException;

import javax.swing.JFrame;


public class HangmanTest {
public static void main(String  args[]) throws Exception{
		
		HangmanGame a=new HangmanGame();
		
		
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(a);
		f.setSize(980,600);
		f.setVisible(true);
		f.setTitle("CSE 212 Term Project - Hangman Game");
		f.setResizable(false);
	}
}
