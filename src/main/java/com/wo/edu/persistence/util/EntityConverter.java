package com.wo.edu.persistence.util;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Utility class for converting sets of IDs into entities.
 *
 * @author WilmerOcampo
 */
public class EntityConverter {

    /**
     * Converts a set of IDs into entities using a supplier function, and sets these entities using a setter.
     *
     * @param setter   Method to set the entities.
     * @param ids      Set of IDs to convert.
     * @param supplier Function that creates an entity.
     * @param <T>      Type of entity, must implement Identifiable.
     */
    public static <T extends Identifiable> void setEntitiesFromIds(Consumer<Set<T>> setter, Set<Long> ids, Supplier<T> supplier) {
        Set<T> entities = convertIdsToEntities(ids, supplier);
        setter.accept(entities);
    }

    /**
     * Converts a set of IDs into entities using a supplier function.
     *
     * @param ids      Set of IDs to convert.
     * @param supplier Function that creates an entity.
     * @param <T>      Type of entity, must implement Identifiable.
     * @return Set of entities with assigned IDs.
     */
    private static <T extends Identifiable> Set<T> convertIdsToEntities(Set<Long> ids, Supplier<T> supplier) {
        return ids.stream()
                .map(id -> {
                    T entity = supplier.get();
                    entity.setId(id);
                    return entity;
                })
                .collect(Collectors.toSet());
    }
}
