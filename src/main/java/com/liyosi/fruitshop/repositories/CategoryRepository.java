package com.liyosi.fruitshop.repositories;

import com.liyosi.fruitshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liyosi on Sep, 2018
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
