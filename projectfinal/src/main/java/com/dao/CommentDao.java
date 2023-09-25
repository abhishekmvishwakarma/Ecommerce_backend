package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>
{

}
