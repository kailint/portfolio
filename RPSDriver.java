import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * Program creating the Rock Paper Scissors game 
 * as a GUI for a user playing against the computer
 * 
 * @author      Kailin Torres
 * @assignment  RPS GUI File
 * @date        17 October 2021
 */

public class RPSDriver extends JFrame {

    // add images 
    // find out how to make buttons just the word
    // find out how to implement being able to use keyboard and interface buttons

    // image icons
    private ImageIcon rockI;
    private ImageIcon paperI;
    private ImageIcon scissorsI;
    
    // buttons
    private JButton instructions = new JButton("INSTRUCTIONS");
    private JButton rockB = new JButton(rockI);
    private JButton paperB = new JButton(paperI);
    private JButton scissorsB = new JButton(scissorsI);
    private JButton play = new JButton("PLAY");
    private JButton again = new JButton("PLAY AGAIN");
    private JButton quit = new JButton("QUIT");
    private JButton options = new JButton("OPTIONS");

    // labels
    private JLabel rps = new JLabel("ROCK PAPER SCISSORS");
    private JLabel choice = new JLabel("CHOOSE ONE:");
    private JLabel userC = new JLabel("USER ");
    private JLabel cpuC = new JLabel("COMPUTER ");
    private JLabel userP = new JLabel(" ");
    private JLabel cpuP = new JLabel(" ");
    private JLabel score = new JLabel("SCORE: ");
    private JLabel tied = new JLabel("TIES: ");
    private JLabel cpuS = new JLabel("CPU: ");
    private JLabel userS = new JLabel("USER: ");
    private JLabel result = new JLabel("RESULTS: ");
    private JLabel border = new JLabel("");

    // texts
    private JLabel author = new JLabel("Author: ");
    private JLabel name = new JLabel("\tKailin Torres");

    // width & height
    private final int WIDTH = 1000;
    private final int HEIGHT = 700;

    // create file to print scores to
    File scores = new File("scores.txt");

    public RPSDriver() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("ROCK  PAPER  SCISSORS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void initializeGUI() throws Exception {

        // action listener
        ActionListener ears = new MyListener();
        instructions.addActionListener(ears);
        rockB.addActionListener(ears);
        paperB.addActionListener(ears);
        scissorsB.addActionListener(ears);
        play.addActionListener(ears);
        again.addActionListener(ears);
        quit.addActionListener(ears);
        options.addActionListener(ears);

        // add key listener ?

        // jpanels
        JPanel jp = new JPanel();
        JPanel center = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        
        // panel layout
        jp.setLayout(new BorderLayout());
        bottom.setLayout(new GridLayout(1, 4));

        // panel colors
        jp.setBackground(Color.pink);
        center.setBackground(Color.pink);
        left.setBackground(Color.pink);
        right.setBackground(Color.pink);
        top.setBackground(Color.pink);
        bottom.setBackground(Color.pink);

        // button colors
        instructions.setForeground(Color.black);
        options.setForeground(Color.black);
        quit.setForeground(Color.black);
        
        // button sizes
        instructions.setPreferredSize(new Dimension(155, 40));
        options.setPreferredSize(new Dimension(135, 40));

        // images
        rockI = new ImageIcon(getClass().getResource("/Rock.png"));
        paperI = new ImageIcon(getClass().getResource("/Paper.png"));
        scissorsI = new ImageIcon(getClass().getResource("/Scissor.png"));
        Image iRock = rockI.getImage();
        Image iPaper = paperI.getImage();
        Image iScissors = scissorsI.getImage();
        Image rockN = iRock.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        Image paperN = iPaper.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        Image scissorsN = iScissors.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        rockI = new ImageIcon(rockN);
        paperI = new ImageIcon(paperN);
        scissorsI = new ImageIcon(scissorsN);   
        rockB.setIcon(rockI);
        paperB.setIcon(paperI);
        scissorsB.setIcon(scissorsI);

        // set sizes
        top.setPreferredSize(new Dimension(100, 75));
        left.setPreferredSize(new Dimension(150, 75));
        right.setPreferredSize(new Dimension(150, 75));
        center.setPreferredSize(new Dimension(180, 100));
        bottom.setPreferredSize(new Dimension(150,150));
        
        // borders
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        border.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        instructions.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        options.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        quit.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        rps.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        score.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        userS.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 80));
        cpuS.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 80));
        tied.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 80));
        userC.setBorder(BorderFactory.createEmptyBorder(5, 90, 5, 90));
        cpuC.setBorder(BorderFactory.createEmptyBorder(5, 90, 5, 90));
        userP.setBorder(BorderFactory.createEmptyBorder(5, 150, 5, 150));
        cpuP.setBorder(BorderFactory.createEmptyBorder(5, 150, 5, 150));
        border.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        choice.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 10));
        result.setBorder(BorderFactory.createEmptyBorder(5, 90, 5, 90));
        rockB.setBorder(BorderFactory.createEmptyBorder(120, 120, 120, 120));
        paperB.setBorder(BorderFactory.createEmptyBorder(120, 120, 120, 120));
        scissorsB.setBorder(BorderFactory.createEmptyBorder(120, 120, 120, 120));



        // set label fonts and size
        rps.setFont(new Font("Monospaced", Font.BOLD, 50));
        choice.setFont(new Font("Monospaced", Font.BOLD, 20));
        userC.setFont(new Font("Monospaced", Font.BOLD, 20));
        cpuC.setFont(new Font("Monospaced", Font.BOLD, 20));
        score.setFont(new Font("Monospaced", Font.BOLD, 20));
        tied.setFont(new Font("Monospaced", Font.BOLD, 20));
        cpuS.setFont(new Font("Monospaced", Font.BOLD, 20));
        userS.setFont(new Font("Monospaced", Font.BOLD, 20));
        result.setFont(new Font("Monospaced", Font.BOLD, 20));
        author.setFont(new Font("Monospaced", Font.BOLD, 15));
        name.setFont(new Font("Monospaced", Font.BOLD, 15));

        // set button fonts and size
        instructions.setFont(new Font("Noto Sans Mono", Font.BOLD, 15));
        rockB.setFont(new Font("Noto Sans Mono", Font.BOLD, 20));
        paperB.setFont(new Font("Noto Sans Mono", Font.BOLD, 20));
        scissorsB.setFont(new Font("Noto Sans Mono", Font.BOLD, 20));
        play.setFont(new Font("Noto Sans Mono", Font.BOLD, 20));
        again.setFont(new Font("Noto Sans Mono", Font.BOLD, 20));
        quit.setFont(new Font("Noto Sans Mono", Font.BOLD, 15));
        options.setFont(new Font("Noto Sans Mono", Font.BOLD, 10));


        // add panel to TOP
        top.add(rps);

        // add panel to LEFT
        left.add(instructions);
        left.add(quit);
        left.add(border);
        left.add(author);
        left.add(name);

        // add panel to CENTER
       
        center.add(userC);
        center.add(userP);
        center.add(cpuC);
        center.add(cpuP);
        center.add(result);
        cpuP.setIcon(rockI);
        userP.setIcon(rockI);
       

        // add panel to RIGHT
        right.add(score);
        right.add(userS);
        right.add(cpuS);
        right.add(tied);

        // add panel to BOTTOM
        bottom.add(choice);
        bottom.add(rockB);
        bottom.add(paperB);
        bottom.add(scissorsB);

        // add to panels
        jp.add(top, BorderLayout.NORTH);
        jp.add(left, BorderLayout.WEST);
        jp.add(center, BorderLayout.CENTER);
        jp.add(right, BorderLayout.EAST);
        jp.add(bottom, BorderLayout.PAGE_END);

        jp.setVisible(true);
        center.setVisible(true);
        this.add(jp);
    }

    //inner class
    private class MyListener implements ActionListener {

        Random random = new Random();
        int user = 0;
        int cpu = 0;
        int ties = 0;
        int userW = 0;
        int cpuW = 0;
        int round = 0;
        boolean win = false;
        boolean lose = false;
        boolean draw = false;

        public void actionPerformed(ActionEvent event) {            
            try {
                // PrintWriter and FileWriter
                FileWriter fw = new FileWriter(scores, true);
                PrintWriter pw = new PrintWriter(fw);
                cpu = random.nextInt(3) + 1;

                // instructions
                if (event.getSource() == instructions) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Welcome to Rock Paper Scissors!"
                            + "\nInstructions: "
                            + "\n1. Choose between Rock, Paper, or Scissors"
                            + "\n2. CPU will choose their own"
                            + "\n3. The winner will earn a point"
                            + "\n4. To QUIT: Click the 'QUIT' button");
                    cpu = 0;
                    user = 0;
                }

                // quit game
                if (event.getSource() == quit) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "The scores will be stored in scores.txt");
                    System.exit(0);
                    pw.close();
                    round = 0;
                    cpuW = 0;
                    userW = 0;
                }

                // user's choices
                if (event.getSource() == rockB) {
                    user = 1;
                    userP.setIcon(rockI);
                }

                if (event.getSource() == paperB) {
                    user = 2;
                    userP.setIcon(paperI);
                }

                if (event.getSource() == scissorsB) {
                    user = 3;
                    userP.setIcon(scissorsI);
                }

                // cpu's choices
                if (cpu == 1) {
                    cpuP.setIcon(rockI);
                }

                if (cpu == 2) {
                    cpuP.setIcon(paperI);
                }

                if (cpu == 3) {
                    cpuP.setIcon(scissorsI);
                }

                // tie
                
                if(user == 0);{
	            	 
	             }
                
                if (cpu == user && user != 0) {
                    ties++;
                    round++;
                    lose = false;
                    win = false;
                    draw = true;
                    tied.setText("TIES: " + ties);
                    pw.write("Round " + round + ": ITS A TIE"
                        + "\nUser Score: " + userW
                        + "\nCPU Score: " + cpuW
                        + "\nTies: " + ties + "\n\n");
                    pw.close();
                }
                
                //win
                if (user == 1 && cpu == 2 || user == 2 && cpu == 3 || user == 3 && cpu == 1) {
                    cpuW++;
                    round++;
                    lose = true;
                    win = false;
                    draw = false;
                    cpuS.setText("CPU: " + cpuW);
                    pw.write("Round " + round + ": CPU WINS"
                                + "\nUser Score: " + userW
                                + "\nCPU Score: " + cpuW
                                + "\nTies: " + ties + "\n\n");
                    pw.close();
                } 
                
                if(cpu == 1 && user == 2 || cpu == 2 && user == 3 || cpu == 3 && user == 1) {
                    userW++;
                    round++;
                    win = true;
                    lose = false;
                    draw = false;
                    userS.setText("USER: " + userW);
                    pw.write("Round " + round + ": YOU WON!"
                        + "\nUser Score: " + userW
                        + "\nCPU Score: " + cpuW
                        + "\nTies: " + ties + "\n\n");
                    pw.close();
                }

                if (round > 0) {
                    result.setOpaque(true);
                }
                
                if (win == true) {
                    result.setText("YOU WON!");
                    result.setBackground(Color.yellow);     //change
                }

                if (lose == true) {
                    result.setText("YOU LOST!");
                    result.setBackground(Color.yellow);     // change
                }

                if (draw == true) {
                    result.setText("ITS A TIE!");
                    result.setBackground(Color.yellow);     //change
                }


            }
            
            catch(IOException ioe) {
                System.out.println("ERROR");    // change
                return;
            }

            catch (IndexOutOfBoundsException ie) {
                System.out.println("ERROR");    // change
                return;
            }

            catch (NullPointerException npe) {
                System.out.println("ERROR");
            }
        }
    }
}


