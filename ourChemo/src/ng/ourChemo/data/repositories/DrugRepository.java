package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Drug;

public interface DrugRepository {

    Drug save(Drug drug);
    void delete(Drug drug);
    void deleteAll();
    int count();
    Drug findById(int id);
    int size();
    Drug findByNameAndBrand(String name, String brand);
    void deleteById(int id);

    int getBatchCount(Drug drug);
}