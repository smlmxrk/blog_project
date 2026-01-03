package com.mark.backend.service;


import com.mark.backend.dto.PagedResponse;
import com.mark.backend.dto.PostRequest;
import com.mark.backend.dto.PostResponse;
import com.mark.backend.exception.PostNotFoundException;
import com.mark.backend.model.Post;
import com.mark.backend.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PagedResponse<PostResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Page<Post> postPage = postRepository.findAll(pageable);

        List<PostResponse> content = postPage.getContent()
                .stream()
                .map(this::toResponse)
                .toList();

        return new PagedResponse<>(
                content,
                postPage.getNumber(),
                postPage.getSize(),
                postPage.getTotalElements(),
                postPage.getTotalPages(),
                postPage.isLast()
        );
    }


    public PostResponse getBySlug(String slug) {
        Post post = postRepository.findBySlug(slug)
                .orElseThrow(() -> new PostNotFoundException(slug));
        return toResponse(post);
    }

    public PostResponse create(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setSlug(request.getSlug());
        post.setContent(request.getContent());
        post.setAuthor(request.getAuthor());
        post.setPublished(request.isPublished());

        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        Post saved = postRepository.save(post);

        return toResponse(saved);
    }

    public PostResponse update(String slug, PostRequest request) {
        Post existing = postRepository.findBySlug(slug)
                .orElseThrow(() -> new PostNotFoundException(slug));

        existing.setTitle(request.getTitle());
        existing.setContent(request.getContent());
        existing.setAuthor(request.getAuthor());
        existing.setPublished(request.isPublished());
        existing.setSlug(request.getSlug());

        existing.setUpdatedAt(LocalDateTime.now());

        Post saved = postRepository.save(existing);

        return toResponse(saved);
    }

    public void delete(String slug) {
        Post existing = postRepository.findBySlug(slug)
                .orElseThrow(() -> new PostNotFoundException(slug));

        postRepository.delete(existing);
    }

    private PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getSlug(),
                post.getContent(),
                post.getAuthor(),
                post.isPublished(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
