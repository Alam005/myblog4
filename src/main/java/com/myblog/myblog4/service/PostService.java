package com.myblog.myblog4.service;

import com.myblog.myblog4.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postdto);

    PostDto getPostById(long id);
}
