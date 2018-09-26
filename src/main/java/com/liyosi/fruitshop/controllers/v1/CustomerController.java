package com.liyosi.fruitshop.controllers.v1;

import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.api.v1.model.CustomerListDTO;
import com.liyosi.fruitshop.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liyosi on Sep, 2018
 */
@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  ResponseEntity<CustomerListDTO> getCustomers() {
   return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.findCustomers()), HttpStatus.OK);
  }

  @GetMapping("{id}")
  ResponseEntity<CustomerDTO> getCustomer(@PathVariable String id) {
    return new ResponseEntity<CustomerDTO>(customerService.findById(Long.valueOf(id)), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {

    CustomerDTO createdCustomer = customerService.createNewCustomer(customerDTO);

    return new ResponseEntity<CustomerDTO>(createdCustomer, HttpStatus.CREATED);
  }
}
