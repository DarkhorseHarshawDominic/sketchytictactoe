import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ttt{

	public static void main(String args[]){
		game newGame = new game();
	}//main

}//ttt

class game extends JFrame implements ActionListener{

	JLabel l0;//main menu/gameboard;
	JLabel l1;//Hidden gameboard;
	JButton b0;//Quit
	JButton b1;//Play
	JButton b2;//1P
	JButton b3;//2P
	tic gmbd;//gameboard
	ImageIcon img1;
	ImageIcon img2;
	JButton sq[];//top-left square
	int turn;
	int flag[];

	game(){
		gmbd = new tic();
		turn = 0x0;
		flag = new int[2];

		//thumbnail
		ImageIcon img0 = new ImageIcon("icon0.png");

		//Main menu
		l0 = new JLabel();
		img1 = new ImageIcon("MainMenu.png");
		l0.setIcon(img1);
		l0.setBounds(0,0,500,400);

		//Game Area
		l1 = new JLabel();
		img2 = new ImageIcon("empty.png");
		l1.setIcon(img2);
		l1.setBounds(0,0,500,400);

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

		sq[0].setBounds(35,525,100,50);
		sq[1].setBounds(140,525,100,50);
		sq[2].setBounds(245,525,100,50);

		sq[3].setBounds(35,630,100,50);
		sq[4].setBounds(140,630,100,50);
		sq[5].setBounds(245,630,100,50);

		sq[6].setBounds(35,745,100,50);
		sq[7].setBounds(140,745,100,50);
		sq[8].setBounds(245,745,100,50);


		//Frame data
		this.setTitle("Tic-Tac-Toe v1");
		this.setSize(500,900);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		//window add
		this.add(l0);
		this.setIconImage(img0.getImage());
		this.add(b0);
		this.add(b1);
		this.add(b2);
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
			play0(0);
			b2.setVisible(false);
			summon();
		}//else if
		else if(e.getSource() == b3){//2P
			play0(1);
			b3.setVisible(false);
			summon();
		}//else if
		else if(e.getSource() == sq[0]){//tl
			sq[0].setVisible(false);
			flag[1] ^= 1;
			System.out.print("HEHER");
		}//else if
		else if(e.getSource() == sq[1]){//tm
			sq[1].setVisible(false);
		}//else if
		else if(e.getSource() == sq[2]){//tr
			sq[2].setVisible(false);
		}//else if
		else if(e.getSource() == sq[3]){//ml
			sq[3].setVisible(false);
		}//else if
		else if(e.getSource() == sq[4]){//mm
			sq[4].setVisible(false);
		}//else if
		else if(e.getSource() == sq[5]){//mr
			sq[5].setVisible(false);
		}//else if
		else if(e.getSource() == sq[6]){//bl
			sq[6].setVisible(false);
		}//else if
		else if(e.getSource() == sq[7]){//bm
			sq[7].setVisible(false);
		}//else if
		else if(e.getSource() == sq[8]){//br
			sq[8].setVisible(false);
		}//else if

	}//actionPerformed

	void play(){
		b1.setVisible(false);
		b2.setVisible(true);
		b3.setVisible(true);

	}//play
	
	void play0(int choice){//the real game

		//summon();

		//while(flag[0] == 0){
			switch(choice){
				case 0://1P
					//while(flag[1]==0);
					break;
				case 1://2P
					break;
				default:
					break;
			}//switch
			flag[0] = update();
		//}//while
	}//play0

	void summon(){
		l0.setIcon(img2);
		this.repaint();
		for(int x=0;x<9;x++)
			this.add(sq[x]);
	}//summon

	int update(){
		return gmbd.gameover;
	}//update
}//game

class tic{
	int state;//gamestate
	int gameover;
	int winner;

	tic(){
		state = 0x0;
		gameover = 0;
		winner = 1;
	}//ttt
}//ttt
