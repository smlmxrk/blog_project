// types to be shared across the app for the blog posts

export interface PostResponse {
    id: number;
    title: string;
    slug: string;
    content: string;
    author: string;
    published: boolean;
    createdAt: string;
    updatedAt: string;
}

export interface PostRequest {
    title: string;
    slug: string;
    content: string;
    author: string;
    published: boolean;
}