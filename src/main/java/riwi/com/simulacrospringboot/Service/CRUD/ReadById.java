package riwi.com.simulacrospringboot.Service.CRUD;

public interface ReadById<ID,EntityResponse> {

    public EntityResponse readById(ID id);
}
