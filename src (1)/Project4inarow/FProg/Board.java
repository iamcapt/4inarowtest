package FProg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Board extends JFrame {
	
    JMenuBar menuBar;
    JMenu options, color, time, setsz;
    JMenuItem restart, resume, menu, size1, size2, size3, exit;
    JMenu player1, player2;
    JMenuItem black, blue, pink, green, red, yellow;
    
    JLabel timer;
    JLabel m;
    
    int count =0;
    private static int boradRow = 7;
    private static int boradCol = 6;

    private static final int IMG_SIZE = 100;

    //build a board with logic cells 
    BoardLogic board1[][] = boardInit(boradRow, boradCol);

    //build a board with label
    JLabel[][] btn= new JLabel[board1.length][board1[0].length];

    // set icons
    ImageIcon empty = new ImageIcon(getClass().getResource("/icon/empty.png"));
    ImageIcon redIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/red.png")));
    ImageIcon yelloIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/yellow.png")));
    ImageIcon pinkIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/pink.png")));
    ImageIcon greenIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/green.png")));
    ImageIcon blueIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/blue.png")));
    ImageIcon blackIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/black.png")));
    ImageIcon player1Icon = pinkIcon;
    ImageIcon player2Icon = redIcon;
    
 
    
    JLabel player1Label = new JLabel("Player1");
    JLabel player2Label = new JLabel("Player2");

    //set frame , panels
    JFrame frame;
    JPanel panel = new JPanel();
    JPanel panelOption = new JPanel();


    public Board() {

    	//set frame //
        frame = new JFrame();
        frame.setLayout(new BorderLayout(20, 15));
        panel.setBackground(SystemColor.activeCaption);
        panel.setSize(200, 200);
        setTitle("4 in a row");
       

                                 // menu bar: // 
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // option - restart ,resume,menu ,exit//

        options = new JMenu("Options");
        menuBar.add(options);

        restart = new JMenuItem("Restart");
        
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
          frame.dispose();
          new Board();

          }
      });
        options.add(restart);
        /*
        resume = new JMenuItem("Resume");
        options.add(resume);*/
        
        menu = new JMenuItem("Menu");
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainIntrence();
                frame.dispose();

            }
        });

        options.add(menu);

        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        options.add(exit);

        // set size - 5x5, 7x6, 16x16//

        setsz = new JMenu("Set Size");
        menuBar.add(setsz);

        size1 = new JMenuItem("5X5");
        setsz.add(size1);
        size2 = new JMenuItem("7X6");
        size2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	boradRow =7;
            	boradCol =6;
            	
            	
            	  board1= boardInit(boradRow, boradCol);

          	    //build a board with label
          	     btn = new JLabel[board1.length][board1[0].length];
            }
        });
        setsz.add(size2);
        size3 = new JMenuItem("14X12");
        size3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
            	boradRow =14;
            	boradCol =12;
            	  board1= boardInit(boradRow, boradCol);

            	    //build a board with label
            	     btn = new JLabel[board1.length][board1[0].length];

            	    
            }
        });
        setsz.add(size3);

                                    // color: //

        color = new JMenu("Color");
        menuBar.add(color);

        // player 1 - black,blue,pink
        player1 = new JMenu("Player 1");
        color.add(player1);

        black = new JMenuItem("Black");
        black.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player1Icon = blackIcon;
            	  
            	  ChangeIcon1(board1,player1Icon);

            }
        });
        player1.add(black);
        blue = new JMenuItem("Blue");
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player1Icon = blueIcon;
            	  
            	  ChangeIcon1(board1,player1Icon);

            }
        });
        player1.add(blue);

        pink = new JMenuItem("Pink");
        pink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player1Icon = pinkIcon;
            	  
            	  ChangeIcon1(board1,player1Icon);

            }
        });
        player1.add(pink);


        //player 2 (green , red , yellow)
        
        player2 = new JMenu("Player 2");
        color.add(player2);

        green = new JMenuItem("Green");
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player2Icon = greenIcon;
            	
            	  ChangeIcon2(board1,player2Icon);
            	  

            }
        });
        player2.add(green);
        
        red = new JMenuItem("Red");
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player2Icon = redIcon;
          
            	  ChangeIcon2(board1,player2Icon);

            }
        });
        player2.add(red);
        
        yellow = new JMenuItem("Yellow");
        yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  player2Icon = yelloIcon;
            	  ChangeIcon2(board1,player2Icon);


            }
        });
        player2.add(yellow);

                              // set time ://
        time = new JMenu("Set Time");
        menuBar.add(time);

        frame.setJMenuBar(menuBar);

                            //set board://        

        panel.setBackground(Color.white);
        panel.setFocusable(true);
        panel.setLayout(null);
   
        for (int row = 0; row < board1.length; row++) {
            for (int col = 0; col < board1[0].length; col++) {
            	
            	//set btn to label and put a number for each col
            	
                btn[row][col] = new JLabel();
                btn[row][col].setText(String.valueOf(row));
                 
                // check which col did the mouse click and put a piece according to the free space
                
                btn[row][col].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	count ++;
                        String cellText = ((JLabel) e.getComponent()).getText();
                        checkMove(board1, Integer.parseInt(cellText));

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                
                // set bounds for the icon and put there an empty piece
                btn[row][col].setBounds(row * 100, col * 100, 100, 100);
                btn[row][col].setIcon(empty);
                panel.add(btn[row][col]);


               

            }
        }

         //set the headlines
        
        timer = new JLabel("Time Left");
        timer.setFont(new Font("Calibri", Font.BOLD, 39));
        timer.setForeground(Color.blue);
        timer.setHorizontalAlignment(SwingConstants.CENTER);
        panelOption.add(timer);
        panelOption.setSize(200, 100);
        panel.setSize(200, 200);
        panel.setMaximumSize(new Dimension(8 * IMG_SIZE, 8 * IMG_SIZE));
        frame.add(panel, BorderLayout.CENTER);
        player1Label.setFont(new Font("Calibri", Font.BOLD, 39));
        player2Label.setFont(new Font("Calibri", Font.BOLD, 39));
        player1Label.setIcon( player1Icon);
        player2Label.setIcon( player2Icon);
        Panel playerOnePanel = new Panel();
        Panel playerTwoPanel = new Panel();
        playerOnePanel.add(player1Label);
        playerTwoPanel.add(player2Label);
        frame.add(playerOnePanel, BorderLayout.EAST);
        frame.add(playerTwoPanel, BorderLayout.WEST);
        frame.add(panelOption, BorderLayout.NORTH);

        frame.setResizable(false);

        // set place for the frame 
        frame.setSize(boradRow * IMG_SIZE + 530, boradCol * IMG_SIZE +160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    //  sets the Board Logics
    public BoardLogic[][] boardInit(int row, int col) {
   
        BoardLogic[][] gameBoard = new BoardLogic[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameBoard[i][j] = new BoardLogic();
                System.out.println(gameBoard[i][j].cellStatus);

            }
        }

        return gameBoard;
    }

    
    //run a backwards loop that check where is a free space and put there a pice 
    
    public void checkMove(BoardLogic[][] borad, int Col) {
    	
        for (int j = borad[0].length - 1; j >= 0; j--) {
            if (borad[Col][j].cellStatus == 0) {
                System.out.println(j);

                if(count%2==0) {
                	borad[Col][j].cellStatus=2;
                	btn[Col][j].setIcon(player2Icon);
                }
                else {
                
                borad[Col][j].cellStatus = 1;
                btn[Col][j].setIcon(player1Icon);
               
                }
                
                break;
            }
            
        }


    }

    public void ChangeIcon2(BoardLogic[][] borad, ImageIcon player2Icon ) {
    	
    	  player2Label.setIcon( player2Icon);
    	  
    	 for (int i = borad[0].length - 1; i >= 0; i--) {
 			 for(int z=borad.length-1;z>=0;z--) {
 			 if(borad[z][i].cellStatus==2) {
 				 btn[z][i].setIcon(player2Icon);
 			 }
 			
 			 }
 		 }
    }
    
    public void ChangeIcon1(BoardLogic[][] borad, ImageIcon player1Icon ) {
    	
  	  player1Label.setIcon( player1Icon);
  	  
  	   for (int i = borad[0].length - 1; i >= 0; i--) {
			 for(int z=borad.length-1;z>=0;z--) {
			 if(borad[z][i].cellStatus==1) {
				 btn[z][i].setIcon(player1Icon);
			 }
			
			 }
		 }
  }
    
    public void BoardSize(int boradRow ,int boradCol) {
    	
    	
    	 btn = new JLabel[board1.length][board1[0].length];

    	
    }

}
	

