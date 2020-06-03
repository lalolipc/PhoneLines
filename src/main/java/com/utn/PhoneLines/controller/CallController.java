package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.CallLast;
import com.utn.PhoneLines.projection.CallOriginDestination;
import com.utn.PhoneLines.service.CallService;
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

    @GetMapping("/CallOriginDestination/{idOrigin}/{idDestination}")
    public List<CallOriginDestination> getOriginDestination(@PathVariable Integer idOrigin, Integer idDestination) throws UserNotExistsException {
        return callService.getCallOriginDestination(idOrigin,idDestination);

    }

}
