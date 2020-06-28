package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.GoneException;
import com.utn.PhoneLines.exceptions.PhoneLineNotExistsException;
import com.utn.PhoneLines.exceptions.ValidationException;
import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.model.enums.LineStatus;
import com.utn.PhoneLines.service.CityService;
import com.utn.PhoneLines.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/")
    public List<Phone> getAll()
    {
        return phoneService.getAll();
    }


    public Phone addPhone(Phone phone){
        return phoneService.add(phone);
    }

    public ResponseEntity<Phone> changeStatus(String phoneNumber, String status) throws PhoneLineNotExistsException, GoneException, ValidationException {
        Phone phoneLine = this.phoneService.getByPhoneNumber(phoneNumber);

        if(phoneLine == null) {
            return (ResponseEntity<Phone>) Optional.ofNullable(null).orElseThrow(() -> new PhoneLineNotExistsException("Phone Line do not exists"));
        }

        if(!status.equals("disable")){
            if(!status.equals("enable")){
                if(!status.equals("suspend")){
                    return (ResponseEntity<Phone>) Optional.ofNullable(null).orElseThrow(() -> new ValidationException("Status is not valid"));
                }else{
                    phoneLine.setStatus(LineStatus.SUSPENDED);
                }
            }else{
                phoneLine.setStatus(LineStatus.ENABLED);
            }
        }else{
            phoneLine.setStatus(LineStatus.DISABLED);
        }

        return (ResponseEntity<Phone>) ResponseEntity.ok(this.phoneService.update(phoneLine));
    }


    public ResponseEntity delete(Integer idPhoneLine) throws PhoneLineNotExistsException, GoneException {
        Phone phoneLine = new Phone();
        phoneLine = this.phoneService.getById(idPhoneLine);
        this.phoneService.delete(phoneLine);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Phone> getPhoneLineByNumber(String number) throws PhoneLineNotExistsException, GoneException {
        return ResponseEntity.ok(this.phoneService.getByPhoneNumber(number));
    }
}
