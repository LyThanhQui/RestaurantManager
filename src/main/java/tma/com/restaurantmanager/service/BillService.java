package tma.com.restaurantmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.com.restaurantmanager.exception.UserNotFoundException;
import tma.com.restaurantmanager.model.Bill;
import tma.com.restaurantmanager.model.Menu;
import tma.com.restaurantmanager.repo.BillRepo;

import java.util.List;

@Service
public class BillService {
    private final BillRepo billRepo;

    @Autowired
    public BillService(BillRepo billRepo){
        this.billRepo = billRepo;
    }
    public Bill addBill(Bill bill){
        return billRepo.save(bill);
    }
    public List<Bill> findAllBill(){
        return billRepo.findAll();
    }
    public Bill updateBill(Bill bill){
        return billRepo.save(bill);
    }
    public Bill findBillById(Long id){
        return billRepo.findBillById(id)
                .orElseThrow(()->new UserNotFoundException("Menu by id "+ id + "was not foud"));
    }
    public void deleteBill(Long id){
        billRepo.deleteById(id);
    }
}
