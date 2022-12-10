package com.creditsuisse.codechallenge;

import com.creditsuisse.codechallenge.canvas.Canvas;
import com.creditsuisse.codechallenge.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class CodeChallengeApplication {

    private static View view = new View();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(CodeChallengeApplication.class, args);
        int run = view.inputCommand(br);
        if (run == 1) {
            System.out.println("Closing reader...");
            ctx.close();
        }
    }
}
