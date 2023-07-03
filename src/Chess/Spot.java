/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;
import Pieces.Piece;
import java.awt.Color;
import javax.swing.JLabel;
/**
 *
 * @author Abanoub
 */
public class Spot extends JLabel
{
    private Piece piece ;
    public Spot(Piece piece)
    {
        this.piece = piece;
        setIcon(piece.getImage());
    }

    public Spot() 
    {
        this.setBounds(100, 100, 100, 100);
        this.setBackground(Color.yellow);
    }
    
    public Piece getPiece() { return piece; }

    public void setPiece(Piece piece)
    {
        this.piece = piece ;
        setIcon(piece.getImage());
    }
    public void destroyPiece()
    {
        piece = null ;
        setIcon(null);
    }
}
