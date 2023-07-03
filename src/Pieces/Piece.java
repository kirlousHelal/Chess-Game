/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import javax.swing.ImageIcon;
import Chess.Board;

/**
 *
 * @author Abanoub
 */
public abstract class Piece 
{
    private  int X , Y ;
    private  ImageIcon image = null ;
    private final boolean IsWhite ;
    private boolean FirstMove = true ;

    public void setFirstMove(boolean FirstMove) { this.FirstMove = FirstMove; }

    public boolean isFirstMove() {return FirstMove;}
    
    public abstract void canMove(Board board , int y , int x );
    
    public boolean isIsWhite() { return IsWhite; }

    public ImageIcon getImage() {  return image;  }

    public void setImage(ImageIcon image) {this.image = image; }

    public void setX(int X) { this.X = X;  }

    public void setY(int Y) { this.Y = Y;  }

    public  int getX() {  return X;  }

    public  int getY() {  return Y;  }

    public Piece(ImageIcon image, boolean IsWhite , int Y , int X )
    {
        this.image = image;
        this.IsWhite = IsWhite;
        this.Y = Y;
        this.X = X;
    }
}
