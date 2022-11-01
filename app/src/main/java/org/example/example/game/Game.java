package org.example.example.game;

import org.example.example.Validator.ManagerValidator;
import org.example.example.piece.Color;
import org.example.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean actualTurn;
    private GameStatus gameStatus;
    private List<History> history;
    ManagerValidator managerValidator;
    Piece pieceToPromote;

    public Game(Player player1, Player player2, Board board, WinCondition winCondition, Piece pieceToPromote) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.actualTurn = true;
        this.gameStatus = new GameStatus();
        this.history = new ArrayList<History>();
        this.managerValidator = new ManagerValidator(winCondition);
        this.pieceToPromote = pieceToPromote;

    }

    public void changeTurn() {
        actualTurn = !actualTurn;
    }

    public void makeAMove(int x1 , int y1 , int x2 , int y2){
        if (managerValidator.validMove(x1, y1, x2, y2, board, actualTurn ? player1.getColor() : player2.getColor())) {
            Cordinate cordinate1 = board.getCordinate(x1 , y1);
            Cordinate cordinate2 = board.getCordinate(x2 , y2);
            if (cordinate2.hasPiece()) cordinate2.getPiece().killPiece();
            history.add(new History(cordinate1 , cordinate2, actualTurn ? player1.getColor() : player2.getColor()));

            Piece piece= board.getCordinate(x1,y1).getPiece();
            board.getCordinate(x2, y2).pieceArrival(piece);
            board.getCordinate(x1, y1).pieceDeparture();
            if (piece.getCanPromote()){
                if(managerValidator.validPromotion(x1 , y1 , x2, y2, board, actualTurn ? player1.getColor() : player2.getColor())){
                    board.getCordinate(x2, y2).pieceArrival(new Piece(actualTurn? player1.getColor() : player2.getColor(), pieceToPromote));
                }
            }
            changeTurn();
        }
        if (managerValidator.isItCheckMate(board, actualTurn ? player1.getColor() : player2.getColor())) {
            gameStatus.setWinnner(actualTurn ? player2 : player1);
        }
    }

    public Board getBoard () {
        return board;
    }

    public Color getTurn() {
        return actualTurn ? player1.getColor() : player2.getColor();
    }





}
