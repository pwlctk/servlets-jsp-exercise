package com.example.mvc.controller;

import com.example.mvc.model.User;
import com.example.mvc.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPostServlet", urlPatterns = "/add")
public class AddPostServlet extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        postService = new PostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        User user = (User)req.getSession().getAttribute("user");
        Long userId = user.getId();

        postService.addPost(subject, content, userId);
        req.getRequestDispatcher("/posts").forward(req, resp);
    }
}
