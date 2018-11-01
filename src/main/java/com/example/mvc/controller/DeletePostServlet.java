package com.example.mvc.controller;

import com.example.mvc.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePostServlet", urlPatterns = "/delete/*")
public class DeletePostServlet extends HttpServlet {

    private PostService postService;

    @Override
    public void init() {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        postService.deletePostById(id);
        resp.sendRedirect("/posts");
    }
}
