package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Batch;

public interface BatchRepository {

    Batch save(Batch batch);
    int count();
    Batch findById(int id);
    void deleteAll();
    void delete(Batch batch);
    void deleteById(int id);
}