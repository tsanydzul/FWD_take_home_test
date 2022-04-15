package com.fwd.takehometest;

import com.fwd.takehometest.model.Constant;
import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.Drawer;
import com.fwd.takehometest.service.InputValidator;

import java.util.Map;

public class Play {
    private final Drawer drawer;
    private final InputValidator inputValidator;
    TicTacToe ticTacToe;
    String player;

    public Play(Drawer drawer, InputValidator inputValidator, TicTacToe ticTacToe) {
        this.drawer = drawer;
        this.inputValidator = inputValidator;
        this.ticTacToe = ticTacToe;
    }

    public void initiate(String boardSize, Map<String, Object> model) {
        if(inputValidator.isNumber(boardSize, model)){
            ticTacToe.setBoardSize(Integer.parseInt(boardSize));
            ticTacToe.buildFresh();
            drawer.drawBoard(ticTacToe);
            model.put("board", ticTacToe.getBoardEachRow());
        }
        model.put("player", ticTacToe.isPlayerOneTurn());
    }

    public void start(String coordinate, Map<String, Object> model){
        playerTurn(coordinate, model);
        isGameOver();
    }

    void assignMove(String coordinate, String player){
        final String[] posDimensions = coordinate.split(",");
        final int x = Integer.parseInt(posDimensions[0]) - 1;
        final int y = Integer.parseInt(posDimensions[1]) - 1;

        ticTacToe.assignMove(x, y, player);
    }

    void playerTurn(String coordinate, Map<String, Object> model){
        if(ticTacToe.isPlayerOneTurn()){
            player = Constant.PLAYERONE;
        }else{
            player = Constant.PLAYERTWO;
        }
        if(inputValidator.isCoordinateValid(coordinate, ticTacToe, model) && inputValidator.isCoordinateFree(coordinate,ticTacToe, model)) {
            assignMove(coordinate, player);
            drawer.drawBoard(ticTacToe);
            ticTacToe.setPlayerOneTurn(!ticTacToe.isPlayerOneTurn());
        }
        model.put("board", ticTacToe.getBoardEachRow());
        model.put("player", ticTacToe.isPlayerOneTurn());
    }

    void isGameOver(){
        String[][] board = ticTacToe.getBoardMark();

        boolean isAllFilled = true;

        boolean isRowWin = false;
        boolean isColWin = false;

        boolean isCrossTopWin = true;
        boolean isCrossBotWin = true;
        String crossMarkTop = board[0][0];
        String crossMarkBot = board[0][ticTacToe.getBoardSize()-1];

        for (int i=0;i<ticTacToe.getBoardSize();i++){
            String currentRowMark = board[i][0];
            String currentColMark = board[0][i];
            isRowWin = true;
            isColWin = true;
            for (int j=0;j<ticTacToe.getBoardSize();j++) {
                String normalMark = board[i][j];
                String colMark = board[j][i];

                if(normalMark.equals(Constant.BLANK)){
                    isAllFilled =false;
                }

                isRowWin = !normalMark.equals(Constant.BLANK) && normalMark.equals(currentRowMark) && isRowWin;
                isColWin = !colMark.equals(Constant.BLANK) && colMark.equals(currentColMark) && isColWin;

                if (j==i && isCrossTopWin){
                    isCrossTopWin = !normalMark.equals(Constant.BLANK) && normalMark.equals(crossMarkTop);
                } else if(j+i == ticTacToe.getBoardSize()-1 && isCrossBotWin){
                    isCrossBotWin = !normalMark.equals(Constant.BLANK) && normalMark.equals(crossMarkBot);
                }
            }
            if(isRowWin || isColWin){
                break;
            }
        }
        if(isRowWin || isColWin || isCrossTopWin || isCrossBotWin){
            drawer.winner(player);
        }else if(isAllFilled){
            drawer.allFilled();
        }
    }
}
