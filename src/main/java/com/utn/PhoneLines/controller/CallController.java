package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallLast;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.service.CallService;
import com.utn.PhoneLines.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
public class CallController {

    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }



    @GetMapping("/")
    public List<Call> getAll()
    {
        return callService.getAll();
    }


    @PostMapping("/")
    public void addCall(@RequestBody final Call call) {
        callService.add(call);

    }

    @GetMapping("/projection")
    public List<CallLast> getCallLast() {
        return callService.getCallLast();
    }
    /*public List<CallCant> getCallCant() {
        return callService.getCallCant();
    }

    /*
    @GetMapping("Last/{id_customer}")
    public ResponseEntity getCallLast(@PathVariable Integer id_customer) {

        ResponseEntity response;

        try {

            response = callService.getCallLast(id_customer);

        } catch (UserNotExistsException E) {

            response = new ResponseEntity("User not exist", HttpStatus.CONFLICT);
        }

        return response;
    }
*/

}
