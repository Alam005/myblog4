package com.myblog.myblog4.service.impl;

import com.myblog.myblog4.entity.Comment;
import com.myblog.myblog4.entity.Post;
import com.myblog.myblog4.exception.ResourceNotFoundException;
import com.myblog.myblog4.payload.CommentDto;
import com.myblog.myblog4.repository.CommentRepository;
import com.myblog.myblog4.repository.PostRepository;
import com.myblog.myblog4.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not found with id: " + postId)
        );
        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment saveComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setEmail(saveComment.getEmail());
        dto.setId(saveComment.getId());
        dto.setText(saveComment.getText());

        return dto;
    }
}
