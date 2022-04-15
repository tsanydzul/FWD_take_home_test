package com.fwd.takehometest.service;

import com.fwd.takehometest.model.TicTacToe;

import java.util.Map;

public interface InputValidator {
    boolean isNumber(String input, Map<String, Object> model);
    boolean isCoordinateValid(String input, TicTacToe ticTacToe, Map<String, Object> model);
    boolean isCoordinateFree(String input, TicTacToe ticTacToe, Map<String, Object> model);
}
