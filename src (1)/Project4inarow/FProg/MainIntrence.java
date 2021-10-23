package FProg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainIntrence extends JFrame {

	// sets buttons and label
    JButton singlepl;
    JButton mulitypl;
    JButton exit;

    JLabel had;

    // sets icones 
	ImageIcon sPlayerIcon   = new ImageIcon(getClass().getResource("/icon/splayer.png"));
	ImageIcon gameIcon   = new ImageIcon(getClass().getResource("/icon/Picture1.png"));
	ImageIcon mPlayerIcon   = new ImageIcon(getClass().getResource("/icon/mplayer2.png"));

	 JFrame frame1 = new JFrame();


    public MainIntrence() {

    	//sets the panel ant the frame
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setVisible(true);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        // sets the headline
        had = new JLabel("Four in a Row ");
        had.setFont(new Font("Calibri", Font.BOLD, 39));
		had.setForeground(Color.white);
		had.setHorizontalAlignment(SwingConstants.CENTER);
		had.setIcon(getScaledImage(gameIcon,60,60));
		panel.add(had);

		// sets the button single player 
        singlepl = new JButton("Single Player");
        singlepl.setBackground(SystemColor.inactiveCaption);
        singlepl.setFont(new Font("Calibri", Font.BOLD, 34));
		singlepl.setIcon(getScaledImage(sPlayerIcon,60,60));
		singlepl.setBackground(Color.white);
        panel.add(singlepl);

        //sets the button multiplier, if you click it, it take you to the board
        mulitypl = new JButton("Multiplier");
        mulitypl.setBackground(SystemColor.inactiveCaption);
        mulitypl.setFont(new Font("Calibri", Font.BOLD, 34));
		mulitypl.setIcon(getScaledImage(mPlayerIcon,60,60));
		mulitypl.setBackground(Color.white);
		
		mulitypl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Board();
                frame1.dispose();
            }
        });
        panel.add(mulitypl);

        // sets the exit button , if you click it you exit the game
        exit = new JButton(" Exit ");
        exit.setBackground(SystemColor.inactiveCaption);
        exit.setFont(new Font("Calibri", Font.BOLD, 34));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();

            }
        });
        panel.add(exit);
        
        //sets frame size and put icons
		frame1.setSize(500, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().add(panel);
        frame1.setSize(600,500);
        frame1.setIconImage(gameIcon.getImage());
        frame1.setLocationRelativeTo(null);

        frame1.setVisible(true);




    }

    // Receiving icons and their wanted size and changing it 
	private ImageIcon getScaledImage(ImageIcon srcImgIcon, int w, int h){
		Image image = srcImgIcon.getImage(); // transform it
		Image newImg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		srcImgIcon = new ImageIcon(newImg);  // transform it back
		return srcImgIcon;
	}

}


