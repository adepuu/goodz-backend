package com.goodz.backend.domain.context.element;

import lombok.experimental.SuperBuilder;

/**
 * Marker superclass for all local Entities
 *
 * @param <ID> - type of identifier (use wrapper on top of primitive types)
 */
@SuperBuilder
public abstract class LocalEntity<ID> extends Entity<ID> {
}
