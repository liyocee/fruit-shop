package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.domain.Category;
import com.liyosi.fruitshop.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by liyosi on Sep, 2018
 */
public class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository;

  private CategoryService categoryService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    categoryService = new CategoryServiceImpl(categoryRepository);
  }

  @Test
  public void getAllCategories() throws Exception {

    // given
    List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());


    when(categoryRepository.findAll()).thenReturn(categories);

    // when
    List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

    //then
    assertEquals(categoryDTOS.size(), categories.size());

  }

  @Test
  public void getCategoryByName() throws Exception {

    // given
    Category category = new Category();
    category.setId(1L);
    category.setName("Joe");

    when(categoryRepository.findByName(anyString())).thenReturn(category);

    // when
    CategoryDTO categoryDTO = categoryService.getCategoryByName("Joe");

    // then
    assertEquals(categoryDTO.getName(), category.getName());
    assertEquals(categoryDTO.getId(), category.getId());
  }
}
