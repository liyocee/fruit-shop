package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.api.v1.model.CategoryListDTO;
import com.liyosi.fruitshop.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liyosi on Sep, 2018
 */
@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public CategoryListDTO getAllCategories() {
    return new CategoryListDTO(categoryService.getAllCategories());
  }

  @GetMapping("{name}")
  @ResponseStatus(HttpStatus.OK)
  public CategoryDTO getCategory(@PathVariable String name) {
    return categoryService.getCategoryByName(name);
  }
}
