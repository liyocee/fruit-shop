package com.liyosi.fruitshop.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by liyosi on Sep, 2018
 */
@Data
@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;
}
