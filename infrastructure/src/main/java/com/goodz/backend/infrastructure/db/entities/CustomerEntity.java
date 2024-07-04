package com.goodz.backend.infrastructure.db.entities;


import com.goodz.backend.domain.context.element.customer.CustomerState;
import com.goodz.backend.domain.context.element.customer.CustomerType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String displayName;

  private String firstName;

  private String lastName;

  @Enumerated(value = EnumType.STRING)
  private CustomerState state;

  @Enumerated(value = EnumType.STRING)
  private CustomerType type;

  @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
  private List<PaymentEntity> payments;

  @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
  private List<AddressEntity> addresses;

  @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
  private List<InvoiceEntity> invoices;

  @CreationTimestamp
  @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updateTimestamp;
}
