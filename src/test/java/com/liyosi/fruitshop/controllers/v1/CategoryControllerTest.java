package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by liyosi on Sep, 2018
 */
public class CategoryControllerTest {

  @Mock
  CategoryService categoryService;

  @InjectMocks
  CategoryController categoryController;

  MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
  }

  @Test
  public void testListCategories() throws Exception {
    // given
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(1L);
    categoryDTO.setName("Cat1");

    CategoryDTO categoryDTO1 = new CategoryDTO();
    categoryDTO.setId(2L);
    categoryDTO.setName("Cat2");


    List<CategoryDTO> categoryDTOList = Arrays.asList(categoryDTO, categoryDTO1);

    when(categoryService.getAllCategories()).thenReturn(categoryDTOList);

    // then
    mockMvc.perform(get("/api/v1/categories/")
      .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.categories", hasSize(2)));
  }


  @Test
  public void testGetCategoryByName() throws Exception {
    // given
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(1L);
    categoryDTO.setName("Joe");

    when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO);

    // then

    mockMvc
        .perform(get("/api/v1/categories/Joe").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", equalTo(categoryDTO.getName())));
  }
}
