package com.liyosi.fruitshop.repositories;

import com.liyosi.fruitshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liyosi on Sep, 2018
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  public Customer findByFirstName(String firstName);

  public Customer findByLastName(String lastName);
}
