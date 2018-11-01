package com.example.mvc.repository;

import com.example.mvc.model.Post;
import com.example.mvc.model.User;
import com.example.mvc.util.IdGenerator;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class PostRepository {

    private UserRepository userRepository;
    private List<Post> posts;
    private IdGenerator idGenerator;
    private static PostRepository instance;

    private PostRepository() {
        this.idGenerator = new IdGenerator();
        this.userRepository = UserRepository.getInstance();
        this.posts = initPosts();
    }

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private List<Post> initPosts() {
        List<Post> result = Lists.newArrayList(); //dlaczego nie new ArrayList<>();
        result.add(new Post(idGenerator.get(), "Temat rzeka", "Rzeki są fajne, bo płynie w nich woda", userRepository.getUserById(1L).get()));
        result.add(new Post(idGenerator.get(), "Woda do picia", "Nie można pić wody z rzeki, bo jest brudna i zanieczyszczona", userRepository.getUserById(1L).get()));
        result.add(new Post(idGenerator.get(), "Sprzedam Opla", "Tanio sprzedam Opla, stan igła! Rocznik 1983", userRepository.getUserById(2L).get()));
        result.add(new Post(idGenerator.get(), "Komputer", "Szukam dobrego komputera, musi być szybki i tani, najlepiej za darmo", userRepository.getUserById(2L).get()));
        result.add(new Post(idGenerator.get(), "Przyjmę lodówkę", "Przyjmę lodówkę, powinna być nowa, nieużywana, oczywiście za darmo! Mam horom córke!", userRepository.getUserById(3L).get()));
        return result;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(String subject, String content, Long userId) {
        posts.add(new Post(idGenerator.get(), subject, content, getUser(userId)));
    }

    private User getUser(Long userId) {
        return userRepository.getUserById(userId).get();
    }


    public void deletePostById(Long id) {

        if (getPostById(id).isPresent()) {
            posts.remove(getPostById(id).get());
        }
    }

    private Optional<Post> getPostById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public void editPostById(String subject, String content, Long postId) {
        if (getPostById(postId).isPresent()) {
            Post editedPost = getPostById(postId).get();
            editedPost.setSubject(subject);
            editedPost.setContent(content);
        }
    }

    public Post getPost(Long id) {
        return getPostById(id).get();
    }
}
