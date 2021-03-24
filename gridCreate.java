
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;


@SuppressWarnings({ "serial", "unused" })
public class gridCreate extends JPanel implements ActionListener {
	int m = 3;// x
	int n = 3;// y
	int k = 3;
	public static int TILE_SIZE = 5;
	public static placeToken[][] grid;
	public boolean p1 = true;
	public boolean p2 = false;
	public boolean cpu = false;
	public static int cpuNumPlays = 0;
	public static int seconNumPlays = 0;
	public static int totPlays = 0;
	public static boolean winnerState = false;
	public static boolean drawState = false;
	JLabel l0;// main menu/gameboard;
	JPanel p;// XO area
	JLabel winloc;
	JLabel l[];// XO squares
	ImageIcon X;
	ImageIcon O;
	JButton b0;// Quit
	JButton b1;// Play
	JButton b2;// 1P
	JButton b3;// 2P
	JButton b[];// XOs
	ImageIcon img1;
	ImageIcon img2;
	ImageIcon img[];
	JButton sq[];// top-left square
	JFrame omega = null;

	public void scale() {
		if(m * n <= 12) {
			int size = 3000;
			TILE_SIZE = size /(m * n);
		}
		else if(m * n <= 25) {
			int size = 5000;
			TILE_SIZE = size /(m * n);
		}
		else {
			int size = 5000;
			size = size / (m * n);
			int size2 = size;
			TILE_SIZE = size2;
		}
	}

	public gridCreate() {
		grid = new placeToken[m][n];
		scale();
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				int nx = x * TILE_SIZE;
				int ny = y * TILE_SIZE;

				placeToken v = new placeToken(nx, ny);
				grid[x][y] = v;
			}
		}
	}
		public static Timer timer = new Timer();
	public static void main(String args[]) {
		thr mainMenu = new thr();
		/*SwingUtilities.invokeLater(() -> {
			gridCreate view = new gridCreate();
			view.setPreferredSize(new Dimension(1210, 1000));
			JFrame frame = new JFrame();
			frame.setLayout(new BorderLayout());
			frame.add(view, BorderLayout.CENTER);
			frame.setTitle("TicTacToo");
			frame.getContentPane().add(view);
			frame.setResizable(true);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			view.requestFocus();
			view.start();
		});*/
		
	}

	@Override
	protected void paintComponent(Graphics graph) {
		draw((Graphics2D) graph);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void start() {
		// thumbnail
		/*ImageIcon img0 = new ImageIcon("icon0.png");

		// Main menu
		l0 = new JLabel();
		img1 = new ImageIcon("MainMenu.png");
		l0.setIcon(img1);
		l0.setBounds(0, 0, 500, 400);

		winloc = new JLabel();
		winloc.setLayout(null);
		winloc.setBounds(0, 357, 350, 150);
		winloc.setVisible(true);

		// 1P
		b2 = new JButton();
		b2.setBounds(140, 400, 100, 50);
		b2.addActionListener(this);
		b2.setText("1P");

		// 2P
		b3 = new JButton();
		b3.setBounds(35, 400, 100, 50);
		b3.addActionListener(this);
		b3.setText("2P");
		
		//Actual tictactoe panel
		p = new JPanel();
		p.setOpaque(false);
		p.setVisible(true);
		p.setLayout(null);
		p.setBounds(0,0,500,400);
		p.add(l0);
		
		//Frame data
		omega.setTitle("Tic-Tac-Toe v1");
		omega.setSize(500,500);
		omega.setLayout(null);
		omega.setVisible(true);
		omega.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		omega.setResizable(false);
		
		omega.getContentPane().add(p);
		omega.add(b0);
		omega.add(b1);
		omega.add(b2);
		//b2.setVisible(false);
		omega.add(b3);*/
		startTimer();
		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		

	}

	public void draw(Graphics2D graphed) {
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				graphed.setColor(Color.white);
				placeToken rx = grid[x][y];
				graphed.fillRect(rx.point.x, rx.point.y, TILE_SIZE, TILE_SIZE);
				if (rx.img != null) {
					graphed.drawImage(rx.img, rx.point.x + 1, rx.point.y + 1, null);
				}
				graphed.setColor(Color.BLACK);
				graphed.drawRect(rx.point.x, rx.point.y, TILE_SIZE, TILE_SIZE);
			}
		}
		if(winnerState == true) {
			new TimedExit();
		}
		if(drawState == true) new TimedExit();
		//graphed.repaint();

	}

	public class TimedExit {
		Timer timer = new Timer();
		TimerTask exitApp = new TimerTask() {
		public void run() {
		    System.exit(0);
		    }
		};

		public TimedExit() {
			timer.schedule(exitApp, new Date(System.currentTimeMillis()+3*1000));
		}

	}
	public static int time = 5;
	public TimerTask timed = null;
	public void startTimer() {
		timed = new TimerTask() {
			@Override 
			public void run() {
				int seconds = time % 60;
				time--;
				if(time <= 0) {//TIMER RUNS OUT, GAME EXITS
					System.exit(0);
				}
			}

		};			
		timer.schedule(timed, 0, 1000);
	}

	public void restartTimer() {
		time = 5;
	}
	
	private class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {

			
			int row = e.getX() / TILE_SIZE;
			int col = e.getY() / TILE_SIZE;
			int cpuX = 0;
			int cpuY = 0;
			int win = 0;
			if (col < 0 || row < 0 || col > m - 1 || row > m - 1) {
				return;
			}

			if (grid[row][col].img == null) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					if (p1 == true) {// Player 1 plays
						if (cpu == false) {
							p1 = false;
							p2 = true;
						}
						grid[row][col].img = getOImage();
						grid[row][col].hiddenValue = 1;
						totPlays++;
						if (cpu == true) {// CPU plays
							do {
								cpuX = randomCoords(m);
								cpuY = randomCoords(n);
								if (grid[cpuX][cpuY].img == null) {
									cpuNumPlays++;
									grid[cpuX][cpuY].img = getXImage();
									grid[cpuX][cpuY].hiddenValue = 3;
									break;
								}
								if (cpuNumPlays >= Math.floor(m * n / 2)) {
									winnerState = true;
									if(winnerState) {
										System.out.println("TIE");
										break;
									}
								}
								
							} while (true);
						}

					} else if (p2 == true && cpu == false) {// Player 2 plays if cpu is false
						p1 = true;
						p2 = false;
						grid[row][col].img = getXImage();
						grid[row][col].hiddenValue = 2;
						seconNumPlays++;
						totPlays++;

					}
				}
			}
			repaint();
			
			win = 0;
			for (int y = col - k <= 0 ? 1 : col - k; y < n; y++) {// checking top to bottom
				if (grid[row][y - 1].img == null || grid[row][y].img == null) {
					continue;
				}
				if (grid[row][y - 1].hiddenValue == (grid[row][y].hiddenValue)) {
					win++;
				} else {
					win = 0;
				}
				
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			for (int y = cpuY - k <= 0 ? 1 : cpuY - k; y < n; y++) {// checking top to bottom for CPU
				if (grid[cpuX][y - 1].img == null || grid[cpuX][y].img == null) {
					continue;
				}
				if (grid[cpuX][y - 1].hiddenValue == (grid[cpuX][y].hiddenValue)) {
					win++;
				} else {
					win = 0;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			for (int x = row - k <= 0 ? 1 : row - k; x < n; x++) {// checking horizontal
				if (grid[x - 1][col].img == null || grid[x][col].img == null) {
					continue;
				}
				if (grid[x - 1][col].hiddenValue == (grid[x][col].hiddenValue)) {
					win++;
				} else {
					win = 0;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 
					if(winnerState) {
						return;
					}
				}
			}
			
			win = 0;
			for (int x = cpuX - k <= 0 ? 1 : cpuX - k; x < n; x++) {// checking horizontal CPU
				if (grid[x - 1][cpuY].img == null || grid[x][cpuY].img == null) {
					continue;
				}
				if (grid[x - 1][cpuY].hiddenValue == (grid[x][cpuY].hiddenValue)) {
					win++;
				} else {
					win = 0;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			for (int x = row + 1, y = col + 1; x < m && y < n; ++x, ++y) {//top left to bottom right diag
				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 

				}
			}
			for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; --x, --y) {//top left to bottom right diag
				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			for (int x = cpuY + 1, y = cpuY + 1; x < m && y < n; ++x, ++y) {//top left to bottom right diag CPU
				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}

				}
			}
			for (int x = cpuX - 1, y = cpuY - 1; x >= 0 && y >= 0; --x, --y) {//top left to bottom right diag CPU2
				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			
			win = 0;
			for (int x = row - 1, y = col + 1; x >= 0 && y < n; --x, ++y) {//checks down left
				// top right to bottom left
				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 
					if(winnerState) {
						return;
					}
				}
			}
			for (int x1 = row + 1, y1 = col - 1; x1 < m && y1 >= 0; ++x1, --y1) {
				if ((grid[row][col].hiddenValue == grid[x1][y1].hiddenValue)) {
					win++;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins!");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			for (int x = cpuX - 1, y = cpuY + 1; x >= 0 && y < n; --x, ++y) {//checks down left CPU
				// top right to bottom left
				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					continue;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}

				}
			}
			for (int x1 = cpuX + 1, y1 = cpuY - 1; x1 < m && y1 >= 0; ++x1, --y1) {
				if ((grid[cpuX][cpuY].hiddenValue == grid[x1][y1].hiddenValue)) {
					win++;
				}
				if (win == k - 1) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 0;
			if (seconNumPlays >= Math.floor(m * n / 2) && totPlays == m * n) {		
				drawState = true;
				if(drawState) {
					System.out.println("TIE");
					return;
				}
			}
			/*
			 * if(win == k - 1) { if (grid[row][col].hiddenValue == 1) {
			 * System.out.println("Player 1 wins!"); } else if (grid[row][col].hiddenValue
			 * == 2) { System.out.println("Player 2 wins!"); } else if
			 * (grid[row][col].hiddenValue == 3){ System.out.println("CPU wins!"); }
			 * System.exit(0); }
			 */
			restartTimer();
		}
	}

	/*public placeToken randomCoords(int m, int n) {
		Random randCoord = new Random();
		int upperX = randCoord.nextInt(m);
		int upperY = randCoord.nextInt(n);
		return new placeToken(upperX, upperY);
	}*/
	
	public int randomCoords(int n) {
		Random randCoord = new Random();
		int upperY = randCoord.nextInt(n);
		return upperY;
	}

	public Image getXImage() {
		BufferedImage tokenX = null;
		try {
			// String stringPatch = Class.getResource("Images/O.png");
			tokenX = ImageIO.read(new File("X.png"));
			return tokenX.getScaledInstance(TILE_SIZE - 2, TILE_SIZE - 2, Image.SCALE_SMOOTH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public Image getOImage() {
		BufferedImage tokenO = null;
		try {
			// String stringPatch = Class.getResource("Images/O.png");
			tokenO = ImageIO.read(new File("O.png"));
			return tokenO.getScaledInstance(TILE_SIZE - 2, TILE_SIZE - 2, Image.SCALE_SMOOTH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	/*public void playTheCpu() {
		do {
			placeToken cpuPlay = randomCoords(m, n);
			if (grid[cpuPlay.point.x][cpuPlay.point.y].img == null) {
				cpuNumPlays++;
				grid[cpuPlay.point.x][cpuPlay.point.y].img = getXImage();
				grid[cpuPlay.point.x][cpuPlay.point.y].hiddenValue = 3;
				System.out.printf("%d", grid[cpuPlay.point.x][cpuPlay.point.y].hiddenValue);
				break;
			}
			if (cpuNumPlays >= Math.floor(m * n / 2)) {
				System.out.println("TIE");
				break;
			}

		} while (true);
	}*/

	public void chooseWinner() {

	}

}//gridCreate

class thr extends JFrame implements ActionListener{
	JButton b0;//1P
	JButton b1;//2P
	JLabel mm;
	ImageIcon img0;

	thr(){
	
		//mainmenu
		img0 = new ImageIcon("MainMenu.png");

		//main menu
		mm = new JLabel();
		mm.setIcon(img0);
		mm.setSize(500,400);

		//buttons
		b0 = new JButton();//1P
		b0.setBounds(140,400,100,50);
		b0.addActionListener(this);
		b0.setText("1P");

		b1 = new JButton();//2P
		b1.setBounds(35,400,100,50);
		b1.addActionListener(this);
		b1.setText("2P");

		//frame data
		this.setTitle("TicTacToo");
		this.setSize(500,500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(mm);
		this.add(b0);
		this.add(b1);
		this.setVisible(true);
		b0.setVisible(true);
		b1.setVisible(true);
		
	}//thr

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b0){//1P
			SwingUtilities.invokeLater(() -> {
				gridCreate view = new gridCreate();
				view.setPreferredSize(new Dimension(1210, 1000));
				JFrame frame = new JFrame();
				frame.setLayout(new BorderLayout());
				frame.add(view, BorderLayout.CENTER);
				frame.setTitle("TicTacToo");
				frame.getContentPane().add(view);
				frame.setResizable(true);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//hide other window
				this.setVisible(false);
				frame.setVisible(true);
				//set CPU to true
				view.cpu = true;
				view.requestFocus();
				view.start();
			});
		}//if
		else if(e.getSource() == b1){//2P
			SwingUtilities.invokeLater(() -> {
				gridCreate view = new gridCreate();
				view.setPreferredSize(new Dimension(1210, 1000));
				JFrame frame = new JFrame();
				frame.setLayout(new BorderLayout());
				frame.add(view, BorderLayout.CENTER);
				frame.setTitle("TicTacToo");
				frame.getContentPane().add(view);
				frame.setResizable(true);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//hide other window
				this.setVisible(false);
				frame.setVisible(true);
				view.requestFocus();
				view.start();
			});
		}//if
	}//actionPerformed

}//thr
