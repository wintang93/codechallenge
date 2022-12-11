package com.creditsuisse.codechallenge.canvas;

public class Rectangle{

    int startX;
    int startY;
    int endX;
    int endY;
    private Line line;
    private char[][] canvasBuilt;

    public Rectangle(int startX, int startY, int endX, int endY, char[][] canvasBuilt) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.canvasBuilt = canvasBuilt;
    }

    public char[][] buildRectangle() {
        try {

            if (startX < canvasBuilt[0].length - 1 && endX < canvasBuilt[0].length - 1 && startY < canvasBuilt.length - 1 && endY < canvasBuilt.length - 1 && startX != 0 && endX != 0 && startY != 0 && endY != 0) {
                canvasBuilt = drawRectangle(canvasBuilt);
            } else {
                System.out.println("Coordinates entered out of canvas range");
            }
        } catch (NullPointerException e) {
            System.out.println("Please create a canvas first!");
        }
        return canvasBuilt;
    }

    private char[][] drawRectangle (char[][] builtCanvas) {

        line = new Line(startX, startY, endX, endY, canvasBuilt);
        line.checkCoord();

        //Draw the top half of rectangle
        line.drawHorizonVert(builtCanvas);

        line.swapCoord();

        //Draw the bottom half of rectangle. Vertical first then horizontal.
        line.drawHorizonVert(builtCanvas);

        return builtCanvas;
    }
}
