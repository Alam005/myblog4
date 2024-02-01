package com.myblog.myblog4.service;

import com.myblog.myblog4.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);
}
