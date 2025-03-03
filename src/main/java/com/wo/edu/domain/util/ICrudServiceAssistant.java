package com.wo.edu.domain.util;

import java.util.List;
import java.util.Optional;

public interface ICrudServiceAssistant<EntityResponse, EntityRequest, Id> {
    List<EntityRequest> findAll();

    Optional<EntityRequest> findById(Id id);

    EntityResponse save(EntityRequest entity);

    Boolean deleteById(Id id);
}
