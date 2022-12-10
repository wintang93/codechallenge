package com.creditsuisse.codechallenge.view;

import com.creditsuisse.codechallenge.canvas.Canvas;
import com.creditsuisse.codechallenge.canvas.Line;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ViewTests {
    static char[][] buildCanvas;
    @Mock
    private BufferedReader br;
    @Mock
    private Canvas mockCanvas;
    @Mock
    private Line mockLine;
    @InjectMocks
    View view = new View(buildCanvas);

    @BeforeAll
    static void initialiseCanvas() {
        String[] sArray = {"C", "10", "10"};
        Canvas canvas = new Canvas();
        buildCanvas = canvas.buildCanvas(sArray);
    }

    @Test
    @DisplayName("When input is build canvas, buildCanvas is called")
    void whenCommandIsC_CallBuildCanvas() throws IOException {
        String[] str = {"C", "10", "10"};

        when(br.readLine()).thenReturn("C 10 10").thenReturn("Q");
        when(mockCanvas.buildCanvas(str)).thenReturn(buildCanvas);

        view.inputCommand(br);

        verify(br, times(2)).readLine();
        verify(mockCanvas, times(1)).buildCanvas(str);
    }

    @Test
    @DisplayName("When input is build line, buildLine is called")
    void whenCommandIsL_CallBuildLine() throws IOException {
        String[] str = {"L", "2", "2", "9", "10"};

        when(br.readLine()).thenReturn("L 2 2 9 10").thenReturn("Q");

        view.inputCommand(br);

        verify(mockLine, times(1)).buildLine();
    }

    private char[][] initialiseArray(int x, int y) {
        char[][] array = new char[y+2][x+2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == array.length - 1 || i == 0) {
                    array[i][j] = '-';
                }
                else if (j == array[i].length - 1 || j == 0) {
                    array[i][j] = '|';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }

//    @Test
//    @DisplayName("When input is build canvas, buildCanvas is called")
//    void whenCommandIsC_CallBuildCanvas() throws IOException {
////        View view = new View();
//        String[] str = {"C", "10"};
//
//        doReturn(br).when(mockView).getBr();
//        doCallRealMethod().when(mockView).inputCommand();
//
////        when(mockStr.read()).thenReturn(Integer.valueOf(initialInput));
//        when(br.readLine()).thenReturn("C 10 ").thenReturn("Q");
////        when(mockCanvas.buildCanvas(str)).thenThrow(new NumberFormatException());
//
//        mockView.inputCommand();
//        Canvas canvas = new Canvas();
//        verify(canvas, times(1)).buildCanvas(str);
//        verify(br, times(2)).readLine();
//    }


//    @Test
//    @DisplayName("When input is bucketFill, fill is called")
//    void whenCommandIsR_CallFill() throws IOException {
//        String[] sArray = {"B", "1", "1", "G"};
//        initialiseCanvas();
//
//        doReturn(br).when(view).getBr();
//        doCallRealMethod().when(view).inputCommand();
//
//        when(br.readLine()).thenReturn("B 1 1 G").thenReturn("Q");
//
//        view.inputCommand();
//
//        verify(view, times(1)).fill(sArray);
//        verify(view, times(2)).printCanvas();
//    }
//
}
