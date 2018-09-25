package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Created by liyosi on Sep, 2018
 */
public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  CategoryDTO getCategoryByName(String name);
}
