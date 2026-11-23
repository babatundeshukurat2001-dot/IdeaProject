package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Batch;

import java.util.ArrayList;
import java.util.List;

public class BatchRepositoryImpl implements BatchRepository {

    private static int count;
    private static List<Batch> batches = new ArrayList<>();

    @Override
    public Batch save(Batch batch) {
        if (batch == null) {
            throw new IllegalArgumentException("Batch cannot be null");
        }
        batch.setId(++count);
        batches.add(batch);
        return batch;
    }

    @Override
    public int count() {
        return batches.size();
    }

    @Override
    public void delete(Batch batch) {
        for (Batch deletedBatch : batches) {
            if (deletedBatch.getId() == batch.getId()) {
                batches.remove(batch);
            }
        } count--;
    }

    @Override
    public void deleteAll() {
        batches.clear();
        count = 0;
    }

    @Override
    public Batch findById(int id) {
        for (Batch batch : batches) {
            if (batch.getId() == id) {
                return batch;
            }
        } return null;
    }

    @Override
    public void deleteById(int id) {
        Batch foundBatch = findById(id);
        batches.remove(foundBatch);
    }
}