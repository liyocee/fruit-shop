package com.liyosi.fruitshop.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by liyosi on Sep, 2018
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

}
