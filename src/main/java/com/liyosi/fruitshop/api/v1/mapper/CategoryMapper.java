package com.liyosi.fruitshop.api.v1.mapper;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by liyosi on Sep, 2018
 */

@Mapper
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryDTO categoryToCategoryDTO(Category category);
}
