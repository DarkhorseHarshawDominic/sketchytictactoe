<<<<<<< HEAD
package something;
=======

>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
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
<<<<<<< HEAD


@SuppressWarnings({ "serial", "unused" })
public class gridCreate extends JPanel implements ActionListener {
	static int m = 0;// x
	static int n = 0;// y
	static int k = 0;
=======


@SuppressWarnings({ "serial", "unused" })
public class gridCreate extends JPanel implements ActionListener {
	int m = 3;// x
	int n = 3;// y
	int k = 3;
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
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
<<<<<<< HEAD
	public static boolean difficulty = true;
	public static boolean cpuBlock = false;
=======
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
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
<<<<<<< HEAD
		if (m >= n) {
			if (m <= 4) {
				int size = 25;
				TILE_SIZE = size;
			} else if (m <= 5) {
				int size = 25;
				TILE_SIZE = size;
			} else if (m <= 10) {
				int size = 25;
				TILE_SIZE = size;
			} else if (m <= 20) {
				int size = 25;
				TILE_SIZE = size;
			} else if (m <= 50) {
				int size = 15;
				TILE_SIZE = size;
			} else if (m <= 60) {
				int size = 16;
				TILE_SIZE = size;
			} else if (m <= 70) {
				int size = 14;
				TILE_SIZE = size;
			} else if (m <= 90) {
				int size = 11;
				TILE_SIZE = size;
			} else if (m <= 100) {
				int size = 10;
				TILE_SIZE = size;
			}
		} // if
		else if (n >= m) {
			if (n <= 4) {
				int size = 50;
				TILE_SIZE = size;
			} else if (n <= 5) {
				int size = 50;
				TILE_SIZE = size;
			} else if (n <= 10) {
				int size = 50;
				TILE_SIZE = size;
			} else if (n <= 20) {
				int size = 25;
				TILE_SIZE = size;
			} else if (n <= 50) {
				int size = 15;
				TILE_SIZE = size;
			} else if (n <= 60) {
				int size = 16;
				TILE_SIZE = size;
			} else if (n <= 70) {
				int size = 14;
				TILE_SIZE = size;
			} else if (n <= 90) {
				int size = 11;
				TILE_SIZE = size;
			} else if (n <= 100) {
				int size = 10;
				TILE_SIZE = size;
			} // else if
		} // if
	}// scale
=======
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
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82

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
<<<<<<< HEAD
=======

>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
	}

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
=======

>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
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
<<<<<<< HEAD

	}
	public static int time = 30;
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
		time = 30;
	}
	
	private class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {

			
			int row = e.getX() / TILE_SIZE;
			int col = e.getY() / TILE_SIZE;
			int cpuX = 0;
			int cpuY = 0;
			int win = 1;
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
							cpuBlock = false;
							boolean blockFlag = false;
							int blockCounter;
							if(difficulty = true) {//block logic
								blockCounter = 1;
								for (int y = col + 1; y < n; y++) {// check below the player's placed token
									if (blockFlag == true) {
										break;
									}
									if (cpuNumPlays > Math.floor(m * n / 2)) {
										winnerState = true;
										if(winnerState) {
											System.out.println("TIE");
											return;
										}
									}
									if(n == 1) {
										break;
									}
									if(y == n) {
										//System.out.println("broken");
										break;
									}
									if ((grid[row][col].hiddenValue == grid[row][y].hiddenValue)) {
										blockCounter++;
										//System.out.println("incre");
										continue;
									}									
									
									if (blockCounter == k - 1) {
										if(y < n) {
											System.out.println("blocked below");
											cpuX = row;
											cpuY = y;
											if (grid[cpuX][cpuY].img == null) {
												grid[cpuX][cpuY].img = getXImage();
												grid[cpuX][cpuY].hiddenValue = 3;
												cpuNumPlays++;
												blockFlag = true;
											}
											else {
												break;
											}
											cpuBlock = true;
											break;
										}
										else if (y == n) {
											//System.out.println("broken");
											break;
										}
									}

									if (grid[row][y].hiddenValue == 0) {
										//System.out.println("broken");
										blockCounter = 1;
										break;
									}
								}
								for (int y = col - 1; y >= 0; y--) {// check above the player's placed token
									if (blockFlag == true) {
										break;
									}
									if (cpuNumPlays > Math.floor(m * n / 2)) {
										winnerState = true;
										if(winnerState) {
											System.out.println("TIE");
											return;
										}
									}
									if(n == 1) {
										break;
									}
									if(y == -1) {
										//System.out.println("broken");
										break;
									}
									if ((grid[row][col].hiddenValue == grid[row][y].hiddenValue)) {
										blockCounter++;
										//System.out.println("incre");
										continue;
									}									
									
									if (blockCounter == k - 1) {
										
										if(y >= 0) {
											cpuX = row;
											cpuY = y;
											if (grid[cpuX][cpuY].img == null) {
												grid[cpuX][cpuY].img = getXImage();
												grid[cpuX][cpuY].hiddenValue = 3;
												cpuNumPlays++;
												blockFlag = true;
											}
											else {
												break;
											}
											cpuBlock = true;
											break;
										}
										else if (y < 0) {
											//System.out.println("broken");
											break;
										}
									}

									if (grid[row][y].hiddenValue == 0) {
										//System.out.println("broken");
										blockCounter = 1;
										break;
									}
								}
								blockCounter = 1;
								for (int x = row + 1; x < m; x++) {// check right of the player's placed token
									if (blockFlag == true) {
										break;
									}
									if (cpuNumPlays > Math.floor(m * n / 2)) {
										winnerState = true;
										if(winnerState) {
											System.out.println("TIE");
											return;
										}
									}
									if(n == 1) {
										break;
									}
									if(x == m) {
										//System.out.println("broken");
										break;
									}
									if ((grid[row][col].hiddenValue == grid[x][col].hiddenValue)) {
										blockCounter++;
										//System.out.println("incre");
										continue;
									}									
									
									if (blockCounter == k - 1) {
										
										if(x < m) {
											cpuX = x;
											cpuY = col;
											if (grid[cpuX][cpuY].img == null) {
												grid[cpuX][cpuY].img = getXImage();
												grid[cpuX][cpuY].hiddenValue = 3;
												cpuNumPlays++;
												blockFlag = true;
											}
											else {
												break;
											}
											cpuBlock = true;
											break;
										}
										else if (x == n) {
											//System.out.println("broken");
											break;
										}
									}

									if (grid[x][col].hiddenValue == 0) {
										//System.out.println("broken");
										blockCounter = 1;
										break;
									}
								}
								for (int x = row - 1; x >= 0; x--) {// check left of the player's placed token
									System.out.println("entered blocked left");
									if (blockFlag == true) {
										break;
									}
									if (cpuNumPlays > Math.floor(m * n / 2)) {
										winnerState = true;
										if(winnerState) {
											System.out.println("TIE");
											return;
										}
									}
									if(n == 1) {
										break;
									}
									if(x == -1) {
										//System.out.println("broken");
										break;
									}
									if ((grid[row][col].hiddenValue == grid[x][col].hiddenValue)) {
										blockCounter++;
										//System.out.println("incre");
										continue;
									}									
									
									if (blockCounter == k - 1) {
										
										if(x >= 0) {
											System.out.println("blocked left");
											cpuX = x;
											cpuY = col;
											if (grid[cpuX][cpuY].img == null) {
												grid[cpuX][cpuY].img = getXImage();
												grid[cpuX][cpuY].hiddenValue = 3;
												cpuNumPlays++;
												blockFlag = true;
											}
											else {
												break;
											}
											cpuBlock = true;
											break;
										}
										else if (x == -1) {
											//System.out.println("broken");
											break;
										}
									}

									if (grid[x][col].hiddenValue == 0) {
										//System.out.println("broken");
										blockCounter = 1;
										break;
									}
								}
								blockCounter = 1;//start adding diagonals here
							}
							
							
							int breakCounter = 0;
							if(cpuBlock == false) {
								do {
									
									cpuX = randomCoords(m);
									cpuY = randomCoords(n);
									if (grid[cpuX][cpuY].img == null) {
										cpuNumPlays++;
										grid[cpuX][cpuY].img = getXImage();
										grid[cpuX][cpuY].hiddenValue = 3;
										break;
									}

									if (cpuNumPlays > Math.floor(m * n / 2)) {
										winnerState = true;
										if(winnerState) {
											System.out.println("TIE");
											break;
										}
									}
									
									
									breakCounter++;
									if(breakCounter > m * n) {
										break;
									}
								} while (true);
							}
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
			
			win = 1;
			for (int y = col - k <= 0 ? 1 : col - k; y < n; y++) {// checking top to bottom
				if (grid[row][y - 1].img == null || grid[row][y].img == null) {
					win = 1;
					continue;
				}
				if (grid[row][y - 1].hiddenValue == (grid[row][y].hiddenValue)) {
					win++;
				} else {
					win = 1;
				}
				
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! verti");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
			for (int y = cpuY - k <= 0 ? 1 : cpuY - k; y < n; y++) {// checking top to bottom for CPU
				if (grid[cpuX][y - 1].img == null || grid[cpuX][y].img == null) {
					win = 1;
					continue;
				}
				if (grid[cpuX][y - 1].hiddenValue == (grid[cpuX][y].hiddenValue)) {
					win++;
				} else {
					win = 1;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! verti");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
			for (int x = row - k <= 0 ? 1 : row - k; x < m; x++) {// checking horizontal
				if (grid[x - 1][col].img == null || grid[x][col].img == null) {
					win = 1;
					continue;
				}
				if (grid[x - 1][col].hiddenValue == (grid[x][col].hiddenValue)) {
					win++;
				} else {
					win = 1;
				}
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! hori");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 
					if(winnerState) {
						return;
					}
				}
			}
			
			win = 1;
			for (int x = cpuX - k <= 0 ? 1 : cpuX - k; x < m; x++) {// checking horizontal CPU
				if (grid[x - 1][cpuY].img == null || grid[x][cpuY].img == null) {
					win = 1;
					continue;
				}
				if (grid[x - 1][cpuY].hiddenValue == (grid[x][cpuY].hiddenValue)) {
					win++;
				} else {
					win = 1;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! hori");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
			for (int x = row + 1, y = col + 1; x < m && y < n; ++x, ++y) {//top left to bottom right diag
				if(m == 1 || n == 1)
					break;
				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! down right");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 

				}
			}
			for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; --x, --y) {//top left to bottom right diag
				if(m == 1 || n == 1)
					break;

				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! up left");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
			for (int x = cpuY + 1, y = cpuY + 1; x < m && y < n; ++x, ++y) {//top left to bottom right diag CPU
				if(m == 1 || n == 1)
					break;

				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! down right");
					}

				}
			}
			for (int x = cpuX - 1, y = cpuY - 1; x >= 0 && y >= 0; --x, --y) {//top left to bottom right diag CPU
				if(m == 1 || n == 1)
					break;
				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! up left");
					}
					if(winnerState) {
						return;
					}
				}
			}
			
			win = 1;
			for (int x = row - 1, y = col + 1; x >= 0 && y < n; --x, ++y) {//checks down left player
				// top right to bottom left
				if(m == 1 || n == 1)
					break;

				if ((grid[row][col].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[row][col].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! down left");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					} 
					if(winnerState) {
						return;
					}
				}
			}
			for (int x1 = row + 1, y1 = col - 1; x1 < m && y1 >= 0; ++x1, --y1) {//player up right
				if(m == 1 || n == 1)
					break;

				if ((grid[row][col].hiddenValue == grid[x1][y1].hiddenValue)) {
					win++;
				}
				if ((grid[x1][y1].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[row][col].hiddenValue == 1) {
						System.out.println("Player 1 wins! up right");
					} else if (grid[row][col].hiddenValue == 2) {
						System.out.println("Player 2 wins!");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
			for (int x = cpuX - 1, y = cpuY + 1; x >= 0 && y < n; --x, ++y) {//checks down left CPU
				// top right to bottom left
				if(m == 1 || n == 1)
					break;

				if ((grid[cpuX][cpuY].hiddenValue == grid[x][y].hiddenValue)) {
					win++;
				}
				if ((grid[x][y].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! down left");
					}

				}
			}
			for (int x1 = cpuX + 1, y1 = cpuY - 1; x1 < m && y1 >= 0; ++x1, --y1) {
				if(m == 1 || n == 1)
					break;

				if ((grid[cpuX][cpuY].hiddenValue == grid[x1][y1].hiddenValue)) {
					win++;
				}
				if ((grid[x1][y1].hiddenValue == 0 || grid[cpuX][cpuY].hiddenValue == 0)) {
					break;
				}
				if (win == k) {
					winnerState = true;
					if (grid[cpuX][cpuY].hiddenValue == 3) {
						System.out.println("CPU wins! up right");
					}
					if(winnerState) {
						return;
					}
				}
			}
			win = 1;
=======

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
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
			if (seconNumPlays >= Math.floor(m * n / 2) && totPlays == m * n) {		
				drawState = true;
				if(drawState) {
					System.out.println("TIE");
					return;
				}
			}
			/*
<<<<<<< HEAD
			 * if(win == k) { if (grid[row][col].hiddenValue == 1) {
=======
			 * if(win == k - 1) { if (grid[row][col].hiddenValue == 1) {
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
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
<<<<<<< HEAD
	
	public void cpuBlock() {
		
	}
=======
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82

	public void chooseWinner() {

	}

<<<<<<< HEAD
//}//gridCreate

static class thr extends JFrame implements ActionListener{
=======
}//gridCreate

class thr extends JFrame implements ActionListener{
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
	JButton b0;//1P
	JButton b1;//2P
	JLabel mm;
	ImageIcon img0;
<<<<<<< HEAD
	JTextField textField[];
	JLabel mLabel;
	JLabel nLabel;
	JLabel kLabel;
	//int mVal = 0;
	//int nVal = 0;
	//int kVal = 0;
	int flag = 0;
=======
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82

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

<<<<<<< HEAD
		//textbox
		textField = new JTextField[3];
		textField[0] = new JTextField(20);
		textField[1] = new JTextField(20);
		textField[2] = new JTextField(20);
		textField[0].addActionListener(this);
		textField[1].addActionListener(this);
		textField[2].addActionListener(this);
		textField[0].setBounds(35,425,40,50);
		textField[1].setBounds(140,425,40,50);
		textField[2].setBounds(245,425,40,50);

		//grid values label
		mLabel = new JLabel();
		mLabel.setBounds(35,400,25,25);
		mLabel.setText("M");
		mLabel.setLayout(null);

		nLabel = new JLabel();
		nLabel.setBounds(140,400,25,25);
		nLabel.setText("N");
		nLabel.setLayout(null);
		kLabel = new JLabel();
		kLabel.setBounds(245,400,25,25);
		kLabel.setText("K");
		kLabel.setLayout(null);


=======
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
		//frame data
		this.setTitle("TicTacToo");
		this.setSize(500,500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(mm);
		this.add(b0);
		this.add(b1);
<<<<<<< HEAD
		this.add(textField[0]);
		this.add(textField[1]);
		this.add(textField[2]);
		this.add(mLabel);
		mLabel.setVisible(true);	
		this.add(nLabel);
		nLabel.setVisible(true);
		this.add(kLabel);
		kLabel.setVisible(true);
		textField[0].setVisible(true);
		textField[1].setVisible(true);
		textField[2].setVisible(true);
		this.setVisible(true);
		b0.setVisible(false);
		b1.setVisible(false);
=======
		this.setVisible(true);
		b0.setVisible(true);
		b1.setVisible(true);
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
		
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
<<<<<<< HEAD
		else if(e.getSource() == textField[0]){
			String text = textField[0].getText();
			m = Integer.parseInt(text) % 101;
			textField[0].setVisible(false);
			mLabel.setVisible(false);
			flag |= 4;
			mnkChk();
		}//else if	
		else if(e.getSource() == textField[1]){
			String text = textField[1].getText();
			n = Integer.parseInt(text) % 101;
			textField[1].setVisible(false);
			nLabel.setVisible(false);
			flag |= 2;
			mnkChk();
		}//else if
	else if(e.getSource() == textField[2]){
			String text = textField[2].getText();
			k = Integer.parseInt(text) % 101;
			textField[2].setVisible(false);
			kLabel.setVisible(false);
			flag |= 1;
			mnkChk();
		}//else if

	}//actionPerformed

		void mnkChk(){
			if((flag & 7) == 7){
				b0.setVisible(true);
				b1.setVisible(true);
			}//if
		}//mnk

}//thr
}//gridCreate
=======
	}//actionPerformed

}//thr
>>>>>>> 9b3d96904f924e66f2247e261fddec1410b43a82
