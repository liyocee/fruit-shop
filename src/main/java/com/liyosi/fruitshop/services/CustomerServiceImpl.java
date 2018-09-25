package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.mapper.CustomerMapper;
import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.domain.Customer;
import com.liyosi.fruitshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by liyosi on Sep, 2018
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public List<CustomerDTO> findCustomers() {
    return customerRepository.findAll()
        .stream()
        .map(customerMapper::customerToCustomerDTO)
        .collect(Collectors.toList());
  }

  @Override
  public CustomerDTO findById(Long id) {
    Optional<Customer> customer = customerRepository.findById(id);

    return customer.map(customerMapper::customerToCustomerDTO).orElse(null);

  }
}
