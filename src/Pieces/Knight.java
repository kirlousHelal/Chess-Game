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
public class Knight extends Piece
{
    public Knight(ImageIcon piece, boolean IsWhite , int Y , int X) 
    {
        super(piece, IsWhite , Y , X);
    }

    @Override
    public void canMove(Chess.Board board, int y, int x) 
    {
        if(y < 6 && x < 7&&(board.spot[y+2][x+1].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+2][x+1].getPiece().isIsWhite() ))
            board.tile[y+2][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y < 6 && x >= 1&&(board.spot[y+2][x-1].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+2][x-1].getPiece().isIsWhite() ))
            board.tile[y+2][x-1].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y >= 2 && x < 7&&(board.spot[y-2][x+1].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-2][x+1].getPiece().isIsWhite() ))
            board.tile[y-2][x+1].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y >= 2 && x >= 1&&(board.spot[y-2][x-1].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-2][x-1].getPiece().isIsWhite() ))
            board.tile[y-2][x-1].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y < 7 && x < 6&&(board.spot[y+1][x+2].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+1][x+2].getPiece().isIsWhite() ))
            board.tile[y+1][x+2].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y < 7 && x >= 2&&(board.spot[y+1][x-2].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y+1][x-2].getPiece().isIsWhite() ))
            board.tile[y+1][x-2].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y >= 1 && x < 6&&(board.spot[y-1][x+2].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-1][x+2].getPiece().isIsWhite() ))
            board.tile[y-1][x+2].setBorder(new LineBorder(Color.yellow, 5));
        
        if(y >= 1 && x >= 2&&(board.spot[y-1][x-2].getPiece()== null ||  board.spot[y][x].getPiece().isIsWhite()!=board.spot[y-1][x-2].getPiece().isIsWhite() ))
            board.tile[y-1][x-2].setBorder(new LineBorder(Color.yellow, 5));
        
    }
}
