package com.wo.edu.domain.util;

import java.util.List;
import java.util.Optional;

public interface ICrudReposAssistant<Entity, Id> {
    List<Entity> findAll();

    Optional<Entity> findById(Id id);

    Entity save(Entity entity);

    void deleteById(Id id);
}
