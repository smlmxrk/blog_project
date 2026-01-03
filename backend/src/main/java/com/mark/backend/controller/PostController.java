package com.mark.backend.controller;

import com.mark.backend.dto.PagedResponse;
import com.mark.backend.dto.PostResponse;
import com.mark.backend.dto.PostRequest;
import com.mark.backend.model.Post;
import com.mark.backend.service.PostService;
import jakarta.validation.Valid;
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
    public PagedResponse<PostResponse> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return postService.getAll(page, size);
    }

    @GetMapping("/{slug}")
        public PostResponse getPostBySlug(@PathVariable String slug) {
            return postService.getBySlug(slug);
    }

    @PostMapping
    public PostResponse createPost(@Valid @RequestBody PostRequest request) {
        return postService.create(request);
    }

    @PutMapping("/{slug}")
    public PostResponse updatePost(@PathVariable String slug,
                                   @Valid @RequestBody PostRequest request) {
        return postService.update(slug, request);
    }

    @DeleteMapping("/{slug}")
    public void deletePost(@PathVariable String slug) {
        postService.delete(slug);
    }


}
