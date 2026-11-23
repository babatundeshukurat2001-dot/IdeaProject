package ng.ourChemo.utils;



import ng.ourChemo.data.models.Batch;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UpdateDrugRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.responses.AddDrugResponse;

import java.time.LocalDate;


public class Mapper {

    public static User mapToUser(RegisterUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());
        return user;
    }

    public static User mapToLogin(UserLoginRequest userLoginRequest) {
        User user = new User();
        user.setUsername(userLoginRequest.getUsername());
        user.setPassword(userLoginRequest.getPassword());

        return user;
    }

    public static Drug mapToDrug(AddDrugRequest addDrugRequest) {
        Drug drug = new Drug();
        drug.setBrand(addDrugRequest.getBrand());
        drug.setName(addDrugRequest.getName());
        drug.setSellingPrice(addDrugRequest.getPrice());
        return drug;
    }

    public static AddDrugResponse mapToDrugResponse(Drug newDrug) {
        AddDrugResponse drugResponse = new AddDrugResponse();
        drugResponse.setId(newDrug.getId());
        drugResponse.setName(newDrug.getName());
        drugResponse.setBrand(newDrug.getBrand());
        drugResponse.setTotalDrugAdded(newDrug.getQuantity());
        return drugResponse;
    }

    public static Batch mapToBatch (AddDrugRequest addDrugRequest) {
        Batch newBatch = new Batch();
        newBatch.setCostPrice(addDrugRequest.getPrice());
        newBatch.setPurchaseQuantity(addDrugRequest.getQuantity());
        newBatch.setExpiryDate(addDrugRequest.getExpiryDate());
        newBatch.setPurchaseDate(LocalDate.now());
        newBatch.setDrugId(addDrugRequest.getDrugId());
        return newBatch;
    }
}