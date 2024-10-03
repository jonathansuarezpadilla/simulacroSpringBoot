package riwi.com.simulacrospringboot.Service.CRUD;

import jakarta.persistence.Id;

public interface Path<EntityRequest,ID> {
    public void path(EntityRequest entityRequest, ID id);
}
