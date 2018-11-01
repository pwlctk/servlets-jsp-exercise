package com.example.mvc.service;

import com.example.mvc.model.Post;
import com.example.mvc.repository.PostRepository;

import java.util.List;

public class PostService {

    private PostRepository postRepository;

    public PostService() {
        this.postRepository = PostRepository.getInstance();
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public void deletePostById(Long id) {
        postRepository.deletePostById(id);
    }

    public void addPost(String subject, String content, Long userId) {
        postRepository.addPost(subject, content, userId);
    }

    public void editPost(String subject, String content, Long postId) {
        postRepository.editPostById(subject, content, postId);
    }

    public Post getPostById(Long id) {

        return postRepository.getPost(id);
    }
}
