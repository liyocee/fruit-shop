package com.liyosi.fruitshop.api.v1.mapper;

import com.liyosi.fruitshop.api.v1.model.CustomerDTO;
import com.liyosi.fruitshop.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by liyosi on Sep, 2018
 */
@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  @Mapping(source = "firstName", target = "firstname")
  @Mapping(source = "lastName", target = "lastname")
  CustomerDTO customerToCustomerDTO(Customer customer);

}
