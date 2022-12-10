package com.creditsuisse.codechallenge.canvas;

import java.util.Arrays;

public class BucketFill {
    private int spotX;
    private int spotY;
    private char colour;
    char[][] canvasFilled;

    public BucketFill(int spotX, int spotY, char colour, char[][] canvasBuilt) {
        //Actual position of spot in canvasBuilt array
        this.spotX = spotX ;
        this.spotY = spotY ;
        this.colour = colour;
        this.canvasFilled = canvasBuilt;
    }

    public char[][] fill() {
        try {
            if (spotX < canvasFilled[0].length - 1 && spotY < canvasFilled.length - 1 && spotX != 0 && spotY != 0) {
                canvasFilled = startFill();
            } else {
                System.out.println("Coordinates entered out of canvas range");
            }
        } catch (NullPointerException e) {
            System.out.println("Please create a canvas first!");
        }
        return canvasFilled;
    }

    private char[][] startFill() {

        //Check that spot giving is empty (not part of line or rectangle)
        if (canvasFilled[spotY][spotX] == ' '){
            autoFill(spotY, spotX);
        } else {
            System.out.println("Invalid spot");
        }
        return canvasFilled;
    }

    private void autoFill(int Y, int X) {
        if (Y < canvasFilled.length -1 && X < canvasFilled[Y].length - 1  && Y != 0 && X != 0) {
            if (canvasFilled[Y][X] == ' ') {
                canvasFilled[Y][X] = colour;
                //Check top coordinate
                autoFill(Y - 1, X);
                //Check right coordinate
                autoFill(Y, X + 1);
                //Check bottom coordinate
                autoFill(Y + 1, X);
                //Check left coordinate
                autoFill(Y, X - 1);
            }
        }
    }
}
