package com.liyosi.fruitshop.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by liyosi on Sep, 2018
 */
@Data
public class CustomerDTO {

  private Long id;

  private String firstname;

  private String lastname;

  @JsonProperty("customer_url")
  private String customerUrl;

}
