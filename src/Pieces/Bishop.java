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
public class Bishop extends Piece
{
    public Bishop(ImageIcon piece, boolean IsWhite , int Y , int X) 
    {
        super(piece, IsWhite , Y , X);
    }

    @Override
    public void canMove(Chess.Board board, int y, int x) 
    {
        for(int i = y+1 , j = x+1 ; i < 8 && j < 8 ; i++ , j++)
        {
            if(board.spot[i][j].getPiece()== null || (board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()))
            {
               board.tile[i][j].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        for(int i = y+1 , j = x-1 ; i < 8&& j >= 0 ; i++ , j--)
        {
            if(board.spot[i][j].getPiece()== null ||(board.spot[i][j].getPiece()!= null&& board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()))
            {
               board.tile[i][j].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite())
                   break;
            }  
            else
                break;
        }
        for(int i = y-1 , j = x-1 ; i >=0&& j>=0 ; i-- , j--)
        {
            if(board.spot[i][j].getPiece()== null || (board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()))
            {
               board.tile[i][j].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        for(int i = y-1 , j = x+1 ; i>=0 && j<8 ; i-- , j++)
        {
            if(board.spot[i][j].getPiece()== null || (board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite()))
            {
               board.tile[i][j].setBorder(new LineBorder(Color.yellow, 5));
               if(board.spot[i][j].getPiece()!= null&&board.spot[y][x].getPiece().isIsWhite()!=board.spot[i][j].getPiece().isIsWhite())
                   break;
            }
            else
                break;
        }
        
    }
}
