// generic api response & error types

export interface PagedResponse<T> {
    content: T[];
    page: number;
    size: number;
    totalElements: number;
    totalPages: number;
    last: boolean;
}

export interface ApiError {
    timestamp: string;
    status: number;
    message: string;
    errors?: string[];
}