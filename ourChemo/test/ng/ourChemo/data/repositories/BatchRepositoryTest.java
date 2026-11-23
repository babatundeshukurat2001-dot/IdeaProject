package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Batch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatchRepositoryTest {

    BatchRepository batchRepository;
    DrugRepository drugRepository;


    @BeforeEach
    void setUp() {
        batchRepository = new BatchRepositoryImpl();
        batchRepository.deleteAll();
        drugRepository = new DrugRepositoryImpl();
        drugRepository.deleteAll();
    }
    @Test
    public void newRepositoryCountIsZero() {
        assertEquals(0, batchRepository.count());
    }

    @Test
    public void saveBatchCountIsOne() {
        Batch batch = batchRepository.save(new Batch());
        assertEquals(1, batchRepository.count());
    }

    @Test
    public void saveBatchIdIsOne() {
        Batch anotherBatch = new Batch();
        batchRepository.save(anotherBatch);
        assertEquals(1, anotherBatch.getId());
    }

    @Test
    public void saveTwoBatchIdsIncrementCorrectly() {
        Batch first = batchRepository.save(new Batch());
        Batch second = batchRepository.save(new Batch());
        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
    }

    @Test
    public void saveTwoBatchCountIsTwo() {
        batchRepository.save(new Batch());
        batchRepository.save(new Batch());
        assertEquals(2, batchRepository.count());
    }

    @Test
    public void deleteBatchCountDecreases() {
        Batch Batch = batchRepository.save(new Batch());
        batchRepository.save(new Batch());
        batchRepository.delete(Batch);
        assertEquals(1, batchRepository.count());
    }

    @Test
    public void deleteAllCountIsZero() {
        batchRepository.save(new Batch());
        batchRepository.save(new Batch());
        batchRepository.deleteAll();
        assertEquals(0, batchRepository.count());
    }

    @Test
    public void deleteAllThenSaveStartsCountFromOne() {
        batchRepository.save(new Batch());
        batchRepository.deleteAll();
        batchRepository.save(new Batch());
        assertEquals(1, batchRepository.count());
    }

    @Test
    public void findByIdReturnsCorrectBatch() {
        Batch Batch = batchRepository.save(new Batch());
        Batch found = batchRepository.findById(Batch.getId());
        assertEquals(Batch.getId(), found.getId());
    }

    @Test
    public void deleteBatchWithId () {
        Batch Batch = batchRepository.save(new Batch());
        batchRepository.deleteById(Batch.getId());
        assertEquals(0, batchRepository.count());
    }

}