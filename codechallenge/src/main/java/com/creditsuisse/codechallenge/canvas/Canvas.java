package com.creditsuisse.codechallenge.canvas;

import com.creditsuisse.codechallenge.view.View;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Canvas {
    private int width;
    private int height;
    private char[][] canvasLayout;

    private char[][] createCanvas() {

        //building canvas top and bottom
        for (int i = 0; i < canvasLayout.length; i++) {
            for (int j = 0; j < canvasLayout[i].length; j++) {
                if (i == canvasLayout.length - 1 || i == 0) {
                    canvasLayout[i][j] = '-';
                }
                else if (j == canvasLayout[i].length - 1 || j == 0) {
                    canvasLayout[i][j] = '|';
                } else {
                    canvasLayout[i][j] = ' ';
                }
            }
        }
        return canvasLayout;
    }

    public char[][] buildCanvas(String[] sArray) {
            width = Integer.parseInt(sArray[1]);
            height = Integer.parseInt(sArray[2]);
            canvasLayout = new char[height + 2][width + 2];
            canvasLayout = createCanvas();

        return canvasLayout;
    }
}
