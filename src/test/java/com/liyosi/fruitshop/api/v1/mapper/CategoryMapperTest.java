package com.liyosi.fruitshop.api.v1.mapper;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.domain.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by liyosi on Sep, 2018
 */
public class CategoryMapperTest {

  CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

  @Test
  public void categoryToCategoryDTO() throws Exception {

    // given
    Category category = new Category();
    String joe = "Joe";
    category.setName(joe);
    category.setId(1L);

    //when
    CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

    // then
    assertEquals(joe, categoryDTO.getName());
  }
}
