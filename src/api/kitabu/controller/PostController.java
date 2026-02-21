package api.kitabu.controller;

import api.kitabu.dto.PostRequest;
import api.kitabu.dto.PostResponse;
import api.kitabu.enums.BookLanguage;
import api.kitabu.service.PostService;

import java.util.List;
import java.util.UUID;

public class PostController {
    public PostService postService = new PostService();

    public String createPost(PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    public List<PostResponse> postList(BookLanguage bookLanguage) {
        return postService.postList(bookLanguage);
    }

    public String updatePost(UUID postId, PostRequest postRequest) {
        return postService.updatePost(postId, postRequest);
    }

    public PostResponse getPostById(UUID postId, BookLanguage bookLanguage) {
        return postService.getPostById(postId,bookLanguage);
    }

    public String deletePost(UUID postId) {
        return postService.deletePost(postId);
    }
}
