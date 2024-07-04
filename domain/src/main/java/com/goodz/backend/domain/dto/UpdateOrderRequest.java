package com.goodz.backend.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateOrderRequest {
  @NotNull(message = "Content is missing.")
  @Min(value = 20)
  private String content;
  @NotNull
  @NotEmpty
  @NotBlank
  private String user;
}
