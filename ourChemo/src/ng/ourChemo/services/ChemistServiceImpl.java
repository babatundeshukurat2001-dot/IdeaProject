package ng.ourChemo.services;

import ng.ourChemo.data.models.Batch;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.repositories.BatchRepository;
import ng.ourChemo.data.repositories.BatchRepositoryImpl;
import ng.ourChemo.data.repositories.DrugRepository;
import ng.ourChemo.data.repositories.DrugRepositoryImpl;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.responses.AddDrugResponse;
import ng.ourChemo.utils.Mapper;
import java.time.YearMonth;


public class ChemistServiceImpl implements ChemistService {

    private final DrugRepository drugRepository = new DrugRepositoryImpl();
    private final BatchRepository batchRepository = new BatchRepositoryImpl();

    @Override
    public AddDrugResponse addDrug(AddDrugRequest addDrugRequest) {

        validateAddDrugRequest(addDrugRequest);
        Batch batch = new Batch();
        Drug drug = drugRepository.findByNameAndBrand(addDrugRequest.getName(), addDrugRequest.getBrand());
        if (drug != null) {
            drug.setQuantity(drug.getQuantity() + addDrugRequest.getQuantity());

            batch.setCostPrice(addDrugRequest.getPrice());
            batch.setExpiryDate(addDrugRequest.getExpiryDate());
            batch.setQuantityLeft(batch.getQuantityLeft() + addDrugRequest.getQuantity());
            batchRepository.save(batch);

        }
        else {
            drug = Mapper.mapToDrug(addDrugRequest);
            drug.setQuantity(drug.getQuantity() + addDrugRequest.getQuantity());
            drugRepository.save(drug);
            Batch newBatch = new Batch();
            newBatch.setQuantityLeft(newBatch.getQuantityLeft() + addDrugRequest.getQuantity());
            batchRepository.save(newBatch);
        }
        AddDrugResponse drugResponse = Mapper.mapToDrugResponse(drug);
        drugResponse.setBatchId(batch.getId());

        return drugResponse;
    }

    public void validateAddDrugRequest(AddDrugRequest addDrugRequest) {
        if (addDrugRequest == null) {
            throw new IllegalArgumentException("Add Drug cannot be null");
        }
        if (addDrugRequest.getName() == null || addDrugRequest.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be Empty");
        }
        if (addDrugRequest.getBrand() == null || addDrugRequest.getBrand().trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be Empty");
        }
        if (addDrugRequest.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
        if (addDrugRequest.getPrice() <= 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        if (addDrugRequest.getExpiryDate().isBefore(YearMonth.now())) {
            throw new IllegalArgumentException("Drug is expired");
        }

    }
}