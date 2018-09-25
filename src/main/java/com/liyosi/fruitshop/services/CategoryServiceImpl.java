package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.mapper.CategoryMapper;
import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.domain.Category;
import com.liyosi.fruitshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liyosi on Sep, 2018
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  private final CategoryMapper mapper = CategoryMapper.INSTANCE;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<CategoryDTO> getAllCategories() {

    return categoryRepository.findAll()
        .stream()
        .map(mapper::categoryToCategoryDTO)
        .collect(Collectors.toList());
  }

  @Override
  public CategoryDTO getCategoryByName(String name) {
    Category category = categoryRepository.findByName(name);
    return mapper.categoryToCategoryDTO(category);
  }
}
