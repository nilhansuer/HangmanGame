import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;



public class HangmanGame extends JPanel {
	
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon image6;
	private ImageIcon image7;
	
	private JLabel label_im1;
	private JLabel label_im2;
	private JLabel label_im3;
	private JLabel label_im4;
	private JLabel label_im5;
	private JLabel label_im6;
	private JLabel label_im7;
	
	private JLabel last_image;
	
	private int chances;
	private int index;
	private int maxindex;
	private int tmpindex;
	private String guess="";
	private String temp="";
	
	private Boolean isReset = false;
	
	Random random = new Random();
	
	private JLabel timeLabel = new JLabel("99:99");
	private JLabel countLabel = new JLabel();
	private int time;
	
	private JLabel label1=new JLabel();
	private JLabel label2=new JLabel();
	private JLabel label3=new JLabel();
	private JLabel label4=new JLabel();
	private JLabel label5=new JLabel();
	private JLabel label6=new JLabel();
	private JLabel label7=new JLabel();
	private JLabel label8=new JLabel();
	private JLabel label9=new JLabel();
	private JLabel label10=new JLabel();
	private JLabel label11=new JLabel();

	private JButton A = new JButton("A");
	private JButton B = new JButton("B");
	private JButton C = new JButton("C");
	private JButton D = new JButton("D");
	private JButton E = new JButton("E");
	private JButton F = new JButton("F");
	private JButton G = new JButton("G");
	private JButton H = new JButton("H");
	private JButton I = new JButton("I");

	private JButton J = new JButton("J");
	private JButton K = new JButton("K");
	private JButton L = new JButton("L");
	private JButton M = new JButton("M");
	private JButton N = new JButton("N");
	private JButton O = new JButton("O");
	private JButton P = new JButton("P");
	private JButton Q = new JButton("Q");
	private JButton R = new JButton("R");

	private JButton S = new JButton("S");
	private JButton T = new JButton("T");
	private JButton U = new JButton("U");
	private JButton V = new JButton("V");
	private JButton W = new JButton("W");
	private JButton X = new JButton("X");
	private JButton Y = new JButton("Y");
	private JButton Z = new JButton("Z");
	
	private JButton Stop = new JButton("");
	
	JMenuItem NewGame = new JMenuItem("New Game");
	JMenuItem ResetGame = new JMenuItem("Reset Game");
	JMenuItem ScoreTable = new JMenuItem("Score Table");
	JMenuItem Quit = new JMenuItem("Quit");
	
	private JLabel label_tip = new JLabel();
	private JLabel label_notinstr = new JLabel();
	private JLabel label_status = new JLabel();
	private JLabel label_countdown = new JLabel();
	
	ArrayList<String> arTip = new ArrayList<String>();
	ArrayList<String> arNotinstr = new ArrayList<String>();
	ArrayList<String> arHiddenstr = new ArrayList<String>();
	ArrayList<String> arCountdown = new ArrayList<String>();
	
	Countdown countdown = new Countdown();
	
	ReadFile readfile = new ReadFile();
	
	Clip clip; 
	
	
	public HangmanGame() throws Exception {
		
		setPreferredSize(new Dimension(800, 500));
		setLayout(null);
		
		keyHandler handler=new keyHandler();
		
		A.setBounds(40, 400, 50, 25);
		add(A);
		A.addActionListener(handler);
		B.setBounds(100, 400, 50, 25);
		add(B);
		B.addActionListener(handler);
		C.setBounds(160, 400, 50, 25);
		add(C);
		C.addActionListener(handler);
		D.setBounds(220, 400, 50, 25);
		add(D);
		D.addActionListener(handler);
		E.setBounds(280, 400, 50, 25);
		add(E);
		E.addActionListener(handler);
		F.setBounds(340, 400, 50, 25);
		add(F);
		F.addActionListener(handler);
		G.setBounds(400, 400, 50, 25);
		add(G);
		G.addActionListener(handler);
		H.setBounds(460, 400, 50, 25);
		add(H);
		H.addActionListener(handler);
		I.setBounds(520, 400, 50, 25);
		add(I);
		I.addActionListener(handler);
		
		J.setBounds(40, 437, 50, 25);
		add(J);
		J.addActionListener(handler);
		K.setBounds(100, 437, 50, 25);
		add(K);
		K.addActionListener(handler);
		L.setBounds(160, 437, 50, 25);
		add(L);
		L.addActionListener(handler);
		M.setBounds(220, 437, 50, 25);
		add(M);
		M.addActionListener(handler);
		N.setBounds(280, 437, 50, 25);
		add(N);
		N.addActionListener(handler);
		O.setBounds(340, 437, 50, 25);
		add(O);
		O.addActionListener(handler);
		P.setBounds(400, 437, 50, 25);
		add(P);
		P.addActionListener(handler);
		Q.setBounds(460, 437, 50, 25);
		add(Q);
		Q.addActionListener(handler);
		R.setBounds(520, 437, 50, 25);
		add(R);
		R.addActionListener(handler);
		
		S.setBounds(55, 474, 50, 25);
		add(S);
		S.addActionListener(handler);
		T.setBounds(115, 474, 50, 25);
		add(T);
		T.addActionListener(handler);
		U.setBounds(175, 474, 50, 25);
		add(U);
		U.addActionListener(handler);
		V.setBounds(235, 474, 50, 25);
		add(V);
		V.addActionListener(handler);
		W.setBounds(295, 474, 50, 25);
		add(W);
		W.addActionListener(handler);
		X.setBounds(355, 474, 50, 25);
		add(X);
		X.addActionListener(handler);
		Y.setBounds(415, 474, 50, 25);
		add(Y);
		Y.addActionListener(handler);
		Z.setBounds(475, 474, 50, 25);
		add(Z);
		Z.addActionListener(handler);
		
	
		
		arTip = readfile.arr_tip;
		arNotinstr = readfile.arr_notinstr;
		arHiddenstr = readfile.arr_hiddenstr;
		arCountdown = readfile.arr_countdown;
		
		
		maxindex = arHiddenstr.size() - 1;
		index = random.nextInt(maxindex - 0) + 0;    
		tmpindex = index;
		
        
        label_tip.setText("Tip: " + arTip.get(index));
        label_tip.setFont(new Font("Verdana", Font.BOLD, 13));
        label_tip.setSize(300, 100);
        label_tip.setLocation(20, 20);
		add(label_tip);
		
		label_notinstr.setText("Not in string: " + arNotinstr.get(index));
		label_notinstr.setFont(new Font("Verdana", Font.BOLD, 13));
		label_notinstr.setSize(300, 100);
		label_notinstr.setLocation(20, 90);
		add(label_notinstr);
		
		
		label_status.setText("<html>Status: <font color='blue'><span style='font-size:18px'>In progress</font></span></html>");
		
		javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
			
			  @Override
	          public void actionPerformed(ActionEvent e) {
	        	  
	              countdown.decsecond();
	              timeLabel.setText(countdown.printminsec()+"     ");
	              
	              
	              if((countdown.getminute() == 0) && (countdown.getsecond() == 0)){
	            	  label_status.setText("<html>Status: <font color='red'><span style='font-size:18px'>You LOSE!</font></span></html>");
	            	  Stop.doClick();
	            	  
	              }
	              else if(chances == 0) {
	            	  label_status.setText("<html>Status: <font color='red'><span style='font-size:18px'>You LOSE!</font></span></html>");
	            	  
	            	  Stop.doClick();
	              }
	              
	            	  
	          }
	       });
		
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				timer.stop();
			}
		});
		
    	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 980, 25);
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(menuBar);
            
		JMenu File = new JMenu("File");
		File.setMnemonic('F');
		menuBar.add(File);    
        
		
		
		NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				chances = 6;
				label_status.setText("<html>Status: <font color='blue'><span style='font-size:18px'>In progress</font></span></html>");
				
				if(last_image != null) {
					last_image.setVisible(false);
				}
				image1 = new ImageIcon("images\\img1.png");
				label_im1 = new JLabel(image1);
				label_im1.setSize(317, 475);
				label_im1.setLocation(613, 91);
				add(label_im1);
				
				
				if(isReset == false) {
					index = random.nextInt(maxindex - 0) + 0;  
					if(tmpindex == index) {
						index = random.nextInt(maxindex - 0) + 0;  
					}
					tmpindex = index;
				}
				
				isReset = false;
				
				
				label_tip.setText("Tip: " + arTip.get(index));
		        label_tip.setFont(new Font("Verdana", Font.BOLD, 13));
		        label_tip.setSize(300, 100);
		        label_tip.setLocation(20, 20);
				add(label_tip);
				
				label_notinstr.setText("Not in string: " + arNotinstr.get(index));
				label_notinstr.setFont(new Font("Verdana", Font.BOLD, 13));
				label_notinstr.setSize(300, 100);
				label_notinstr.setLocation(20, 90);
				add(label_notinstr);
				
				
				A.setEnabled(true);
				B.setEnabled(true);
				C.setEnabled(true);
				D.setEnabled(true);
				E.setEnabled(true);
				F.setEnabled(true);
				G.setEnabled(true);
				H.setEnabled(true);
				I.setEnabled(true);
				
				J.setEnabled(true);
				K.setEnabled(true);
				L.setEnabled(true);
				M.setEnabled(true);
				N.setEnabled(true);
				O.setEnabled(true);
				P.setEnabled(true);
				Q.setEnabled(true);
				R.setEnabled(true);
				
				S.setEnabled(true);
				T.setEnabled(true);
				U.setEnabled(true);
				V.setEnabled(true);
				W.setEnabled(true);
				X.setEnabled(true);
				Y.setEnabled(true);
				Z.setEnabled(true);
				
				JPanel wordPanel1 = new JPanel();
				wordPanel1.setBackground(Color.WHITE);
				wordPanel1.setForeground(Color.WHITE);
				wordPanel1.setBorder(new LineBorder(Color.GRAY, 1, true));
				wordPanel1.setBounds(10, 285, 50, 30);
				wordPanel1.setOpaque(true);
				wordPanel1.add(label1);
				
				
				label1.setVisible(false);
				label2.setVisible(false);
				label3.setVisible(false);
				label4.setVisible(false);
				label5.setVisible(false);
				label6.setVisible(false);
				label7.setVisible(false);
				label8.setVisible(false);
				label9.setVisible(false);
				label10.setVisible(false);
				
				
				
				String mystr2 = arHiddenstr.get(index);
				
				
				for(int i=1;i<=mystr2.length();i++){
					switch(i){

					case 1:
						label1.setBackground(Color.WHITE);
						label1.setForeground(Color.BLACK);
						label1.setBorder(new LineBorder(Color.GRAY, 1, true));
						label1.setBounds(10, 285, 50, 30);
						label1.setOpaque(true);
						label1.setVisible(true);
						add(label1);
						label1.setText("");
						break;

					case 2:
						label2.setBackground(Color.WHITE);
						label2.setForeground(Color.BLACK);
						label2.setBorder(new LineBorder(Color.GRAY, 1, true));
						label2.setBounds(70, 285, 50, 30);
						label2.setOpaque(true);
						label2.setVisible(true);
						add(label2);
						label2.setText("");
						break;

					case 3:
						label3.setBackground(Color.WHITE);
						label3.setForeground(Color.BLACK);
						label3.setBorder(new LineBorder(Color.GRAY, 1, true));
						label3.setBounds(130, 285, 50, 30);
						label3.setOpaque(true);
						label3.setVisible(true);
						add(label3);
						label3.setText("");
						break;

					case 4:
						label4.setBackground(Color.WHITE);
						label4.setForeground(Color.BLACK);
						label4.setBorder(new LineBorder(Color.GRAY, 1, true));
						label4.setBounds(190, 285, 50, 30);
						label4.setOpaque(true);
						label4.setVisible(true);
						add(label4);
						label4.setText("");
						break;

					case 5:
						label5.setBackground(Color.WHITE);
						label5.setForeground(Color.BLACK);
						label5.setBorder(new LineBorder(Color.GRAY, 1, true));
						label5.setBounds(250, 285, 50, 30);
						label5.setOpaque(true);
						label5.setVisible(true);
						add(label5);
						label5.setText("");
						break;

					case 6:
						label6.setBackground(Color.WHITE);
						label6.setForeground(Color.BLACK);
						label6.setBorder(new LineBorder(Color.GRAY, 1, true));
						label6.setBounds(310, 285, 50, 30);
						label6.setOpaque(true);
						label6.setVisible(true);
						add(label6);
						label6.setText("");
						break;

					case 7:
						label7.setBackground(Color.WHITE);
						label7.setForeground(Color.BLACK);
						label7.setBorder(new LineBorder(Color.GRAY, 1, true));
						label7.setBounds(370, 285, 50, 30);
						label7.setOpaque(true);
						label7.setVisible(true);
						add(label7);
						label7.setText("");
						break;

					case 8:
						label8.setBackground(Color.WHITE);
						label8.setForeground(Color.BLACK);
						label8.setBorder(new LineBorder(Color.GRAY, 1, true));
						label8.setBounds(430, 285, 50, 30);
						label8.setOpaque(true);
						label8.setVisible(true);
						add(label8);
						label8.setText("");
						break;

					case 9:
						label9.setBackground(Color.WHITE);
						label9.setForeground(Color.BLACK);
						label9.setBorder(new LineBorder(Color.GRAY, 1, true));
						label9.setBounds(490, 285, 50, 30);
						label9.setOpaque(true);
						label9.setVisible(true);
						add(label9);
						label9.setText("");
						break;

					case 10:
						label10.setBackground(Color.WHITE);
						label10.setForeground(Color.BLACK);
						label10.setBorder(new LineBorder(Color.GRAY, 1, true));
						label10.setBounds(550, 285, 50, 30);
						label10.setOpaque(true);
						label10.setVisible(true);
						add(label10);
						label10.setText("");
						break;
						
					}
					}
				
				timer.stop();
				
				time = Integer.parseInt(arCountdown.get(index));
				countdown.settime(0, time, 0); 
				
				
				timeLabel.setText(countdown.printminsec()+"     ");
				
				timeLabel.setFont(new Font("Verdana", Font.BOLD, 13));
				timeLabel.setSize(300, 100);
				timeLabel.setLocation(450, 160);
				
				timer.start();
				
				
			}
		});
		
		countLabel.setText("Countdown: ");
		countLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		countLabel.setSize(300, 100);
		countLabel.setLocation(355, 160);
		add(countLabel);
		
	
		label_status.setFont(new Font("Verdana", Font.BOLD, 13));
		label_status.setSize(300, 100);
		label_status.setLocation(20, 160);
		add(label_status);
		
		
		File.add(NewGame);
		File.add(ResetGame);
		File.add(ScoreTable);
		File.add(Quit);
		
		ResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				isReset = true;
				NewGame.doClick();
				
			}
		});
		
		
		ScoreTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				try {
					FileReader filereader = new FileReader("files\\scores.txt");
					
					int i = 0;
					String s = "";
					
					while ((i = filereader.read()) != -1) {
						s += (char)i; 
				    }
					JOptionPane.showMessageDialog(null, s, "Score Table", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					System.out.println("The file couldn't be read!");
					e.printStackTrace();
				} 
				 
				
			}
		});
		
		KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
		Quit.setAccelerator(keyStrokeToOpen);
		
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		
		Component horizontalStrut = Box.createHorizontalStrut(15);
		menuBar.add(horizontalStrut);
		
		
		JMenu Help = new JMenu("Help");
		Help.setMnemonic('H');
		menuBar.add(Help);
		
		JMenuItem About = new JMenuItem("About");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,"Developed by\n"
						+"Name/Surname: Nilhan Suer\n"
						+"School Number: 20190702121\n"
						+"Email: nilhan.suer@std.yeditepe.edu.tr","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Help.add(About);
		
		
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label5.setHorizontalAlignment(JLabel.CENTER);
		label5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label6.setHorizontalAlignment(JLabel.CENTER);
		label6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label7.setHorizontalAlignment(JLabel.CENTER);
		label7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label8.setHorizontalAlignment(JLabel.CENTER);
		label8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label9.setHorizontalAlignment(JLabel.CENTER);
		label9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label10.setHorizontalAlignment(JLabel.CENTER);
		label10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		String mystr = arHiddenstr.get(index);
		
		for(int i=1;i<=mystr.length();i++){
		switch(i){

		case 1:
			label1.setBackground(Color.WHITE);
			label1.setForeground(Color.BLACK);
			label1.setBorder(new LineBorder(Color.GRAY, 1, true));
			label1.setBounds(10, 285, 50, 30);
			label1.setOpaque(true);
			add(label1);
			label1.setText("");
			break;

		case 2:
			label2.setBackground(Color.WHITE);
			label2.setForeground(Color.BLACK);
			label2.setBorder(new LineBorder(Color.GRAY, 1, true));
			label2.setBounds(70, 285, 50, 30);
			label2.setOpaque(true);
			add(label2);
			label2.setText("");
			break;

		case 3:
			label3.setBackground(Color.WHITE);
			label3.setForeground(Color.BLACK);
			label3.setBorder(new LineBorder(Color.GRAY, 1, true));
			label3.setBounds(130, 285, 50, 30);
			label3.setOpaque(true);
			add(label3);
			label3.setText("");
			break;

		case 4:
			label4.setBackground(Color.WHITE);
			label4.setForeground(Color.BLACK);
			label4.setBorder(new LineBorder(Color.GRAY, 1, true));
			label4.setBounds(190, 285, 50, 30);
			label4.setOpaque(true);
			add(label4);
			label4.setText("");
			break;

		case 5:
			label5.setBackground(Color.WHITE);
			label5.setForeground(Color.BLACK);
			label5.setBorder(new LineBorder(Color.GRAY, 1, true));
			label5.setBounds(250, 285, 50, 30);
			label5.setOpaque(true);
			add(label5);
			label5.setText("");
			break;

		case 6:
			label6.setBackground(Color.WHITE);
			label6.setForeground(Color.BLACK);
			label6.setBorder(new LineBorder(Color.GRAY, 1, true));
			label6.setBounds(310, 285, 50, 30);
			label6.setOpaque(true);
			add(label6);
			label6.setText("");
			break;

		case 7:
			label7.setBackground(Color.WHITE);
			label7.setForeground(Color.BLACK);
			label7.setBorder(new LineBorder(Color.GRAY, 1, true));
			label7.setBounds(370, 285, 50, 30);
			label7.setOpaque(true);
			add(label7);
			label7.setText("");
			break;

		case 8:
			label8.setBackground(Color.WHITE);
			label8.setForeground(Color.BLACK);
			label8.setBorder(new LineBorder(Color.GRAY, 1, true));
			label8.setBounds(430, 285, 50, 30);
			label8.setOpaque(true);
			add(label8);
			label8.setText("");
			break;

		case 9:
			label9.setBackground(Color.WHITE);
			label9.setForeground(Color.BLACK);
			label9.setBorder(new LineBorder(Color.GRAY, 1, true));
			label9.setBounds(490, 285, 50, 30);
			label9.setOpaque(true);
			add(label9);
			label9.setText("");
			break;

		case 10:
			label10.setBackground(Color.WHITE);
			label10.setForeground(Color.BLACK);
			label10.setBorder(new LineBorder(Color.GRAY, 1, true));
			label10.setBounds(550, 285, 50, 30);
			label10.setOpaque(true);
			add(label10);
			label10.setText("");
			break;

		}
		}
		
		time = Integer.parseInt(arCountdown.get(index));
		countdown.settime(0, time, 0);
		timeLabel.setText(countdown.printminsec()+"     ");
		
		timeLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		timeLabel.setSize(300, 100);
		timeLabel.setLocation(450, 160);
		add(timeLabel);
		timer.start();
		
				
		
		label_tip.setText("Tip: " + arTip.get(index));
        label_tip.setFont(new Font("Verdana", Font.BOLD, 13));
        label_tip.setSize(300, 100);
        label_tip.setLocation(20, 20);
		add(label_tip);
		
		
		image1 = new ImageIcon("images\\img1.png");
		label_im1 = new JLabel(image1);
		label_im1.setSize(317, 475);
		label_im1.setLocation(613, 91);
		add(label_im1);
		
		
		chances = 6;	
		
	}
	
	
	
	private void process() {
		
		String t;
		t=arHiddenstr.get(index);
		int j=-1;
		boolean found=false;
		for(int i=0;i<t.length();i++){
		j=t.indexOf(guess,i);
	
		
		if(j>=0){
			
			if(j==0)
				label1.setText(guess);
			
			else if(j==1)
				label2.setText(guess);
			
			else if(j==2)
				label3.setText(guess);
			
			else if(j==3)
				label4.setText(guess);
			
			else if(j==4)
				label5.setText(guess);
			
			else if(j==5)
				label6.setText(guess);
			
			else if(j==6)
				label7.setText(guess);
			
			else if(j==7)
				label8.setText(guess);
			
			else if(j==8)
				label9.setText(guess);
			
			else if(j==9)
				label10.setText(guess);
			
			else if(j==10)
				label11.setText(guess);
				
			j=-1;
			found=true;;
			
			try {
				File file = new File("sounds\\true.wav");
				AudioInputStream audioStream;
				audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			} catch (Exception e1) {
				System.out.println("Sound file couldn't be opened!");
				e1.printStackTrace();
			}
			
			clip.start();
			
			}
			
		}
		
		if(!found) {
			--chances;
			
			try {
				File file = new File("sounds\\false.wav");
				AudioInputStream audioStream;
				audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			} catch (Exception e1) {
				System.out.println("Sound file couldn't be opened!");
				e1.printStackTrace();
			}
			
			clip.start();
			
			
			if(chances == 5){
        		label_im1.setVisible(false);
    			image2 = new ImageIcon("images\\img2.png");
    			label_im2 = new JLabel(image2);
    			label_im2.setSize(317, 475);
    			label_im2.setLocation(613, 91);
    			add(label_im2);
    			last_image = label_im2;
			}
			else if ( chances == 4 ) {
				label_im2.setVisible(false);
    			image3 = new ImageIcon("images\\img3.png");
    			label_im3 = new JLabel(image3);
    			label_im3.setSize(317, 475);
    			label_im3.setLocation(640, 100);
    			add(label_im3);
    			last_image = label_im3;
			}
			else if ( chances == 3 ) {
				label_im3.setVisible(false);
    			image4 = new ImageIcon("images\\img4.png");
    			label_im4 = new JLabel(image4);
    			label_im4.setSize(317, 475);
    			label_im4.setLocation(640, 100);
    			add(label_im4);
    			last_image = label_im4;
			}
			else if ( chances == 2 ) {
				label_im4.setVisible(false);
    			image5 = new ImageIcon("images\\img5.png");
    			label_im5 = new JLabel(image5);
    			label_im5.setSize(317, 475);
    			label_im5.setLocation(640, 100);
    			add(label_im5);
    			last_image = label_im5;
			}
			else if ( chances == 1 ) {
				label_im5.setVisible(false);
    			image6 = new ImageIcon("images\\img6.png");
    			label_im6 = new JLabel(image6);
    			label_im6.setSize(317, 475);
    			label_im6.setLocation(640, 100);
    			add(label_im6);
    			last_image = label_im6;
			}
			else if ( chances == 0 ) {
				label_im6.setVisible(false);
    			image7 = new ImageIcon("images\\img7.png");
    			label_im7 = new JLabel(image7);
    			label_im7.setSize(317, 475);
    			label_im7.setLocation(640, 100);
    			add(label_im7);
    			last_image = label_im7;
			}
		}
		
		
	}
	
	
	private class keyHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			guess=event.getActionCommand();
			if(true){
				process();
				
				
				if( chances > 0 ) {
					temp="";
					String s;
					s = arHiddenstr.get(index);
					for(int i=0;i<s.length();i++){
						
						switch(i){

						case 0:
							temp+=label1.getText();
							break;

						case 1:
							temp+=label2.getText();
							break;

						case 2:
							temp+=label3.getText();
							break;

						case 3:
							temp+=label4.getText();
							break;

						case 4:
							temp+=label5.getText();
							break;

						case 5:
							temp+=label6.getText();
							break;

						case 6:
							temp+=label7.getText();
							break;

						case 7:
							temp+=label8.getText();
							break;

						case 8:
							temp+=label9.getText();
							break;

						case 9:
							temp+=label10.getText();
							break;

						case 10:
							temp+=label11.getText();
							break;
							
						}
					}
					if(temp.equals(arHiddenstr.get(index))){
						
						label_status.setText("<html>Status: <font color='green'><span style='font-size:18px'>You WON!</font></span></html>");
						Stop.doClick();
						
						String username = JOptionPane.showInputDialog("Please enter your name: ");
						
						Date date = new Date();
						String dateAndTime = date.toString();
						
						int strtoint = Integer.parseInt(arCountdown.get(index));
						int mintosec = (strtoint - countdown.getminute() - 1)*60;
						int totalsec = 60 - countdown.getsecond();
						int timeElapsed = mintosec + totalsec;
						
						
						try {
							new WriteFile(username, dateAndTime, arHiddenstr.get(index), arHiddenstr.get(index).length(), timeElapsed);
						} catch (IOException e) {
							System.out.println("Scores couldn't be written to the file!");
							e.printStackTrace();
						}
						
					
						
					}
					
				}
				
			}
		}
	}


}
