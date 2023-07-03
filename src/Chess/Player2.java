/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

import javax.swing.ImageIcon;
import Pieces.*;
/**
 *
 * @author Abanoub
 */
public class Player2 
{       //get the pieces to player2
    private Piece king = new King(new ImageIcon(getClass().getResource("/Photoes/Player 2/King.png")),false,0,4) ;
    private Piece queen = new Queen(new ImageIcon(getClass().getResource("/Photoes/Player 2/Queen.png")),false,0,3);
    private Piece bishop1 = new Bishop(new ImageIcon(getClass().getResource("/Photoes/Player 2/Bishop.png")),false,0,2);
    private Piece bishop2 = new Bishop(new ImageIcon(getClass().getResource("/Photoes/Player 2/Bishop.png")),false,0,5);
    private Piece knight1 = new Knight(new ImageIcon(getClass().getResource("/Photoes/Player 2/Knight.png")),false,0,1);
    private Piece knight2 = new Knight(new ImageIcon(getClass().getResource("/Photoes/Player 2/Knight.png")),false,0,6);
    private Piece rook1 = new Rook(new ImageIcon(getClass().getResource("/Photoes/Player 2/Rook.png")),false,0,0);
    private Piece rook2 = new Rook(new ImageIcon(getClass().getResource("/Photoes/Player 2/Rook.png")),false,0,7);
    private Piece pawn1 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,0);
    private Piece pawn2 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,1);
    private Piece pawn3 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,2);
    private Piece pawn4 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,3);
    private Piece pawn5 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,4);
    private Piece pawn6 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,5);
    private Piece pawn7 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,6);
    private Piece pawn8 = new Pawn(new ImageIcon(getClass().getResource("/Photoes/Player 2/Pawn.png")),false,1,7);

    public King getKing() {return (King) king;}

    public Queen getQueen() {return (Queen) queen;}

    public Bishop getBishop1() {return (Bishop) bishop1;}

    public Bishop getBishop2() {return (Bishop) bishop2;}

    public Knight getKnight1() {return (Knight) knight1;}

    public Knight getKnight2() {return (Knight) knight2;}

    public Rook getRook1() {return (Rook) rook1;}

    public Rook getRook2() {return (Rook) rook2;}

    public Pawn getPawn1() {return (Pawn) pawn1;}

    public Pawn getPawn2() {return (Pawn) pawn2;}

    public Pawn getPawn3() {return (Pawn) pawn3;}

    public Pawn getPawn4() {return (Pawn) pawn4;}

    public Pawn getPawn5() {return (Pawn) pawn5;}

    public Pawn getPawn6() {return (Pawn) pawn6;}

    public Pawn getPawn7() {return (Pawn) pawn7;}

    public Pawn getPawn8() {return (Pawn) pawn8;}
    
}
