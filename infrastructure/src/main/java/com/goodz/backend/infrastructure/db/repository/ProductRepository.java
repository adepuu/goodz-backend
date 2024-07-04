package com.goodz.backend.infrastructure.db.repository;


import com.goodz.backend.infrastructure.db.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  List<ProductEntity> getAllByIdIn(List<Long> ids);
}
