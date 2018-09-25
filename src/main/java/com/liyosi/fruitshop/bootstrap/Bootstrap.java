package com.liyosi.fruitshop.bootstrap;

import com.liyosi.fruitshop.domain.Category;
import com.liyosi.fruitshop.domain.Customer;
import com.liyosi.fruitshop.repositories.CategoryRepository;
import com.liyosi.fruitshop.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by liyosi on Sep, 2018
 */
@Component
public class Bootstrap implements CommandLineRunner {
  private final CategoryRepository categoryRepository;
  private final CustomerRepository customerRepository;

  public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
    this.categoryRepository = categoryRepository;
    this.customerRepository = customerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Started data loading now...");

    loadCategories();
    loadCustomers();
  }


  private void loadCategories() {
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

  private void loadCustomers() {
    Customer john = new Customer();
    john.setFirstName("John");
    john.setLastName("Kamau");

    Customer ken = new Customer();
    ken.setFirstName("Ken");
    ken.setLastName("Swes");

    customerRepository.saveAll(Arrays.asList(john, ken));
  }
}
