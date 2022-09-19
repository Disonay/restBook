package com.rest.app.provider;

import java.util.List;

public interface Provider<EntityDTO> {
    EntityDTO getEntityById(Long entityId);
    List<EntityDTO> getAllEntities();
}
