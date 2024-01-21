package com.myblog.myblog4.service.impl;

import com.myblog.myblog4.entity.Post;
import com.myblog.myblog4.exception.ResourceNotFoundException;
import com.myblog.myblog4.payload.PostDto;
import com.myblog.myblog4.repository.PostRepository;
import com.myblog.myblog4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
   private PostRepository postRepository;
@Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postdto) {
        Post post = new Post();
        post.setTitle(postdto.getTitle());
        post.setDescription(postdto.getDescription());
        post.setContent(postdto.getContent());
        Post postSaved = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id: " +id)
        );

        PostDto dto = new PostDto();
        dto.setId(dto.getId());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setTitle(post.getTitle());
        return dto;
    }
}
