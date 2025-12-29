package com.mark.backend.controller;

import com.mark.backend.model.Post;
import com.mark.backend.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/slug")
        public Post getPostBySlug(@PathVariable String slug) {
            return postService.getBySlug(slug);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }


}
