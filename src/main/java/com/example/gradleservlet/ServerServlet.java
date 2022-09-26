package com.example.gradleservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "serverServlet", value = "/server")
public class ServerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out = resp.getOutputStream();
        /**
         * Build 된 이후에도 파일경로를 찾아 파일을 쓸 수 있는 방법은?
         *
         */
        FileInputStream fin = new FileInputStream("./img/fileserver.png");
        resp.setContentType("image/jpg");
        byte[] arr = new byte[1024 * 8];
        while (true) {
            int count = fin.read(arr);
            if (count == -1) {
                break;
            }
            out.write(arr, 0, count);
        }

        fin.close();
    }
}
