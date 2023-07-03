/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Chess.Board;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


/**
 *
 * @author Abanoub
 */
public class Pawn extends Piece
{
    public Pawn(ImageIcon piece, boolean IsWhite , int Y , int X) 
    {
        super(piece, IsWhite , Y , X);
    }

    @Override
    public void canMove(Chess.Board board, int y, int x) 
    {
        if(!board.spot[y][x].getPiece().isIsWhite())
        { // movement for black pawn
            if(board.spot[y+1][x].getPiece()== null)
               board.tile[y+1][x].setBorder(new LineBorder(Color.yellow, 5));
        
            if (this.isFirstMove() && board.spot[y+2][x].getPiece()== null&&board.spot[y+1][x].getPiece()== null)
                board.tile[y+2][x].setBorder(new LineBorder(Color.yellow, 5));
        
            if (x != 7 && board.spot[y+1][x+1].getPiece()!= null&&board.spot[y+1][x+1].getPiece().isIsWhite() )
                board.tile[y+1][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
            if (x != 0 && board.spot[y+1][x-1].getPiece()!= null&&board.spot[y+1][x-1].getPiece().isIsWhite())
                board.tile[y+1][x-1].setBorder(new LineBorder(Color.yellow, 5));
        }
        
        else if(board.spot[y][x].getPiece().isIsWhite())
        { // movement for white pawn
            if(board.spot[y-1][x].getPiece()== null)
               board.tile[y-1][x].setBorder(new LineBorder(Color.yellow, 5));
        
            if (this.isFirstMove() && board.spot[y-2][x].getPiece()== null&&board.spot[y-1][x].getPiece()== null)
                board.tile[y-2][x].setBorder(new LineBorder(Color.yellow, 5));
        
            if (x != 7 && board.spot[y-1][x+1].getPiece()!= null&&!board.spot[y-1][x+1].getPiece().isIsWhite())
                board.tile[y-1][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
            if (x != 0 && board.spot[y-1][x-1].getPiece()!= null&&!board.spot[y-1][x-1].getPiece().isIsWhite())
                board.tile[y-1][x-1].setBorder(new LineBorder(Color.yellow, 5));
        }
    }
    public static class Promotion extends JDialog implements MouseListener
{
    JLabel spot[] ;
    Board board ;
    int x , y ;
    public Promotion(int y , int x , Chess.Board board)
    {
        this.board = board ;
        this.x=x;
        this.y=y;
        setTitle("Pawn Promotion");
        setSize(315, 100);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLocation(700,450);
        setResizable(false);
        setLayout(new GridLayout(1, 4));
        spot = new JLabel[4];
        setModal(true); //////////////////// 
        for(int i = 0 ; i < 4 ; i ++)
        {
            spot[i] = new JLabel();
            add(spot[i]);
            spot[i].setBorder(new LineBorder(new Color(210,105,30) , 5));
            spot[i].addMouseListener(this);
        }
        if(board.spot[y][x].getPiece().isIsWhite())
        {
          spot[0].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 1/Queen.png")));
          spot[1].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 1/Rook.png")));
          spot[2].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 1/Bishop.png")));
          spot[3].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 1/Knight.png")));
        }
        else
        {
          spot[0].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 2/Queen.png")));
          spot[1].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 2/Rook.png")));
          spot[2].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 2/Bishop.png")));
          spot[3].setIcon(new ImageIcon(getClass().getResource("/Photoes/Player 2/Knight.png")));
        }
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        JLabel spot = (JLabel) me.getSource();
      if(board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==0)
      {
          Piece queen = new Queen(new ImageIcon(getClass().getResource("/Photoes/Player 1/Queen.png")),true,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(queen);
      }
      
      if(board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==1)
      {
          Piece rook = new Rook(new ImageIcon(getClass().getResource("/Photoes/Player 1/Rook.png")),true,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(rook);
      }
      
      if(board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==2)
      {
          Piece bishop = new Bishop(new ImageIcon(getClass().getResource("/Photoes/Player 1/Bishop.png")),true,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(bishop);
      }
      
      if(board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==3)
      {
          Piece knight = new Knight(new ImageIcon(getClass().getResource("/Photoes/Player 1/Knight.png")),true,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(knight);
      }
      
      if(!board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==0)
          
      {
          Piece queen = new Queen(new ImageIcon(getClass().getResource("/Photoes/Player 2/Queen.png")),false,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(queen);
      }
      
      if(!board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==1)
      {
          Piece rook = new Rook(new ImageIcon(getClass().getResource("/Photoes/Player 2/Rook.png")),false,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(rook);
      }
      
      if(!board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==2)
      {
          Piece bishop = new Bishop(new ImageIcon(getClass().getResource("/Photoes/Player 2/Bishop.png")),false,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(bishop);
      }
      
      if(!board.spot[y][x].getPiece().isIsWhite()&&spot.getX()/75==3)
      {
          Piece knight = new Knight(new ImageIcon(getClass().getResource("/Photoes/Player 2/Knight.png")),false,y,x);
          board.spot[y][x].destroyPiece();
          board.spot[y][x].setPiece(knight);
      }
      dispose();  
    }

    @Override
    public void mousePressed(MouseEvent me) {    }

    @Override
    public void mouseReleased(MouseEvent me) {    }

    @Override
    public void mouseEntered(MouseEvent me) {    }

    @Override
    public void mouseExited(MouseEvent me) {    }
}
}
