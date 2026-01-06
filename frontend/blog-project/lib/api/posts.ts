// All API calls related to posts (GET, POST, PUT, DELETE)

import type { PostRequest, PostResponse } from "../types/post";
import type { PagedResponse } from "../types/api";

const API_BASE_URL =
    process.env.NEXT_PUBLIC_API_BASE_URL ?? "http://localhost:8080";

export async function getPosts(
    page = 0,
    size = 10,
): Promise<PagedResponse<PostResponse>> {
    // TODO: implement fetch to `${API_BASE_URL}/api/posts?page=${page}&size=${size}`
    throw new Error("getPosts not implemented yet");
}

export async function getPostBySlug(
    slug: string,
): Promise<PostResponse> {
    // TODO: implement fetch to `${API_BASE_URL}/api/posts/${slug}`
    throw new Error("getPostBySlug not implemented yet");
}

export async function createPost(
    data: PostRequest,
): Promise<PostResponse> {
    // TODO: implement POST to `${API_BASE_URL}/api/posts`
    throw new Error("createPost not implemented yet");
}

export async function updatePost(
    slug: string,
    data: PostRequest,
): Promise<PostResponse> {
    // TODO: implement PUT to `${API_BASE_URL}/api/posts/${slug}`
    throw new Error("updatePost not implemented yet");
}

export async function deletePost(slug: string): Promise<void> {
    // TODO: implement DELETE to `${API_BASE_URL}/api/posts/${slug}`
    throw new Error("deletePost not implemented yet");
}
