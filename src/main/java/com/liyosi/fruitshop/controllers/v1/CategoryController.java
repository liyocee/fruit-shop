package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.model.CategoryDTO;
import com.liyosi.fruitshop.api.v1.model.CategoryListDTO;
import com.liyosi.fruitshop.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liyosi on Sep, 2018
 */
@Api(description = "Categories API endpoint")
@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get a list of categories", notes = "Categories group things together")
  public CategoryListDTO getAllCategories() {
    return new CategoryListDTO(categoryService.getAllCategories());
  }

  @GetMapping("{name}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Retrieve category by name", notes = "Return a particular category matching the provided name")
  public CategoryDTO getCategory(@PathVariable String name) {
    return categoryService.getCategoryByName(name);
  }
}
