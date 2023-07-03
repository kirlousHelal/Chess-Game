/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/**
 *
 * @author Abanoub
 */
public class King extends Piece
{
    public int Casting = 0 ;
    public King(ImageIcon piece, boolean IsWhite , int Y , int X) 
    {
        super(piece, IsWhite , X , Y);
    }

    @Override
    public void canMove(Chess.Board board, int y, int x) 
    {
        if(y<7&&(board.spot[y+1][x].getPiece()==null||(board.spot[y+1][x].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+1][x].getPiece().isIsWhite())))
            board.tile[y+1][x].setBorder(new LineBorder(Color.yellow, 5));
       
        if(y>0&&(board.spot[y-1][x].getPiece()==null||(board.spot[y-1][x].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-1][x].getPiece().isIsWhite())))
            board.tile[y-1][x].setBorder(new LineBorder(Color.yellow, 5));
        
        if(x<7&&(board.spot[y][x+1].getPiece()==null||(board.spot[y][x+1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][x+1].getPiece().isIsWhite())))
            board.tile[y][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
        if(x>0&&(board.spot[y][x-1].getPiece()==null||(board.spot[y][x-1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][x-1].getPiece().isIsWhite())))
            board.tile[y][x-1].setBorder(new LineBorder(Color.yellow, 5));
        
        if((y<7&&x<7)&&(board.spot[y+1][x+1].getPiece()==null||(board.spot[y+1][x+1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+1][x+1].getPiece().isIsWhite())))
            board.tile[y+1][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
        if((y>0&&x>0)&&(board.spot[y-1][x-1].getPiece()==null||(board.spot[y-1][x-1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-1][x-1].getPiece().isIsWhite())))
            board.tile[y-1][x-1].setBorder(new LineBorder(Color.yellow, 5));
        
        if((y>0&&x<7)&&(board.spot[y-1][x+1].getPiece()==null||(board.spot[y-1][x+1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-1][x+1].getPiece().isIsWhite())))
            board.tile[y-1][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
        if((y<7&&x>0)&&(board.spot[y+1][x-1].getPiece()==null||(board.spot[y+1][x-1].getPiece()!=null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+1][x-1].getPiece().isIsWhite())))
            board.tile[y+1][x-1].setBorder(new LineBorder(Color.yellow, 5));
        
       }
    
    public  void Casting1(Chess.Game game)   
    {
        if( // right castimg for white king
                 game.board.spot[7][4].getPiece() instanceof King &&  game.board.spot[7][7].getPiece() instanceof Rook
                && game.board.spot[7][4].getPiece().isIsWhite() &&  game.board.spot[7][7].getPiece().isIsWhite()
                && game.board.spot[7][4].getPiece().isFirstMove() &&  game.board.spot[7][7].getPiece().isFirstMove()
                && game.board.spot[7][6].getPiece() == null &&  game.board.spot[7][5].getPiece() == null
           )
        {
             Casting = 1;
             game.board.tile[7][6].setBorder(new LineBorder(Color.yellow,5));
        }
        if( // left casting for the white king
                 game.board.spot[7][4].getPiece() instanceof King &&  game.board.spot[7][0].getPiece() instanceof Rook
                && game.board.spot[7][4].getPiece().isIsWhite() &&  game.board.spot[7][0].getPiece().isIsWhite()
                && game.board.spot[7][4].getPiece().isFirstMove() &&  game.board.spot[7][0].getPiece().isFirstMove()
                && game.board.spot[7][1].getPiece() == null &&  game.board.spot[7][2].getPiece() == null &&  game.board.spot[7][3].getPiece() == null
           )
        {
            Casting = 2 ;
                game.board.tile[7][2].setBorder(new LineBorder(Color.yellow,5));
        }
    }
    
    public void Casting2(Chess.Board board)
    {
        if( // right casting for black king
                 board.spot[0][4].getPiece() instanceof King &&  board.spot[0][7].getPiece() instanceof Rook
                &&! board.spot[0][4].getPiece().isIsWhite() && !board.spot[0][7].getPiece().isIsWhite()
                && board.spot[0][4].getPiece().isFirstMove() &&  board.spot[0][7].getPiece().isFirstMove()
                && board.spot[0][6].getPiece() == null &&  board.spot[0][5].getPiece() == null
           )
        {
             Casting = 3 ;
             board.tile[0][6].setBorder(new LineBorder(Color.yellow,5));
        }
        if( // left casting for black king
                 board.spot[0][4].getPiece() instanceof King &&  board.spot[0][0].getPiece() instanceof Rook
                &&! board.spot[0][4].getPiece().isIsWhite() && !board.spot[0][0].getPiece().isIsWhite()
                && board.spot[0][4].getPiece(). isFirstMove() &&  board.spot[0][0].getPiece(). isFirstMove()
                && board.spot[0][1].getPiece() == null &&  board.spot[0][2].getPiece() == null &&  board.spot[0][3].getPiece() == null
           )
        {
             Casting = 4 ;
             board.tile[0][2].setBorder(new LineBorder(Color.yellow,5));
        }
    }
    
    public static boolean chekedKing(Chess.Board board,int y,int x,int K_y,int K_x,boolean cheked)
    {
        ////////////Queen && Bishop///////////////////////
        for (int i = y+1,j =x+1 ; i < 8&& j < 8; i++,j++) { if(board.spot[i][j].getPiece()!=null&&!(board.spot[i][j].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()&&(board.spot[i][j].getPiece() instanceof Bishop || board.spot[i][j].getPiece() instanceof Queen)) cheked=true;break;}}
        for (int i = y+1,j =x-1 ; i < 8&& j >=0; i++,j--) { if(board.spot[i][j].getPiece()!=null&&!(board.spot[i][j].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()&&(board.spot[i][j].getPiece() instanceof Bishop || board.spot[i][j].getPiece() instanceof Queen)) cheked=true;break;}}
        for (int i = y-1,j =x+1 ; i>=0&& j < 8; i--,j++) { if(board.spot[i][j].getPiece()!=null&&!(board.spot[i][j].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()&&(board.spot[i][j].getPiece() instanceof Bishop || board.spot[i][j].getPiece() instanceof Queen)) cheked=true;break;}}
        for (int i = y-1,j =x-1 ; i >=0&& j >=0; i--,j--) { if(board.spot[i][j].getPiece()!=null&&!(board.spot[i][j].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()&&(board.spot[i][j].getPiece() instanceof Bishop || board.spot[i][j].getPiece() instanceof Queen)) cheked=true;break;}}
       
        ////////////Queen && Rook///////////////////////
        for (int i = y+1; i < 8; i++) {if(board.spot[i][x].getPiece()!=null&&!(board.spot[i][x].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite()&&(board.spot[i][x].getPiece() instanceof Rook ||board.spot[i][x].getPiece()instanceof Queen))  cheked=true;break;}}
        for (int i = y-1; i >=0; i--) {if(board.spot[i][x].getPiece()!=null&&!(board.spot[i][x].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite()&&(board.spot[i][x].getPiece() instanceof Rook ||board.spot[i][x].getPiece()instanceof Queen))  cheked=true;break;}}
        for (int i = x+1; i < 8; i++) {if(board.spot[y][i].getPiece()!=null &&!(board.spot[y][i].getPiece() instanceof King)){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite()&&(board.spot[y][i].getPiece() instanceof Rook ||board.spot[y][i].getPiece()instanceof Queen))  cheked=true;break;}}
        for (int i = x-1; i >=0; i--) {if(board.spot[y][i].getPiece()!=null &&!(board.spot[y][i].getPiece() instanceof King) ){if(board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite()&&(board.spot[y][i].getPiece() instanceof Rook ||board.spot[y][i].getPiece()instanceof Queen))  cheked=true;break;}}
     
        //////////////Knight///////////////////////
        if(y+2<=7 && x+1<=7 &&board.spot[y+2][x+1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y+2][x+1].getPiece().isIsWhite()&&board.spot[y+2][x+1].getPiece() instanceof Knight )  cheked=true;     
        if(y+2<=7 && x-1>=0 &&board.spot[y+2][x-1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y+2][x-1].getPiece().isIsWhite()&&board.spot[y+2][x-1].getPiece() instanceof Knight )  cheked=true;     
        if(y-2>=0 && x+1<=7 &&board.spot[y-2][x+1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y-2][x+1].getPiece().isIsWhite()&&board.spot[y-2][x+1].getPiece() instanceof Knight )  cheked=true;     
        if(y-2>=0 && x-1>=0 &&board.spot[y-2][x-1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y-2][x-1].getPiece().isIsWhite()&&board.spot[y-2][x-1].getPiece() instanceof Knight )  cheked=true;     

        if(y+1<=7 && x+2<=7 &&board.spot[y+1][x+2].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y+1][x+2].getPiece().isIsWhite()&&board.spot[y+1][x+2].getPiece() instanceof Knight )  cheked=true;     
        if(y-1>=0 && x+2<=7 &&board.spot[y-1][x+2].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y-1][x+2].getPiece().isIsWhite()&&board.spot[y-1][x+2].getPiece() instanceof Knight )  cheked=true;     
        if(y+1<=7 && x-2>=0 &&board.spot[y+1][x-2].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y+1][x-2].getPiece().isIsWhite()&&board.spot[y+1][x-2].getPiece() instanceof Knight )  cheked=true;     
        if(y-1>=0 && x-2>=0 &&board.spot[y-1][x-2].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()!=board.spot[y-1][x-2].getPiece().isIsWhite()&&board.spot[y-1][x-2].getPiece() instanceof Knight )  cheked=true;     

           ////////////Pawn///////////////////////
        if(y+1<=7 && x+1<=7 &&board.spot[y+1][x+1].getPiece()!=null&&!board.spot[K_y][K_x].getPiece().isIsWhite()&&board.spot[y+1][x+1].getPiece().isIsWhite()&&board.spot[y+1][x+1].getPiece() instanceof Pawn )  cheked=true;     
        if(y-1>=0 && x-1>=0 &&board.spot[y-1][x-1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()&&!board.spot[y-1][x-1].getPiece().isIsWhite()&&board.spot[y-1][x-1].getPiece() instanceof Pawn )  cheked=true;     
        if(y+1<=7 && x-1>=0 &&board.spot[y+1][x-1].getPiece()!=null&&!board.spot[K_y][K_x].getPiece().isIsWhite()&&board.spot[y+1][x-1].getPiece().isIsWhite()&&board.spot[y+1][x-1].getPiece() instanceof Pawn )  cheked=true;     
        if(y-1>=0 && x+1<=7 &&board.spot[y-1][x+1].getPiece()!=null&&board.spot[K_y][K_x].getPiece().isIsWhite()&&!board.spot[y-1][x+1].getPiece().isIsWhite()&&board.spot[y-1][x+1].getPiece() instanceof Pawn )  cheked=true;
        
     return cheked;
    }
    public static void kingWillBeChceked(Chess.Board board,int y,int x,int K_y,int K_x)
    {
        if(y+1<=7&&chekedKing(board, y+1, x,K_y,K_x, false)) {board.tile[y+1][x].setBorder(null);}
        if(y-1>=0&&chekedKing(board, y-1, x,K_y,K_x, false)) {board.tile[y-1][x].setBorder(null);}
        if(x+1<=7&&chekedKing(board, y, x+1,K_y,K_x, false)) {board.tile[y][x+1].setBorder(null);}
        if(x-1>=0&&chekedKing(board, y, x-1,K_y,K_x, false)) {board.tile[y][x-1].setBorder(null);}
        
        if(y+1<=7&&x+1<=7&&chekedKing(board, y+1, x+1,K_y,K_x, false)) {board.tile[y+1][x+1].setBorder(null);}
        if(y-1>=0&&x-1>=0&&chekedKing(board, y-1, x-1,K_y,K_x, false)) {board.tile[y-1][x-1].setBorder(null);}
        if(y+1<=7&&x-1>=0&&chekedKing(board, y+1, x-1,K_y,K_x, false)) {board.tile[y+1][x-1].setBorder(null);}
        if(y-1>=0&&x+1<=7&&chekedKing(board, y-1, x+1,K_y,K_x, false)) {board.tile[y-1][x+1].setBorder(null);}
    } 
}
