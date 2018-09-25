package com.liyosi.fruitshop.api.v1.mapper;

import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by liyosi on Sep, 2018
 */
public class CustomerMapperTest {

  CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  @Test
  public void testCustomerToCustomerDTO() throws Exception {

    // given
    Customer customer = new Customer();
    customer.setFirstName("Joy");
    customer.setLastName("Kimani");
    customer.setId(1L);

    // when
    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

    //then
    assertEquals(customerDTO.getFirstname(), customer.getFirstName());
    assertEquals(customerDTO.getLastname(), customer.getLastName());
  }
}
