package com.fwd.takehometest.service;

import com.fwd.takehometest.model.TicTacToe;

public interface InputValidator {
    boolean isNumber(String input);
    boolean isCoordinateValid(String input, TicTacToe ticTacToe);
    boolean isCoordinateFree(String input, TicTacToe ticTacToe);
}
