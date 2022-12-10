package com.creditsuisse.codechallenge.canvas;

import com.creditsuisse.codechallenge.view.View;

public class Line extends Shape {

    private char[][] canvasBuilt;

    public Line(int startX, int startY, int endX, int endY, char[][] canvasBuilt) {
        super(startX, startY, endX, endY);
        this.canvasBuilt = canvasBuilt;
    }

    public char[][] buildLine() {
            if (startX < canvasBuilt[0].length - 1 && endX < canvasBuilt[0].length - 1 && startY < canvasBuilt.length - 1 && endY < canvasBuilt.length - 1 && startX != 0 && endX != 0 && startY != 0 && endY != 0) {
                checkCoord();
                canvasBuilt = drawHorizonVert(canvasBuilt);
            } else {
                System.out.println("Coordinates entered out of canvas range");
            }
        return canvasBuilt;
    }

    char[][] drawHorizonVert(char[][] canvasBuilt) {

        //create horizontal line first
        canvasBuilt = printHorizontal(canvasBuilt);

        //compare y coordinate, then create vertical line
        canvasBuilt = printVertical(canvasBuilt);

        return canvasBuilt;
    }

    void checkCoord() {
        int temp;
        //Ensure first coordinate is on the left
        if(startX > endX) {
            //swap coordinate
            temp = startX;
            startX = endX;
            endX = temp;
            temp = startY;
            startY = endY;
            endY = temp;
        }
    }

    char[][] printHorizontal(char[][] canvasBuilt) {
        if(startX < endX) {
            for (int i = startX; i <= endX; i++) {
                canvasBuilt[startY][i] = 'X';
            }
        } else {
            for (int i = endX; i <= startX; i++) {
                canvasBuilt[startY][i] = 'X';
            }
        }
        return canvasBuilt;
    }

    char[][] printVertical(char[][] canvasBuilt) {
        if (startY < endY) {
            for (int j = startY; j <= endY; j++) {
                canvasBuilt[j][endX] = 'X';
            }
        } else {
            for (int j = endY; j <= startY; j++) {
                canvasBuilt[j][endX] = 'X';
            }
        }
        return canvasBuilt;
    }

    void swapCoord() {
        int temp;
        //swap coordinate
        temp = startX;
        startX = endX;
        endX = temp;
        temp = startY;
        startY = endY;
        endY = temp;
    }
}
