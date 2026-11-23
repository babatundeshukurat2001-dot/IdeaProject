package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Drug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrugRepositoryTest {

    private DrugRepository drugRepository;

    @BeforeEach
    public void setUp() {
        drugRepository = new DrugRepositoryImpl();
        drugRepository.deleteAll();
    }

    @Test
    public void newRepositoryCountIsZero() {
        assertEquals(0, drugRepository.count());
    }

    @Test
    public void saveDrugCountIsOne() {
        drugRepository.save(new Drug());
        assertEquals(1, drugRepository.count());
    }

    @Test
    public void saveDrugIsAssignedIdStartingFromOne() {
        Drug drug = drugRepository.save(new Drug());
        assertEquals(1, drug.getId());
    }

    @Test
    public void saveTwoDrugsIdsIncrementCorrectly() {
        Drug first = drugRepository.save(new Drug());
        Drug second = drugRepository.save(new Drug());
        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
    }

    @Test
    public void saveTwoDrugsCountIsTwo() {
        drugRepository.save(new Drug());
        drugRepository.save(new Drug());
        assertEquals(2, drugRepository.count());
    }

    @Test
    public void deleteDrugCountDecreases() {
        Drug drug = drugRepository.save(new Drug());
        drugRepository.save(new Drug());
        drugRepository.delete(drug);
        assertEquals(1, drugRepository.count());
    }

    @Test
    public void deleteAllCountIsZero() {
        drugRepository.save(new Drug());
        drugRepository.save(new Drug());
        drugRepository.deleteAll();
        assertEquals(0, drugRepository.count());
    }

    @Test
    public void deleteAllThenSaveStartsCountFromOne() {
        drugRepository.save(new Drug());
        drugRepository.deleteAll();
        drugRepository.save(new Drug());
        assertEquals(1, drugRepository.count());
    }

    @Test
    public void findByIdReturnsCorrectDrug() {
        Drug drug = drugRepository.save(new Drug());
        Drug found = drugRepository.findById(drug.getId());
        assertEquals(drug.getId(), found.getId());
    }

    @Test
    public void saveDrugFindByNameAndBrand_IfFound_returnsDrug () {
        Drug drug = new Drug();
        drug.setBrand("Kiss");
        drug.setName("Condom");
        drug.setSellingPrice(2000);
        drugRepository.save(drug);
        Drug foundDrug = drugRepository.findByNameAndBrand("Condom",  "Kiss");
        assertEquals(foundDrug.getName(), drug.getName());
        assertEquals(foundDrug.getBrand(), drug.getBrand());
    }

    @Test
    public void deleteDrugWithId () {
        Drug drug = drugRepository.save(new Drug());
        drugRepository.deleteById(drug.getId());
        assertEquals(0, drugRepository.count());
    }

}