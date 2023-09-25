package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Category;

public interface CategoryDao extends JpaRepository<Category, Long>
{

}
