package com.mark.backend.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String slug) {
        super("Post not found with slug: " + slug);
    }
}
