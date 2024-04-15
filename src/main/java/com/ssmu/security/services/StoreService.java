package com.ssmu.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmu.security.model.Store;
import com.ssmu.security.repositories.StoreRepository;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Store store) {
        return storeRepository.save(store);
    }


   public Store getStoreByName(String name) {
        return storeRepository.findByName(name);
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).get();
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public void deleteStoreById(Long id) {
        storeRepository.deleteById(id);
    }

    public void deleteStore(Store store) {
        storeRepository.delete(store);
    }


}