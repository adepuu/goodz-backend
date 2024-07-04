package com.goodz.backend.infrastructure.db.repository;


import com.goodz.backend.infrastructure.db.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

