package com.rest.app.rest.manager;

import java.util.List;

public interface Manager<EntityDTO, EntityNewInfo> {
    void create(EntityDTO entityDTO);

    EntityDTO read(Long entityId);

    List<EntityDTO> list();

    void update(Long entityId, EntityNewInfo entityNewInfo);

    void delete(Long entityId);
}
