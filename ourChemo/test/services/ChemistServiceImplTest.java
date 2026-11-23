package services;

import ng.ourChemo.data.models.Batch;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.repositories.*;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.responses.AddDrugResponse;
import ng.ourChemo.dtos.responses.RegisterUserResponse;
import ng.ourChemo.services.AuthServices;
import ng.ourChemo.services.AuthServicesImpl;
import ng.ourChemo.services.ChemistService;
import ng.ourChemo.services.ChemistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ChemistServiceImplTest {

    private DrugRepository drugRepo;
    private BatchRepository batchRepo;
    private UserRepository userRepo;

    @BeforeEach
    public void setup() {
        drugRepo = new DrugRepositoryImpl();
        drugRepo.deleteAll();
        batchRepo = new BatchRepositoryImpl();
        batchRepo.deleteAll();
        userRepo = new UserRepositoryImpl();
        userRepo.deleteAll();
    }

    @Test
    public void Register_Login_AddDrug_DrugCountAndBatchIsOne() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();
        AddDrugResponse drugResponse = chemistServices.addDrug(drugRequest);

        Batch foundDrug = batchRepo.findById(drugResponse.getId());

        assertEquals("Metronidazole", drugResponse.getName());
        assertEquals("Flagyl", drugResponse.getBrand());
        assertEquals(1, drugRepo.count());
        assertEquals(1, batchRepo.count());
        assertEquals(10, foundDrug.getQuantityLeft());
    }

    @Test
    public void Register_Login_AddDrug_WithEmptyValue_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(null));
    }

    @Test
    public void Register_Login_AddDrugWIthEmptyName_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName(" ");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(drugRequest));
    }

    @Test
    public void Register_Login_AddDrugWIthEmptyBrand_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand(" ");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(drugRequest));
    }

    @Test
    public void Register_Login_AddDrugWIthQuantityLessThanZero_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(-5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(drugRequest));
    }

    @Test
    public void Register_Login_AddDrugWIthPriceLessThanZero_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(-2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(drugRequest));
    }

    @Test
    public void Register_Login_AddDrugWithDate_LessThanToday_ThrowException() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().minusMonths(1));
        ChemistService chemistServices = new ChemistServiceImpl();

        assertThrows(IllegalArgumentException.class, () -> chemistServices.addDrug(drugRequest));
    }

    @Test
    public void Register_Login_AddTwoDifferentDrugs_DrugAndBatchRepoCountIsTwo() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();
        AddDrugResponse drugResponse = chemistServices.addDrug(drugRequest);

        AddDrugRequest drugRequestTwo = new AddDrugRequest();
        drugRequestTwo.setName("Paracetamol");
        drugRequestTwo.setBrand("Panadol");
        drugRequestTwo.setPrice(1500);
        drugRequestTwo.setQuantity(20);
        drugRequestTwo.setExpiryDate(YearMonth.now().plusYears(3));
        AddDrugResponse drugResponseTwo = chemistServices.addDrug(drugRequestTwo);

        Batch drugOne = batchRepo.findById(drugResponse.getId());
        Batch drugTwo = batchRepo.findById(drugResponseTwo.getId());

        assertEquals(10, drugOne.getQuantityLeft());
        assertEquals(20, drugTwo.getQuantityLeft());
        assertEquals(2, drugRepo.count());
        assertEquals(2, batchRepo.count());

    }

    @Test
    public void Register_Login_AddTwoDrugWithSameNameAndBrand_BatchRepoIsTwo_DrugRepoIsOne () {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(2));
        ChemistService chemistServices = new ChemistServiceImpl();
        AddDrugResponse drugResponse = chemistServices.addDrug(drugRequest);

        AddDrugRequest drugRequestTwo = new AddDrugRequest();
        drugRequestTwo.setName("Metronidazole");
        drugRequestTwo.setBrand("Flagyl");
        drugRequestTwo.setPrice(2000);
        drugRequestTwo.setQuantity(15);
        drugRequestTwo.setExpiryDate(YearMonth.now().plusYears(3));
        chemistServices.addDrug(drugRequestTwo);

        Drug drug = drugRepo.findById(drugResponse.getId());
        Batch batch = batchRepo.findById(drugResponse.getId());

        assertEquals(1, drugRepo.count());
        assertEquals(2, batchRepo.count());
    }

    @Test
    public void Register_Login_AddThreeDrugs_TwoWithSameNameAndBrand_BatchRepoIsThree_DrugRepoIsTwo () {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();
        AddDrugResponse drugResponse = chemistServices.addDrug(drugRequest);

        AddDrugRequest drugRequestTwo = new AddDrugRequest();
        drugRequestTwo.setName("Metronidazole");
        drugRequestTwo.setBrand("Flagyl");
        drugRequestTwo.setPrice(2000);
        drugRequestTwo.setQuantity(15);
        drugRequestTwo.setExpiryDate(YearMonth.now().plusYears(3));
        chemistServices.addDrug(drugRequestTwo);

        AddDrugRequest drugRequestThree = new AddDrugRequest();
        drugRequestThree.setName("Paracetamol");
        drugRequestThree.setBrand("Panadol");
        drugRequestThree.setPrice(1500);
        drugRequestThree.setQuantity(10);
        drugRequestThree.setExpiryDate(YearMonth.now().plusYears(3));
        AddDrugResponse drugResponseThree = chemistServices.addDrug(drugRequestThree);

        Drug drug = drugRepo.findById(drugResponse.getId());
        Batch batch = batchRepo.findById(drugResponse.getId());

        Drug drugThree = drugRepo.findById(drugResponseThree.getId());

        assertEquals(2, drugRepo.count());
        assertEquals(3, batchRepo.count());
        assertEquals(2, drugRepo.getBatchCount(drug));
    }

    @Test
    public void Register_Login_AddThreeDrugs_TwoWithSameNameAndBrand_GetQuantityForEachBranchAndDrug () {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("admin1");
        registerUserRequest.setFullName("Shukurat");
        AuthServices authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(registerUserRequest.getUsername());
        userLoginRequest.setPassword(registerUserRequest.getPassword());
        authServices.login(userLoginRequest);

        AddDrugRequest drugRequest = new AddDrugRequest();
        drugRequest.setName("Metronidazole");
        drugRequest.setBrand("Flagyl");
        drugRequest.setQuantity(5);
        drugRequest.setPrice(2000);
        drugRequest.setExpiryDate(YearMonth.now().plusYears(3));
        ChemistService chemistServices = new ChemistServiceImpl();
        AddDrugResponse drugResponse = chemistServices.addDrug(drugRequest);

        AddDrugRequest drugRequestTwo = new AddDrugRequest();
        drugRequestTwo.setName("Metronidazole");
        drugRequestTwo.setBrand("Flagyl");
        drugRequestTwo.setPrice(2000);
        drugRequestTwo.setQuantity(20);
        drugRequestTwo.setExpiryDate(YearMonth.now().plusYears(3));
        AddDrugResponse drugResponseTwo = chemistServices.addDrug(drugRequestTwo);

        AddDrugRequest drugRequestThree = new AddDrugRequest();
        drugRequestThree.setName("Paracetamol");
        drugRequestThree.setBrand("Panadol");
        drugRequestThree.setPrice(1500);
        drugRequestThree.setQuantity(15);
        drugRequestThree.setExpiryDate(YearMonth.now().plusYears(3));
        AddDrugResponse drugResponseThree = chemistServices.addDrug(drugRequestThree);

        Drug drug = drugRepo.findById(drugResponse.getId());
        Batch batchOne = batchRepo.findById(drugResponse.getId());
        Batch batchTwo = batchRepo.findById(drugResponseTwo.getBatchId());

        Drug drugThree = drugRepo.findById(drugResponseThree.getId());
        Batch batchThree = batchRepo.findById(drugResponseThree.getId());

        assertEquals(20, drugThree.getQuantity());
        assertEquals(20, batchThree.getQuantityLeft());
        assertEquals(30, drug.getQuantity());
        assertEquals(10, batchOne.getQuantityLeft());
        assertEquals(20, batchTwo.getQuantityLeft());
    }
}