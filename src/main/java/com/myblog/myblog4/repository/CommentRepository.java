package com.myblog.myblog4.repository;

import com.myblog.myblog4.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
