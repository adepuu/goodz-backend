package com.goodz.backend.infrastructure.db.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
  @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq", allocationSize = 1)
  private Long id;

  private String name;

  private String company;

  private Integer quantity;

  private BigDecimal price;

  @CreationTimestamp
  @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updateTimestamp;
}
