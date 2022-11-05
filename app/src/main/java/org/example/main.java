package org.example;

import org.example.game.board.Board;
import org.example.game.board.Cordinate;
import org.example.game.board.EmptyCordinate;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Cordinate> cordinateList = new ArrayList<>();
        for (int i = 1; i < 9 ; i++) {
            for (int j = 1; j < 9 ; j++) {
                cordinateList.add(new EmptyCordinate(i,j, null));
            }
        }
        Board board = new Board(cordinateList);
        List<Cordinate> cordinates = board.getCordinatesInBetween(board.getCordinate(1,1) , board.getCordinate(7,7));
        for (Cordinate cordinate : cordinates) {
            System.out.println(cordinate.getY());
            System.out.println(cordinate.getX());
        }
        System.out.println(33);
    }
}
