package com.example.mvc.controller;

import com.example.mvc.model.Post;
import com.example.mvc.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPostServlet", urlPatterns = "/edit/*")
public class EditPostServlet extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long postId = Long.valueOf(req.getParameter("id"));
        Post editPost = postService.getPostById(postId);

        req.getSession().setAttribute("postId", postId);
        req.getSession().setAttribute("subject", editPost.getSubject());
        req.getSession().setAttribute("content", editPost.getContent());

        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        Long postId = (Long) req.getSession().getAttribute("postId");
        postService.editPost(subject, content, postId);

        req.getRequestDispatcher("/posts").forward(req, resp);
    }
}
