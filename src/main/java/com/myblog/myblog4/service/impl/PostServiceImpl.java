package com.myblog.myblog4.service.impl;

import com.myblog.myblog4.entity.Post;
import com.myblog.myblog4.exception.ResourceNotFoundException;
import com.myblog.myblog4.payload.PostDto;
import com.myblog.myblog4.repository.PostRepository;
import com.myblog.myblog4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
   private PostRepository postRepository;
@Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto); //This method will convert dto to entity
        Post postSaved = postRepository.save(post);

        PostDto dto = mapToDto(postSaved); //this method will convert entity to dto object
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id: " +id)
        );

        PostDto dto = new PostDto();
        dto.setId(dto.getId());
        dto.setContent(post.getContent());     //Entity to dto copy data
        dto.setDescription(post.getDescription());
        dto.setTitle(post.getTitle());
        return dto;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }
    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
   Post mapToEntity(PostDto postDto){
       Post post = new Post();
       post.setTitle(postDto.getTitle());
       post.setDescription(postDto.getDescription());
       post.setContent(postDto.getContent());
       return post;
    }

}
