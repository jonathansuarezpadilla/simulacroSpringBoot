package riwi.com.simulacrospringboot.Service.CRUD;

public interface Create<EntityRequest,Entity>{

    public Entity create(EntityRequest request);
}
