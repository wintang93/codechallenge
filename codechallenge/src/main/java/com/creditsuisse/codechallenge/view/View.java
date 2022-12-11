package com.creditsuisse.codechallenge.view;

import com.creditsuisse.codechallenge.canvas.BucketFill;
import com.creditsuisse.codechallenge.canvas.Canvas;
import com.creditsuisse.codechallenge.canvas.Line;
import com.creditsuisse.codechallenge.canvas.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;

//to print our canvas, lines and shape
public class View {

    private Canvas canvas = new Canvas();
    private Line line;
    private Rectangle rectangle;
    private BucketFill bucketFill;
    private char[][] canvasBuilt;
    private FactoryHelper helper = new FactoryHelper();

    String s = "";

    public View() {
    }

    public View(char[][] canvasBuilt) {
        this.canvasBuilt = canvasBuilt;
    }

    public int inputCommand(BufferedReader br) {
        while (!s.equalsIgnoreCase("Q")) {
            try {
                System.out.println("enter command: ");
                s = br.readLine();
                String[] sArray = s.split(" ", -1);
                //Build Canvas
                if (sArray[0].equalsIgnoreCase("C")) {
                    try {
                        canvasBuilt = canvas.buildCanvas(sArray);
                        printCanvas();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please provide canvas size.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide coordinates.");
                    } catch (NullPointerException e) {
                    System.out.println("Please create canvas first.");
                }
                    continue;
                }
                //Build Line
                if (sArray[0].equalsIgnoreCase("L")) {
                    try {
                        line = helper.createLine(sArray, canvasBuilt);
                        canvasBuilt = line.buildLine();
                        printCanvas();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please provide 2 coordinates.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide coordinates.");
                    } catch (NullPointerException e) {
                        System.out.println("Please create a canvas first!");
                    }

                    continue;
                }
                //Build Rectangle

                if (sArray[0].equalsIgnoreCase("R")) {
                    try {
                        rectangle = new Rectangle(Integer.parseInt(sArray[1]), Integer.parseInt(sArray[2]), Integer.parseInt(sArray[3]), Integer.parseInt(sArray[4]), canvasBuilt);
                        canvasBuilt = rectangle.buildRectangle();
                        printCanvas();

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please provide 2 coordinates.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide coordinates.");
                    }
                    continue;
                }
                //Bucket Fill
                if (sArray[0].equalsIgnoreCase("B")) {
                    try {
                        bucketFill = new BucketFill(Integer.parseInt(sArray[1]), Integer.parseInt(sArray[2]), sArray[3].charAt(0), canvasBuilt);
                        canvasBuilt = bucketFill.fill();
                        printCanvas();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please provide coordinates.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide correct coordinates.");
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Please provide colour.");
                    }
                } else if (!sArray[0].equalsIgnoreCase("Q")) {
                    System.out.println("Please enter valid command.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }

    private void printCanvas() {
        try {
            //printing canvas
            for (int i = 0; i < canvasBuilt.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < canvasBuilt[i].length; j++) { //this equals to the column in each row.
                    System.out.print(canvasBuilt[i][j] + " ");
                }
                System.out.println(); //change line on console as row comes to end in the matrix.
            }
        } catch (NullPointerException e) {
            System.out.println("Please provide canvas size. 1");
        }
    }

    //This class is to assist with junit test
    protected static class FactoryHelper{
        Line createLine(String[] sArray, char[][] canvasBuilt) {
            return new Line(Integer.parseInt(sArray[1]), Integer.parseInt(sArray[2]), Integer.parseInt(sArray[3]), Integer.parseInt(sArray[4]), canvasBuilt);
        }
    }
}
