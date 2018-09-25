package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.model.CustomerDTO;

import java.util.List;

/**
 * Created by liyosi on Sep, 2018
 */
public interface CustomerService {

  public List<CustomerDTO> findCustomers();

  public CustomerDTO findById(Long id);
}
