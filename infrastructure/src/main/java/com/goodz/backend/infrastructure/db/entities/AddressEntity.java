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
@Table(name = "ADDRESS")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_gen")
  @SequenceGenerator(name = "address_id_gen", sequenceName = "address_id_seq", allocationSize = 1)
  private Long id;

  private String flatNumber;

  private String street;

  private String postalCode;

  private String city;

  private String country;

  @ManyToOne
  @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
  private CustomerEntity customer;


  @CreationTimestamp
  @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updateTimestamp;

  public AddressEntity(Long address) {
    this.id = address;
  }
}
