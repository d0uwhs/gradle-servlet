package com.example.gradleservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customServlet", value = "/custom")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println("doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println("서비스 호출");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println("서블릿 제거");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println("서블릿 초기화");
        super.init();
    }
}
