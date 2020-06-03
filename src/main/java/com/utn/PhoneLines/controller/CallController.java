package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.service.CallService;
import com.utn.PhoneLines.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Call> getAll() {
        return callService.getAll();
    }


    @PostMapping("/")
    public void addCall(@RequestBody final Call call) {
        callService.add(call);

    }

    @GetMapping("/projection")
    public List<CallCant> getCallCant() {
        return callService.getCallCant();
    }

}
