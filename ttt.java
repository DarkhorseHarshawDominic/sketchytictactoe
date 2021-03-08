import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.time.Duration;

public class ttt{

	public static void main(String args[]){
		game newGame = new game();
	}//main

}//ttt

class game extends JFrame implements ActionListener{

	JLabel l0;//main menu/gameboard;
	JPanel p;//XO area
	JLabel winloc;
	JLabel l[];//XO squares
	ImageIcon X;
	ImageIcon O;
	JButton b0;//Quit
	JButton b1;//Play
	JButton b2;//1P
	JButton b3;//2P
	JButton b[];//XOs
	tic gmbd;//gameboard
	ImageIcon img1;
	ImageIcon img2;
	ImageIcon img[];
	JButton sq[];//top-left square
	Instant s;
	int flag[];
	//flag[0] -> 0 = 1P 1 = 2P
	//flag[1] -> 0 = P1 turn 1 = 2P turn
	//flag[2] -> 0 = P1WIN 1 = 2PWIN 2 = CPUWIN

	game(){
		gmbd = new tic();
		flag = new int[3];

		//thumbnail
		ImageIcon img0 = new ImageIcon("icon0.png");

		//Main menu
		l0 = new JLabel();
		img1 = new ImageIcon("MainMenu.png");
		l0.setIcon(img1);
		l0.setBounds(0,0,500,400);

		//Game Area
		img2 = new ImageIcon("empty.png");

		//Winners
		img = new ImageIcon[4];
		img[0] = new ImageIcon("1P.png");
		img[1] = new ImageIcon("2P.png");
		img[2] = new ImageIcon("CPU.png");
		img[3] = new ImageIcon("Lose.png");
		winloc = new JLabel();
		winloc.setLayout(null);
		winloc.setBounds(0,357,350,150);
		winloc.setVisible(true);
		//Buttons
 
		//quit
		b0 = new JButton();
		b0.setBounds(350,400,100,50);
		b0.addActionListener(this);
		b0.setText("Quit");

		//play
		b1 = new JButton();
		b1.setBounds(245,400,100,50);
		b1.addActionListener(this);
		b1.setText("Play");

		//1P
		b2 = new JButton();
		b2.setBounds(140,400,100,50);
		b2.addActionListener(this);
		b2.setText("1P");

		//2P
		b3 = new JButton();
		b3.setBounds(35,400,100,50);
		b3.addActionListener(this);
		b3.setText("2P");

		
		//tictactoe buttons
		sq = new JButton[9];
		ImageIcon img3 = new ImageIcon("dash.png");
		for(int x=0;x<9;x++){
			sq[x] = new JButton();
			sq[x].setIcon(img3);
		}//for

		sq[0].setBounds(35,25,100,100);
		sq[1].setBounds(140,25,100,100);
		sq[2].setBounds(245,25,100,100);

		sq[3].setBounds(35,130,100,100);
		sq[4].setBounds(140,130,100,100);
		sq[5].setBounds(245,130,100,100);

		sq[6].setBounds(35,235,100,100);
		sq[7].setBounds(140,235,100,100);
		sq[8].setBounds(245,235,100,100);

		for(int x=0;x<9;x++)
			sq[x].addActionListener(this);
		//XOs
		X = new ImageIcon("X.png");
		O = new ImageIcon("O.png");
		l = new JLabel[9];

		for(int x=0;x<9;x++){
			l[x] = new JLabel();
			l[x].setLayout(null);
			l[x].setVisible(true);
		}//for

		//Actual tictactoe panel
		p = new JPanel();
		p.setOpaque(false);
		p.setVisible(true);
		p.setLayout(null);
		p.setBounds(0,0,500,400);
		p.add(l0);

		//Frame data
		this.setTitle("Tic-Tac-Toe v1");
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		//window add
		this.getContentPane().add(p);
		this.setIconImage(img0.getImage());
		this.add(b0);
		this.add(b1);
		//this.add(b2);
		b2.setVisible(false);
		this.add(b3);
		b3.setVisible(false);
	}//game

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b0){//quit
			System.exit(0);
		}//if
		else if(e.getSource() == b1){//play
			play();
		}//else if
		else if(e.getSource() == b2){//1P
			b2.setVisible(false);
			b3.setVisible(false);
			summon();
			flag[0] = 0;
		}//else if
		else if(e.getSource() == b3){//2P
			b3.setVisible(false);
			b2.setVisible(false);
			summon();
			flag[0] = 1;
			s = Instant.now();
		}//else if
		else if(e.getSource() == sq[0]){//tl
			sq[0].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[0].setIcon(X);
				update(0,1);//Change state
			}//if
			else{
				l[0].setIcon(O);
				update(1,1);//Change state
			}//else
			l[0].setBounds(35,25,100,100);
			l[0].setOpaque(true);
			this.add(l[0]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
			//if((flag[1] & 0x0) == 0)//If 1P
				//CPU();
		}//else if
		else if(e.getSource() == sq[1]){//tm
			sq[1].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[1].setIcon(X);
				update(0,2);//Change state
			}//if
			else{
				l[1].setIcon(O);
				update(1,2);//Change state
			}//else
			l[1].setBounds(140,25,100,100);
			l[1].setOpaque(true);
			this.add(l[1]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
		}//else if
		else if(e.getSource() == sq[2]){//tr
			sq[2].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[2].setIcon(X);
				update(0,4);//Change state
			}//if
			else{
				l[2].setIcon(O);
				update(1,4);//Change state
			}
			l[2].setBounds(245,25,100,100);
			l[2].setOpaque(true);
			this.add(l[2]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;

		}//else if
		else if(e.getSource() == sq[3]){//ml
			sq[3].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[3].setIcon(X);
				update(0,8);//Change state
			}//if
			else{
				l[3].setIcon(O);
				update(1,8);//Change state
			}//else
			l[3].setBounds(35,130,100,100);
			l[3].setOpaque(true);
			this.add(l[3]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
			update(0,8);//Change state
		}//else if
		else if(e.getSource() == sq[4]){//mm
			sq[4].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[4].setIcon(X);
				update(0,16);//Change state
			}//if
			else
				l[4].setIcon(O);
				update(1,16);//Change state
			l[4].setBounds(140,130,100,100);
			l[4].setOpaque(true);
			this.add(l[4]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
		}//else if
		else if(e.getSource() == sq[5]){//mr
			sq[5].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[5].setIcon(X);
				update(0,32);//Change state
			}//if
			else{
				l[5].setIcon(O);
				update(1,32);//Change state
			}//else
			l[5].setBounds(245,130,100,100);
			l[5].setOpaque(true);
			this.add(l[5]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;

		}//else if
		else if(e.getSource() == sq[6]){//bl
			sq[6].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[6].setIcon(X);
				update(0,64);//Change state
			}//if
			else{
				l[6].setIcon(O);
				update(1,64);//Change state
			}//else
			l[6].setBounds(35,235,100,100);
			l[6].setOpaque(true);
			this.add(l[6]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;

		}//else if
		else if(e.getSource() == sq[7]){//bm
			sq[7].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[7].setIcon(X);
				update(0,128);//Change state
			}//if	
			else{
				l[7].setIcon(O);
				update(1,128);//Change state
			}//else
			l[7].setBounds(140,235,100,100);
			l[7].setOpaque(true);
			this.add(l[7]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
		}//else if
		else if(e.getSource() == sq[8]){//br
			sq[8].setVisible(false);
			if((flag[1] & 0x1) == 0){
				l[8].setIcon(X);
				update(0,256);//Change state
			}//if
			else{
				l[8].setIcon(O);
				update(1,256);//Change state
			}//else
			l[8].setBounds(245,235,100,100);
			l[8].setOpaque(true);
			this.add(l[8]);
			this.validate();
			this.repaint();
			flag[1] ^= 1;
			//System.out.println(gmbd.state[0]);
			//System.out.println(gmbd.state[1]);
		}//else if

	}//actionPerformed

	void play(){
		b1.setVisible(false);
		b2.setVisible(true);
		b3.setVisible(true);
	}//play
	
	void summon(){
		l0.setVisible(false);
		for(int x=0;x<9;x++)
			this.add(sq[x]);
		this.repaint();
	}//summon

	void update(int choice, int upd){//choice == player upd == square location
		Instant brk = Instant.now();
		Duration time = Duration.between(s,brk);
		if(time.toMinutes() < 1){

			if(choice == 0)
				gmbd.state[choice] |= upd;
			else
				gmbd.state[choice] |= upd;
				gmbd.lim++;
			if(gmbd.lim == 8){
				flag[2] = gmbd.winner(flag[0]);
				//System.out.println(flag[2]);
			}//if
				flag[2] = gmbd.winner(flag[0]);
				switch(flag[2]){//A VICTOR IS CHOSEN
					case 0: victor(0);
						break;
					case 1: victor(1);
						break;
					case 2: victor(2);
						break;
					default:
						break;
			}//switch
		}//if
		else{
			//System.out.println("TEST");
			victor(3);
		}//else
	}//update

	void victor(int choice){
		l0.setVisible(true);
		for(int x=0;x<9;x++){
			sq[x].setVisible(false);
			l[x].setVisible(false);
		}//for
		switch(choice){
		case 0:
			winloc.setIcon(img[0]);
			break;
		case 1:
			winloc.setIcon(img[1]);
			break;
		case 2:
			winloc.setIcon(img[2]);
			break;
		default:
			winloc.setIcon(img[3]);
			break;
		}//switch
		this.add(winloc);
	}//victor
}//game

class tic{
	int state[];//gamestate
	int gameover;
	int lim;//turn limit

	tic(){
		state = new int[2];
		gameover = 0;
		lim = 0;
	}//ttt

	int winner(int flag){
		if((state[0] & 7) == 7 || (state[0] & 56) == 56 || (state[0] & 448) == 448 || (state[0] & 73) == 73 || (state[0] & 146) == 146 || (state[0] & 292) == 292 || (state[0] & 84) == 84 || (state[0] & 273) == 273)//P1 wins
			return 0;
		else if((state[1] & 7) == 7 || (state[1] & 56) == 56 || (state[1] & 448) == 448 || (state[1] & 73) == 73 || (state[1] & 146) == 146 || (state[1] & 292) == 292 || (state[1] & 84) == 84 || (state[1] & 273) == 273)
			if(flag == 0)
				return 1;//CPU wins
			else
				return 2;//P2 wins
		return 3;//Undecided
	}//winner
}//ttt
