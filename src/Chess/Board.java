/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Abanoub
 */
public class Board extends JFrame implements ActionListener
{
    public Spot[][] spot = new Spot[8][8];
    public JPanel[][] tile = new JPanel[8][8];
    
    public JPanel Game =new JPanel();//this panel what hold the game board and the pieces
    public JPanel About =new JPanel(); //this panel what hold image of the team 
   
    public JLabel menu =new JLabel();
    public JLabel aboutBackground =new JLabel();
    
    private JFrame menuFrame=new JFrame();
    private JButton newGame=new JButton("Play Game");
    private JButton aboutUs=new JButton("About Us");
    private JButton Exit=new JButton("Exit");
    private JButton Back=new JButton("Back To Menu");
    
    private JMenuBar menuBar=new JMenuBar();
    private JMenu file=new JMenu("File");
    private JMenu Help=new JMenu("Help");
    private JMenuItem mainMenu =new JMenuItem("The Main Menu");
    private JMenuItem Exit_m =new JMenuItem("Exit");
    private JMenuItem aboutUs_m =new JMenuItem("About Us");
    
    public Board()
    {
        this.setTitle("chess");
        this.setSize(835, 835);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,10);
        this.setResizable(false);
        Game.setLayout(new GridLayout(8,8));
        aboutBackground.setLayout(null); 
        
        //////////////Menu Frame/////////////
        menuFrame.setTitle("chess");
        menuFrame.setSize(600, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocation(400,100);
        menuFrame.setResizable(false);
     ////////////////////////////////////////////   
        aboutBackground.setIcon(new ImageIcon(getClass().getResource("/Photoes/aboutUs3.png")));
        menu.setIcon(new ImageIcon(getClass().getResource("/Photoes/menu.png")));
        
       file.add(mainMenu);
       file.add(Exit_m);
       Help.add(aboutUs_m);
        menuBar.add(file);
        menuBar.add(Help);
        this.setJMenuBar(menuBar);
        mainMenu.addActionListener(this);
        Exit_m.addActionListener(this);
        aboutUs_m.addActionListener(this);
     ////////////////////////////////////////////   
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.yellow);
        newGame.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        
        aboutUs.setBackground(Color.black);
        aboutUs.setForeground(Color.yellow);
        aboutUs.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        
        Exit.setBackground(Color.black);
        Exit.setForeground(Color.yellow);
        Exit.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        
        Back.setBackground(new Color(0,0,0,50));
        Back.setForeground(Color.blue);
        Back.setBorder(BorderFactory.createLineBorder(Color.blue,2));
     
        newGame.setBounds(230, 120, 120, 30);
        aboutUs.setBounds(230,190, 120, 30);
        Exit.setBounds(230,260, 120, 30);
        Back.setBounds(620,700, 140, 50);
        
        for(int i = 0 ; i<8 ; i++) //insert all tiles in board 
        {   
            for(int j = 0 ; j< 8 ; j++ )
            {
                spot[i][j] = new Spot() ;
                tile[i][j] = new JPanel();
                if((i+j)%2==0)
                {               
                tile[i][j].setBackground(Color.WHITE);
                }
                else
                tile[i][j].setBackground(Color.BLACK);
                Game.add(tile[i][j]);
                tile[i][j].add(spot[i][j]);
            }
        } 
       // aboutBackground.add(Back);
        About.add(aboutBackground);
        newGame.addActionListener(this); aboutUs.addActionListener(this);Exit.addActionListener(this);Back.addActionListener(this);
        menu.add(newGame);menu.add(Exit); menu.add(aboutUs);//menu.add(ChessText);
        menuFrame.add(menu);
        menuFrame.setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==Back ||e.getSource()==mainMenu)
        {
            this.remove(Game);
            this.remove(About);
            this.setVisible(false);    
             menuFrame.setVisible(true);
        }
        if(e.getSource()==newGame)
        {
            this.remove(About);
            this.add(Game);
            menuFrame.setVisible(false); 
            this.setVisible(true); 
        }
         if(e.getSource()==Exit || e.getSource()==Exit_m)
            System.exit(0);
        if(e.getSource()==aboutUs ||e.getSource()==aboutUs_m)
        {
            this.remove(Game);
            this.add(About);
             menuFrame.setVisible(false); 
            this.setVisible(true);    
        }
    }
}
