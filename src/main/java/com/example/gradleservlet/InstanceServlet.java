package com.example.gradleservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "instacneServlet", value = {"/instance1", "/instance2"})
public class InstanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 서블릿 객체는 하나만, 쓰레드는 여러개
         * 주소가 달라도, 같은 서블릿 객체만 바라본다.
         * 서버를 안전하게 보호하기 위한 메모리 한정
         */

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("TEST");
        System.out.println(this);
        System.out.println(Thread.currentThread().getName());
        System.out.println("-----------------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * DML INSERT UPDATE DELETE
         */
        super.doPost(req, resp);
    }
}
