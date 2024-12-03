package com.goodz.backend.infrastructure.db.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_gen")
  @SequenceGenerator(name = "payment_id_gen", sequenceName = "payment_id_seq", allocationSize = 1)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
  private CustomerEntity customer;

  @CreationTimestamp
  @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updateTimestamp;
}
