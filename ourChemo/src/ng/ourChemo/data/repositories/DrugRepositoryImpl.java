package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Batch;
import ng.ourChemo.data.models.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {
    private static int count;
    private static List<Drug> drugs = new ArrayList<>();

    @Override
    public Drug save(Drug drug) {

        if(drug.getId() == 0) {
            drug.setId(++count);
            drugs.add(drug);
        }
        else{
            for(int count = 0; count < drugs.size(); count++) {
                if(drug.getId() == drugs.get(count).getId()) {
                    drugs.set(count , drug);
                }
            }
        }
        return drug;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void delete(Drug drug) {
        drugs.remove(drug);
        count--;
    }

    @Override
    public void deleteAll() {
        drugs.clear();
        count = 0;
    }

    @Override
    public Drug findById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) return drug;
        }
        return null;
    }

    @Override
    public int size() {
        return drugs.size();
    }

    @Override
    public Drug findByNameAndBrand(String name, String brand) {
        for (Drug newDrug : drugs) {
            if(newDrug.getName().equals(name) && newDrug.getBrand().equals(brand)) return newDrug;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        Drug foundedDrug = findById(id);
        drugs.remove(foundedDrug);
        count--;
    }

    @Override
    public int getBatchCount(Drug drug) {
        List<Batch> drugBatches = drug.getBathes();
        return drugBatches.size();
    }
}