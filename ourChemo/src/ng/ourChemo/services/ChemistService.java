package ng.ourChemo.services;

import ng.ourChemo.data.models.DispensedDrugs;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.DeleteDrugRequest;
import ng.ourChemo.dtos.requests.UpdateDrugRequest;
import ng.ourChemo.dtos.responses.AddDrugResponse;
import ng.ourChemo.dtos.responses.DeleteDrugResponse;
import ng.ourChemo.dtos.responses.UpdateDrugResponse;

public interface ChemistService {
    AddDrugResponse addDrug(AddDrugRequest addDrugRequest);
    //UpdateDrugResponse updateDrug(UpdateDrugRequest updateDrugRequest);
   // DeleteDrugResponse deleteDrug(DeleteDrugRequest deleteDrugRequest);
//    String dispenseDrugs(List<DispensedDrugs> dispenses);

}