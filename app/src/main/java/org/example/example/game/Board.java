package org.example.example.game;


import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cordinate> cordinates;

    public Board(List<Cordinate> cordinates) {
        this.cordinates = cordinates;
    }

    public List<Cordinate> getCordinates() {
        return cordinates;
    }

    public Cordinate getCordinate(int x, int y) {
        for (Cordinate cordinate : cordinates) {
            if (cordinate.getX() == x && cordinate.getY() == y) {
                return cordinate;
            }
        }
        return null;
    }

    public Cordinate getPieceCordinate(Piece piece) {
        for (Cordinate cordinate : cordinates) {
            if (cordinate.getPiece().equals(piece)) {
                return cordinate;
            }
        }
        return null;
    }

    public Cordinate getPieceCordinate(Piece piece, Color color) {
        for (Cordinate cordinate : cordinates) {
            if (cordinate.getPiece().equals(piece) && cordinate.getPiece().getColor().equals(color)) {
                return cordinate;
            }
        }
        return null;
    }

    public List<Cordinate> getAllCordinatesWithPieces() {
        List<Cordinate> cordinates = new ArrayList<>();
        for (Cordinate cordinate : this.cordinates) {
            if (cordinate.hasPiece()) {
                cordinates.add(cordinate);
            }
        }
        return cordinates;
    }

    public List<Cordinate> getEnemyPiecesCordinates(Color color) {
        List<Cordinate> cordinates = new ArrayList<>();
        for (Cordinate cordinate : this.cordinates) {
            if (cordinate.hasPiece() && cordinate.getPiece().getColor() != color) {
                cordinates.add(cordinate);
            }
        }
        return cordinates;
    }

    public List<Cordinate> getFriendlyPiecesCordinates(Color color) {
        List<Cordinate> cordinates = new ArrayList<>();
        for (Cordinate cordinate : this.cordinates) {
            if (cordinate.hasPiece() && cordinate.getPiece().getColor() == color) {
                cordinates.add(cordinate);
            }
        }
        return cordinates;
    }

    public List<Cordinate> getCordinatesBetween(int x1, int y1, int x2, int y2) {
        List<Cordinate> cordinates = new ArrayList<>();
        if (x1 == x2) {
            for (int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++) {
                cordinates.add(getCordinate(x1, i));
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); i++) {
                cordinates.add(getCordinate(i, y1));
            }
        } else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            int x = Math.min(x1, x2) + 1;
            int y = Math.min(y1, y2) + 1;
            while (x < Math.max(x1, x2)) {
                cordinates.add(getCordinate(x, y));
                x++;
                y++;
            }
        }
        return cordinates;
    }

    public int getXLength() {
        int x = 0;
        for (Cordinate cordinate : cordinates) {
            if (cordinate.getX() > x) {
                x = cordinate.getX();
            }
        }
        return x;
    }

    public int getYLength() {
        int y = 0;
        for (Cordinate cordinate : cordinates) {
            if (cordinate.getY() > y) {
                y = cordinate.getY();
            }
        }
        return y;
    }
}
