/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Pieces.*;
import Pieces.Pawn.Promotion;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 *
 * @author Abanoub
 */
public class Game implements MouseListener
{
    public Board board = new Board();
    public Player1 player1 = new Player1();
    public Player2 player2 = new Player2();
    private int counter = 0 , y , x ;
    public boolean selected ;
    private Pawn.Promotion promotion ;

    private boolean checkedKing1=false;
    private boolean checkedKing2=false;
    
    private int K1_x=this.player1.getKing().getX(),K1_y=this.player1.getKing().getY();
    private int K2_x=this.player2.getKing().getX(),K2_y=this.player2.getKing().getY();
    
    public void Pawn_promotion(int y , int x, Board board)
    {
        promotion = new Promotion(y,x,board);
        promotion.setVisible(true);
    }
    
    public void Casting(Board board )
    {
        if(player1.getKing().Casting == 1 && board.spot[7][6].getPiece()instanceof King&&board.spot[7][7].getPiece() instanceof Rook&&player1.getRook2().isFirstMove())
           {
               board.spot[7][5].setPiece(board.spot[7][7].getPiece());
               board.spot[7][7].destroyPiece();
           }
           if(player1.getKing().Casting == 2 &&  this.board.spot[7][2].getPiece()==player1.getKing()&& board.spot[7][0].getPiece()==player1.getRook1()&&player1.getRook1().isFirstMove())
           {
                board.spot[7][3].setPiece( board.spot[7][0].getPiece());
                board.spot[7][0].destroyPiece();
           }
           if(player2.getKing().Casting == 3 &&  board.spot[0][6].getPiece()==player2.getKing()&& board.spot[0][7].getPiece()==player2.getRook2()&&player2.getRook2().isFirstMove())
           {
                board.spot[0][5].setPiece( board.spot[0][7].getPiece());
                board.spot[0][7].destroyPiece();
           }
           if(player2.getKing().Casting == 4 &&  board.spot[0][2].getPiece()==player2.getKing()&& board.spot[0][0].getPiece()==player2.getRook1()&&player2.getRook1().isFirstMove())
           {
                board.spot[0][3].setPiece( board.spot[0][0].getPiece());
                board.spot[0][0].destroyPiece();
           }
    }
    public Game()
    {
        //insert all pieces to player 1
        board.spot[7][0].setPiece(player1.getRook1());board.spot[7][1].setPiece(player1.getKnight1());board.spot[7][2].setPiece(player1.getBishop1());board.spot[7][3].setPiece(player1.getQueen());
        board.spot[7][4].setPiece(player1.getKing());board.spot[7][5].setPiece(player1.getBishop2());board.spot[7][6].setPiece(player1.getKnight2());board.spot[7][7].setPiece(player1.getRook2());
        board.spot[6][0].setPiece(player1.getPawn1());board.spot[6][1].setPiece(player1.getPawn2());board.spot[6][2].setPiece(player1.getPawn3());board.spot[6][3].setPiece(player1.getPawn4());
        board.spot[6][4].setPiece(player1.getPawn5());board.spot[6][5].setPiece(player1.getPawn6());board.spot[6][6].setPiece(player1.getPawn7());board.spot[6][7].setPiece(player1.getPawn7());
        //insert all pieces to player 2
        board.spot[0][0].setPiece(player2.getRook1());board.spot[0][1].setPiece(player2.getKnight1());board.spot[0][2].setPiece(player2.getBishop1());board.spot[0][3].setPiece(player2.getQueen());
        board.spot[0][4].setPiece(player2.getKing());board.spot[0][5].setPiece(player2.getBishop2());board.spot[0][6].setPiece(player2.getKnight2());board.spot[0][7].setPiece(player2.getRook2());
        board.spot[1][0].setPiece(player2.getPawn1());board.spot[1][1].setPiece(player2.getPawn2());board.spot[1][2].setPiece(player2.getPawn3());board.spot[1][3].setPiece(player2.getPawn4());
        board.spot[1][4].setPiece(player2.getPawn5());board.spot[1][5].setPiece(player2.getPawn6());board.spot[1][6].setPiece(player2.getPawn7());board.spot[1][7].setPiece(player2.getPawn7());
        
        for(int i = 0 ; i < 8 ; i ++ ) for(int j = 0 ; j < 8 ; j ++ )  board.tile[i][j].addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        JPanel tile2 = (JPanel)me.getSource();
        for (int h = 0; h < 8; h++) {
            for (int l = 0; l < 8; l++) {
                 if(me.getSource() == board.tile[h][l])
                {  
                     if(board.spot[h][l].getPiece() != null && counter % 2 ==0 && board.spot[h][l].getPiece().isIsWhite() )
                      {
                       for(int i = 0 ; i<8 ; i++)     for(int o = 0 ; o< 8 ; o++ )  board.tile[i][o].setBorder(null);
                       y = h;
                       x = l;
                       tile2.setBorder(new LineBorder(new Color(210,105,30) , 5));
                       board.spot[h][l].getPiece().canMove(board, y, x);
                        if(board.spot[h][l].getPiece() instanceof King)
                        {
                        player1.getKing().Casting1(this);
                        King.kingWillBeChceked(board, K1_x, K1_y,K1_x,K1_y);
                        }
                       // the function to move
                       selected = true ;
                      }
                      // the first click to move abother player
                      else if(board.spot[h][l].getPiece() != null && counter % 2 !=0 && !board.spot[h][l].getPiece().isIsWhite() )
                      {
                        for(int i = 0 ; i<8 ; i++)     for(int o = 0 ; o< 8 ; o++ )       board.tile[i][o].setBorder(null);
                        y = h;
                        x = l;
                        tile2.setBorder(new LineBorder(new Color(210,105,30) , 5));
                        // the function to move
                        board.spot[h][l].getPiece().canMove(board, y, x);
                       if(board.spot[h][l].getPiece() instanceof King)
                       {
                       player2.getKing().Casting2(board);
                       King.kingWillBeChceked(board, K2_x, K2_y,K2_x,K2_y);
                       }
                        selected = true;
                      }
                      // the second click to move for both players
                      else if(selected &&tile2.getBorder() != null)
                      {
                         board.spot[y][x].getPiece().setFirstMove(false);
                         board.spot[h][l].setPiece(board.spot[y][x].getPiece());
                         board.spot[y][x].destroyPiece();
                         board.spot[h][l].getPiece().setX(h);
                         board.spot[h][l].getPiece().setY(l);
                         selected = false;
                         Casting(board);
                         player1.getKing().Casting = 0 ;
                         player2.getKing().Casting = 0 ;
                         if(board.spot[h][l].getPiece() instanceof Pieces.Pawn&&(h==7||h==0)) Pawn_promotion(h,l,board);
                         ///////////////////////////
                         if(board.spot[h][l].getPiece() instanceof King&&board.spot[h][l].getPiece().isIsWhite())  {K1_x=h;K1_y=l;}
                        else if(board.spot[h][l].getPiece() instanceof King&&!board.spot[h][l].getPiece().isIsWhite())  {K2_x=h;K2_y=l;}
                         //////////////////////////////
                         if(checkedKing1 || checkedKing2)
                        for(int i = 0 ; i<8 ; i++)   for(int o = 0 ; o< 8 ; o++ ) 
                            if(board.tile[i][o].getBackground()==Color.red)
                            {
                                if(i+1<8 && o+1<8 )board.tile[i][o].setBackground(board.tile[i+1][o+1].getBackground());
                                else if(i-1>=0 && o-1>=0 )board.tile[i][o].setBackground(board.tile[i-1][o-1].getBackground());
                            }
                        //////////////////////////////////////////////////////
                         checkedKing1=King.chekedKing(board,K1_x,K1_y,K1_x,K1_y,false);
                         if(checkedKing1)
                           board.tile[this.player1.getKing().getX()][this.player1.getKing().getY()].setBackground(Color.red);
                         
                         checkedKing2=King.chekedKing(board,K2_x,K2_y,K2_x,K2_y,false);
                         if(checkedKing2)
                           board.tile[this.player2.getKing().getX()][this.player2.getKing().getY()].setBackground(Color.red);
                         
                         counter ++;
                        for(int i = 0 ; i<8 ; i++)   for(int o = 0 ; o< 8 ; o++ )       board.tile[i][o].setBorder(null);
                }   
            }
        }
    }
    }
    @Override
    public void mouseReleased(MouseEvent me) {    }

    @Override
    public void mouseEntered(MouseEvent me) {    }

    @Override
    public void mouseExited(MouseEvent me) {    }
}
