package com.goodz.backend.infrastructure.db.entities;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LINE_ITEM")
public class LineItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "line_item_id_gen")
  @SequenceGenerator(name = "line_item_id_gen", sequenceName = "line_item_id_seq", allocationSize = 1)
  private Long id;

  private String note;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ORDER", referencedColumnName = "ID")
  private OrderEntity customerOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")
  private ProductEntity product;

  private Integer quantity;
}
