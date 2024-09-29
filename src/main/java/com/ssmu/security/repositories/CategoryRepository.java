package com.ssmu.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssmu.security.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(String id);
    Category findByName(String name);

}
