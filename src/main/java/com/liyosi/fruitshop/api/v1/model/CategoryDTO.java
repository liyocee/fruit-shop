package com.liyosi.fruitshop.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by liyosi on Sep, 2018
 */
@ApiModel(description = "Customer Details")
@Data
public class CategoryDTO {

  @ApiModelProperty(value = "PK identifier for the customer", required = false)
  private Long id;

  @ApiModelProperty(value = "Customer's first name", required = true)
  private String name;
}
