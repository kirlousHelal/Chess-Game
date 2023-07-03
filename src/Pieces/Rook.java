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
public class Rook extends Piece
{
    public Rook(ImageIcon piece, boolean IsWhite , int Y , int X) 
    {
        super(piece, IsWhite , Y , X);
    }

    @Override
    public void canMove(Chess.Board board, int y, int x) 
    {
        for(int i = y+1 ; i < 8 ; i++)
        {
            if(board.spot[i][x].getPiece()== null || (board.spot[i][x].getPiece()!= null&& board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite()))
            {
               board.tile[i][x].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][x].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        
        for(int i = y-1 ; i >= 0 ; i--)
        {
            if(board.spot[i][x].getPiece()== null ||(board.spot[i][x].getPiece()!= null&& board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite()))
            {
               board.tile[i][x].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][x].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][x].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        for(int i = x+1 ; i < 8 ; i++)
        {
            if(board.spot[y][i].getPiece()== null ||(board.spot[y][i].getPiece()!= null&& board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite()))
            {
               board.tile[y][i].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[y][i].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        for(int i = x-1 ; i >= 0 ; i--)
        {
            if(board.spot[y][i].getPiece()== null || (board.spot[y][i].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite()))
            {
               board.tile[y][i].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[y][i].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[y][i].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
    }
}
