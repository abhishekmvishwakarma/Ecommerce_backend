package com.services;

import java.util.List;

import com.model.Category;

public interface CategoryService
{
	Category addCategoryToUser(Category category,long idUser);
	Category editCategory(Category category,long id);
	Category findCategoryById(long id);
	void deleteCategory(long id);
	List<Category> findAllCategory();
	List<Category> findCategoriesForUser(long id);

}
