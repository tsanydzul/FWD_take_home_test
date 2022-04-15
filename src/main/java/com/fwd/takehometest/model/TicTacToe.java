package com.fwd.takehometest.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    boolean isPlayerOneTurn;
    int boardSize;
    String[][] boardMark;

    public TicTacToe(){
        this.isPlayerOneTurn = true;
    }

    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        isPlayerOneTurn = playerOneTurn;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void buildFresh() {
        this.boardMark = new String[this.boardSize][this.boardSize];
        for(int i=0;i<this.boardSize;i++){
            for (int j=0;j<this.boardSize;j++){
                this.boardMark[i][j] = Constant.BLANK;
            }
        }
    }

    public String[][] getBoardMark() {
        return boardMark;
    }

    public void setBoardMark(String[][] boardMark) {
        this.boardMark = boardMark;
    }

    public void assignMove(int row, int col, String player) {
        switch (player){
            case Constant.PLAYERONE:
                this.boardMark[row][col] = Constant.PLAYERONEMARK;
                break;
            case Constant.PLAYERTWO:
                this.boardMark[row][col] = Constant.PLAYERTWOMARK;
                break;
        }
    }
}
