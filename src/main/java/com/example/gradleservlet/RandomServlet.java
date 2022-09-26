package com.example.gradleservlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "random", value = "/random")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");
        BufferedImage image = new BufferedImage(800, 100, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 800, 100);

        Font plainFont = new Font("Serif", Font.BOLD, 50);
        graphics.setColor(Color.PINK);
        graphics.setFont(plainFont);


        int[] lotto = getLotto();
        for (int i = 0; i < 6; i++) {
            graphics.drawString("" + lotto[i], 100 * (i + 1), 50);
        }

        OutputStream outputStream = response.getOutputStream();

        ImageIO.write(image, "jpg", outputStream);
    }

    private int[] getLotto() {
        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++) {
            lotto[i] = (int) (Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        return lotto;
    }
}
