package com.liyosi.fruitshop.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by liyosi on Sep, 2018
 */
@Data
@AllArgsConstructor
public class CustomerListDTO {
  List<CustomerDTO> customers;
}
