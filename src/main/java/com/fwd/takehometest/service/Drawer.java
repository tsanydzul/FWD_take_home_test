package com.fwd.takehometest.service;

import com.fwd.takehometest.model.TicTacToe;

public interface Drawer {
    void drawBoard(TicTacToe ticTacToe);
    String getCoordinate(String playerTurn);
    String getBoardSize();
    void winner(String player);
    void allFilled();
}
