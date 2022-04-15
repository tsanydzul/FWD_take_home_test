package com.fwd.takehometest.service.impl;

import com.fwd.takehometest.model.Constant;
import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.Drawer;

import java.io.InputStream;
import java.util.Scanner;

import static java.util.Collections.nCopies;

public class DrawerImpl implements Drawer {

    private final Scanner scanner;

    public DrawerImpl(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public void drawBoard(TicTacToe ticTacToe) {
        final int boundaries = ticTacToe.getBoardSize() * 2 + 1;
        final String horizontalLine = String.join(" ", nCopies(boundaries, "--"));

        ticTacToe.setBoardEachRow(new String[boundaries]);

        System.out.println(horizontalLine);
        ticTacToe.setBoardEachRowIndex(horizontalLine,0);
        int rowToFill = 1;
        for (int row = 0; row < ticTacToe.getBoardSize(); row++) {
            StringBuilder boardRow = new StringBuilder();
            boardRow.append("| ");
            System.out.print("| ");
            for (int col = 0; col < ticTacToe.getBoardSize(); col++) {
                System.out.print(ticTacToe.getBoardMark()[row][col]);
                System.out.print(" | ");

                boardRow.append(ticTacToe.getBoardMark()[row][col]).append(" | "); ;
            }
            ticTacToe.setBoardEachRowIndex(new String(boardRow),rowToFill);
            rowToFill++;

            System.out.println();
            System.out.println(horizontalLine);
            System.out.println();

            ticTacToe.setBoardEachRowIndex(horizontalLine,rowToFill);
            rowToFill++;
        }
    }

    @Override
    public String getCoordinate(String playerTurn) {
        System.out.print(Constant.INPUTCOORDINATE + "for Player " + playerTurn + " : ");
        return scanner.next();
    }

    @Override
    public String getBoardSize() {
        System.out.print(Constant.INPUTBOARD);
        return scanner.next();
    }

    @Override
    public void winner(String player) {
        System.out.print("Player " + player +Constant.WINNER);
    }

    @Override
    public void allFilled() {
        System.out.println(Constant.ALLFILLED);
    }
}
