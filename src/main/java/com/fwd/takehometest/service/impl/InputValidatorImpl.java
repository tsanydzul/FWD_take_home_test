package com.fwd.takehometest.service.impl;

import com.fwd.takehometest.model.Constant;
import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.InputValidator;

public class InputValidatorImpl implements InputValidator {

    public InputValidatorImpl() {
    }

    @Override
    public boolean isNumber(String input) {
        if (input == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(input);
        } catch (Exception ignore) {
            System.out.println(Constant.ERRORINPUT);
            return false;
        }
        return true;
    }

    @Override
    public boolean isCoordinateValid(String input, TicTacToe ticTacToe) {
        boolean validity = input.matches("\\d+,\\d+");
        if(validity){
            final String[] inputList = input.split(",");

            if(Integer.parseInt(inputList[0]) > ticTacToe.getBoardSize() || Integer.parseInt(inputList[1]) > ticTacToe.getBoardSize()){
                System.out.println();
                System.out.println(Constant.ERRORINPUTCOORDINATELARGER + " (" +ticTacToe.getBoardSize() + ")");
                System.out.println();
                validity = false;
            }
        }else {
            System.out.println();
            System.out.println(Constant.ERRORINPUTCOORDINATE);
            System.out.println();
        }
        return validity;
    }

    @Override
    public boolean isCoordinateFree(String coordinate, TicTacToe ticTacToe) {
        final String[] data = coordinate.split(",");
        boolean isFree = ticTacToe.getBoardMark()[Integer.parseInt(data[0])-1][Integer.parseInt(data[1])-1].equals(Constant.BLANK);
        if (!isFree) {
            System.out.println();
            System.out.println(Constant.ERRORCOORDINATETAKEN);
            System.out.println();
        }
        return isFree;
    }
}
