package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.Address;
import com.eticaret.eticaret4.adminRepositories.AddressRepository;
import com.eticaret.eticaret4.adminRepositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AddressController {

    boolean updateStatus = false;
    final AddressRepository aRepo;
    final UserRepository uRepo;

    public AddressController(AddressRepository aRepo, UserRepository uRepo) {
        this.aRepo = aRepo;
        this.uRepo = uRepo;
    }

    @GetMapping("/address")
    public String address(Model model){
        updateStatus = false;
        model.addAttribute("users",uRepo.findAll());
        model.addAttribute("addresses",aRepo.findAll());
        model.addAttribute("updateStatus", updateStatus);
        return "admin/address";
    }
    @PostMapping("/addressAdd")
    public String addressAdd(Address address){
        aRepo.save(address);
        return "redirect:/admin/address";
    }
    @GetMapping("/addressDelete/{aid}")
    public String addressDelete(@PathVariable String aid){
        try{
            int id=Integer.parseInt(aid);
            aRepo.deleteById(id);
        }catch (Exception ex){
        }
        return "redirect:/admin/address";
    }
    @GetMapping("/addressUpdate/{aid}")
    public String addressUpdate(@PathVariable String aid, Model model){
        try{
            int id=Integer.parseInt(aid);
            Optional<Address> oAddress = aRepo.findById(id);
            if(oAddress.isPresent()){
                updateStatus = true;
                model.addAttribute("singleAddress",oAddress.get());
                model.addAttribute("updateStatus", updateStatus);
                model.addAttribute("users",uRepo.findAll());
                model.addAttribute("addresses",aRepo.findAll());
            }
        }catch (Exception ex){

        }
        return "admin/address";
    }
    @PostMapping("/addressUpdateSave")
    public String addressUpdateSave(Address address){
        aRepo.saveAndFlush(address);
        return "redirect:/admin/address";
    }
}
