package com.myblog.myblog4.controller;

import com.myblog.myblog4.payload.PostDto;
import com.myblog.myblog4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping("/dto")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
}
//http://localhost:8080/api/posts/particular?id=1
@GetMapping("/particular")
public ResponseEntity<PostDto> getPostById(@RequestParam long id){
    PostDto dto = postService.getPostById(id);
    return new ResponseEntity<>(dto,HttpStatus.OK);
}

//http://localhost:8080/api/posts/
@GetMapping
public List<PostDto> getAllPost(){
    List<PostDto> postDtos = postService.getAllPost();
    return postDtos;
}

}
