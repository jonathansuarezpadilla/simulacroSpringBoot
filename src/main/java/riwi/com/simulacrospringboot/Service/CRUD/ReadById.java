package riwi.com.simulacrospringboot.Service.CRUD;

public interface ReadById<ID,Entity> {

    public Entity readById(ID id);
}
