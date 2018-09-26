package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.mapper.CustomerMapper;
import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.domain.Customer;
import com.liyosi.fruitshop.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by liyosi on Sep, 2018
 */
public class CustomerControllerTest extends  AbstractRestControllerTest {

  @Mock
  private CustomerService customerService;

  @InjectMocks
  private CustomerController customerController;

  private MockMvc mockMvc;

  private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
  }

  @Test
  public void testGetCustomers() throws Exception {
    // given
    Customer customer1 = new Customer();
    customer1.setId(1L);
    customer1.setFirstName("customer1");
    customer1.setLastName("customer1");

    Customer customer2 = new Customer();
    customer1.setId(1L);
    customer1.setFirstName("customer2");
    customer1.setLastName("customer2");

    when(customerService.findCustomers()).thenReturn(
        Arrays
            .asList(customer1, customer2)
            .stream().map(customerMapper::customerToCustomerDTO).collect(Collectors.toList())
    );

    // then
    mockMvc.perform(get("/api/v1/customers/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("customers", hasSize(2)));
  }


  @Test
  public void testGetCustomerById() throws Exception {
    // given
    Customer customer1 = new Customer();
    customer1.setId(1L);
    customer1.setFirstName("customer1");
    customer1.setLastName("customer1");

    when(customerService.findById(anyLong())).thenReturn(customerMapper.customerToCustomerDTO(customer1));

    //then
    mockMvc.perform(get("/api/v1/customers/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("firstname", equalTo(customer1.getFirstName())))
        .andExpect(jsonPath("lastname", equalTo(customer1.getLastName())));
  }

  @Test
  public void testCreateCustomer() throws Exception {

    // give
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setFirstname("Ckl");
    customerDTO.setLastname("Last");

    CustomerDTO savedCustomerDto = new CustomerDTO();
    savedCustomerDto.setId(1L);
    savedCustomerDto.setLastname(customerDTO.getLastname());
    savedCustomerDto.setFirstname(customerDTO.getFirstname());
    savedCustomerDto.setCustomer_url("/api/v1/customers/" + savedCustomerDto.getId());

    when(customerService.createNewCustomer(anyObject())).thenReturn(savedCustomerDto);

    // then
    mockMvc.perform(post("/api/v1/customers/")
      .contentType(MediaType.APPLICATION_JSON)
      .content(asJsonString(customerDTO)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.firstname", equalTo(customerDTO.getFirstname())));
  }
}
