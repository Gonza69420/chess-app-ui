package org.example.example.fabric;

import org.example.example.game.Board;
import org.example.example.game.Cordinate;
import org.example.example.piece.Color;

import java.util.ArrayList;
import java.util.List;

public class BoardFabricator {

    public static Board createNormalBoard(){
        List<Cordinate> cordinates = new ArrayList<>();
        for (int i = 1; i <9 ; i++) {
            for (int j = 1; j <9 ; j++) {
                cordinates.add(new Cordinate(i,j));
            }
        }
        Cordinate[] kingConditionWhite = new Cordinate[5];
        kingConditionWhite[0] = cordinates.get(1);
        kingConditionWhite[1] = cordinates.get(2);
        kingConditionWhite[2] = cordinates.get(3);
        kingConditionWhite[3] = cordinates.get(5);
        kingConditionWhite[4] = cordinates.get(6);
        cordinates.get(4).pieceArrival(PieceFabricator.createKing(Color.WHITE, kingConditionWhite));
        Cordinate[] kingConditionBlack = new Cordinate[5];
        kingConditionBlack[0] = cordinates.get(57);
        kingConditionBlack[1] = cordinates.get(58);
        kingConditionBlack[2] = cordinates.get(59);
        kingConditionBlack[3] = cordinates.get(61);
        kingConditionBlack[4] = cordinates.get(62);
        cordinates.get(60).pieceArrival(PieceFabricator.createKing(Color.BLACK, kingConditionBlack));

        cordinates.get(0).pieceArrival(PieceFabricator.createRook(Color.WHITE));
        cordinates.get(1).pieceArrival(PieceFabricator.createKnight(Color.WHITE));
        cordinates.get(2).pieceArrival(PieceFabricator.createBishop(Color.WHITE));
        cordinates.get(3).pieceArrival(PieceFabricator.createQueen(Color.WHITE));
        cordinates.get(5).pieceArrival(PieceFabricator.createBishop(Color.WHITE));
        cordinates.get(6).pieceArrival(PieceFabricator.createKnight(Color.WHITE));
        cordinates.get(7).pieceArrival(PieceFabricator.createRook(Color.WHITE));
        for (int i = 8; i <16 ; i++) {
            cordinates.get(i).pieceArrival(PieceFabricator.createPawn(Color.WHITE, new Cordinate[]{cordinates.get(i-8), cordinates.get(i)}));
        }
        for (int i = 48; i <56 ; i++) {
            cordinates.get(i).pieceArrival(PieceFabricator.createPawn(Color.BLACK, new Cordinate[]{cordinates.get(i+8), cordinates.get(i)}));
        }
        cordinates.get(56).pieceArrival(PieceFabricator.createRook(Color.BLACK));
        cordinates.get(57).pieceArrival(PieceFabricator.createKnight(Color.BLACK));
        cordinates.get(58).pieceArrival(PieceFabricator.createBishop(Color.BLACK));
        cordinates.get(59).pieceArrival(PieceFabricator.createQueen(Color.BLACK));
        cordinates.get(61).pieceArrival(PieceFabricator.createBishop(Color.BLACK));
        cordinates.get(62).pieceArrival(PieceFabricator.createKnight(Color.BLACK));
        cordinates.get(63).pieceArrival(PieceFabricator.createRook(Color.BLACK));

        return new Board(cordinates);
    }
}
