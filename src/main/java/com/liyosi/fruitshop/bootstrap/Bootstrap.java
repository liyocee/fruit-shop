package com.liyosi.fruitshop.bootstrap;

import com.liyosi.fruitshop.domain.Category;
import com.liyosi.fruitshop.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by liyosi on Sep, 2018
 */
@Component
public class Bootstrap implements CommandLineRunner {
  private final CategoryRepository categoryRepository;

  public Bootstrap(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Started data loading now...");

    Category fruits = new Category();
    fruits.setName("Fruits");

    Category dried = new Category();
    dried.setName("Dried");

    Category fresh = new Category();
    fresh.setName("Fresh");

    Category nuts = new Category();
    nuts.setName("Nuts");

    categoryRepository.saveAll(Arrays.asList(fresh, dried, fruits, nuts));

    System.out.println("Data loaded..." + categoryRepository.count() + " items");

  }
}
