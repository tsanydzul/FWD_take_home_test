package com.fwd.takehometest.service.impl;

import com.fwd.takehometest.model.Constant;
import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.InputValidator;

import java.util.Map;

public class InputValidatorImpl implements InputValidator {

    public InputValidatorImpl() {
    }

    @Override
    public boolean isNumber(String input, Map<String, Object> model) {
        if (input == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(input);
            if(d < 3){
                model.put("error", Constant.TOOSMALL);
            }else{
                model.put("error", null);
            }
        } catch (Exception ignore) {
            model.put("error", Constant.ERRORINPUT);
            System.out.println(Constant.ERRORINPUT);
            return false;
        }
        return true;
    }

    @Override
    public boolean isCoordinateValid(String input, TicTacToe ticTacToe, Map<String, Object> model) {
        boolean validity = input.matches("\\d+,\\d+");
        if(validity){
            final String[] inputList = input.split(",");

            if(Integer.parseInt(inputList[0]) > ticTacToe.getBoardSize() || Integer.parseInt(inputList[1]) > ticTacToe.getBoardSize()){
                System.out.println();
                System.out.println(Constant.ERRORINPUTCOORDINATELARGER + " (" +ticTacToe.getBoardSize() + ")");
                System.out.println();
                model.put("error", Constant.ERRORINPUTCOORDINATELARGER + " (" +ticTacToe.getBoardSize() + ")");
                validity = false;
            }
        }else {
            System.out.println();
            System.out.println(Constant.ERRORINPUTCOORDINATE);
            System.out.println();
            model.put("error", Constant.ERRORINPUTCOORDINATE);
        }
        return validity;
    }

    @Override
    public boolean isCoordinateFree(String coordinate, TicTacToe ticTacToe, Map<String, Object> model) {
        final String[] data = coordinate.split(",");
        boolean isFree = ticTacToe.getBoardMark()[Integer.parseInt(data[0])-1][Integer.parseInt(data[1])-1].equals(Constant.BLANK);
        if (!isFree) {
            System.out.println();
            System.out.println(Constant.ERRORCOORDINATETAKEN);
            System.out.println();

            model.put("error", Constant.ERRORCOORDINATETAKEN);
        }
        return isFree;
    }
}
