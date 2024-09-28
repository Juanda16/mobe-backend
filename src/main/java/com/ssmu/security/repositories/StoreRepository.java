package com.ssmu.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssmu.security.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findById(String id);
    Store findByName(String name);

}
