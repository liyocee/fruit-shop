package com.liyosi.fruitshop.services;

import com.liyosi.fruitshop.api.v1.mapper.CustomerMapper;
import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.domain.Customer;
import com.liyosi.fruitshop.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by liyosi on Sep, 2018
 */
public class CustomerServiceImplTest {
  @Mock
  private CustomerRepository customerRepository;

  private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  private CustomerService customerService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    customerService = new CustomerServiceImpl(customerRepository, customerMapper);
  }

  @Test
  public void findCustomers() throws Exception {
    // given
    List<Customer> customerList = Arrays.asList(new Customer(), new Customer());

    when(customerRepository.findAll()).thenReturn(customerList);

    // when
    List<CustomerDTO> customerDTOS = customerService.findCustomers();

    // then
    assertEquals(customerDTOS.size(), customerList.size());
  }

  @Test
  public void findById() throws Exception {
    // given
    Customer customer = new Customer();
    customer.setLastName("Joe");
    customer.setFirstName("Kidum");
    customer.setId(1L);

    when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

    // when
    CustomerDTO customerDTO = customerService.findById(1L);

    // then
    assertEquals(customerDTO.getLastname(), customer.getLastName());
    assertEquals(customerDTO.getFirstname(), customer.getFirstName());
  }


  @Test
  public void createCustomer() throws Exception {
    // given
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setFirstname("fname");
    customerDTO.setLastname("lname");
    customerDTO.setId(1L);

    when(customerRepository.save(any(Customer.class))).thenReturn(customerMapper.customerDTOToCustomer(customerDTO));

    // when
    CustomerDTO createdCustomer = customerService.createNewCustomer(customerDTO);

    // then
//    verify(customerRepository.save(any(Customer.class)), times(1));
    assertEquals(customerDTO.getFirstname(), createdCustomer.getFirstname());

  }
}
