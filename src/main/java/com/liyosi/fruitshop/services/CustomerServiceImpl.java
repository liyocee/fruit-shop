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
        .map(customer -> {
          CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
          customerDTO.setCustomerUrl("/api/v1/customer/" + customerDTO.getId());
          return customerDTO;
        })
        .collect(Collectors.toList());
  }

  @Override
  public CustomerDTO findById(Long id) {
    Optional<Customer> customer = customerRepository.findById(id);

    return customer.map(customerMapper::customerToCustomerDTO).orElseThrow(RuntimeException::new);

  }

  @Override
  public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
    Customer customer = customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO));

    CustomerDTO savedCustomer = customerMapper.customerToCustomerDTO(customer);

    savedCustomer.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());

    return savedCustomer;
  }

  @Override
  public CustomerDTO updateCustomer(long id, CustomerDTO customerDTO) {

    Optional<Customer> existingCustomerOption = customerRepository.findById(id);

    return existingCustomerOption.map(existingCustomer -> {
          existingCustomer.setLastName(customerDTO.getLastname());
          existingCustomer.setFirstName(customerDTO.getFirstname());
          customerRepository.save(existingCustomer);

          customerDTO.setId(id);

          return customerDTO;
        }
    ).orElseThrow(RuntimeException::new);
  }
}
