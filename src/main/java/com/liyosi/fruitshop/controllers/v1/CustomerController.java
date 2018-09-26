package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.api.v1.model.CustomerListDTO;
import com.liyosi.fruitshop.services.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liyosi on Sep, 2018
 */
@Api(description = "Customers API endpoint")
@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  CustomerListDTO getCustomers() {
   return new CustomerListDTO(customerService.findCustomers());
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  CustomerDTO getCustomer(@PathVariable String id) {
    return customerService.findById(Long.valueOf(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
    return customerService.createNewCustomer(customerDTO);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  CustomerDTO updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO) {
    return customerService.updateCustomer(Long.valueOf(id), customerDTO);
  }
}
