package com.goodz.backend.infrastructure.db.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "SHIPPING")
public class ShippingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipping_id_gen")
  @SequenceGenerator(name = "shipping_id_gen", sequenceName = "shipping_id_seq", allocationSize = 1)
  private Long id;

  @OneToOne
  private OrderEntity order;

  @ManyToOne
  @JoinColumn(name = "ADDRESS", referencedColumnName = "ID")
  private AddressEntity address;

  private String note;

  @CreationTimestamp
  @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updateTimestamp;
}
