package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.dto.CallInput;
import com.utn.PhoneLines.model.dto.CallUserFilter;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.projection.Infraestructure;
import com.utn.PhoneLines.service.CallService;
import com.utn.PhoneLines.service.UserService;
import com.utn.PhoneLines.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
public class CallController {

    UserService userService;
    private final CallService callService;
    private final SessionManager sessionManager;

    @Autowired
    public CallController(CallService callService, SessionManager sessionManager) {
        this.callService = callService;
        this.sessionManager = sessionManager;
    }



    @GetMapping("/")
    public ResponseEntity<List<Call>> getAll()
    {
        try{
            List<Call> calls = callService.getAll();
            return calls.size()>0 ? ResponseEntity.ok(calls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            throw ex;
        }
    }


    @PostMapping("/")
    public ResponseEntity addCall(@RequestBody final Call call) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(callService.add(call));
        }catch (Exception ex){
            throw ex;
        }
    }

    @GetMapping("/projection")
    public ResponseEntity<List<CallCant>> getCallCant() {
        try{
            List<CallCant> callsCant = callService.getCallCant();
            return callsCant.size()>0 ? ResponseEntity.ok(callsCant) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            throw ex;
        }
    }

    @PostMapping("/infraestructure")
    public ResponseEntity<Infraestructure> getInfraData(@RequestHeader("Authorization") String token,@RequestBody CallInput callInput) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(callService.addCallFromInfraestructure(callInput));
        }catch (Exception ex){
            throw ex;
        }
    }
//will fix
    @GetMapping("/CallUserAndDate")
    public  ResponseEntity<List<CallUserAndDate>> getCallsOfUserByDate(@RequestHeader("Authorization") String token, @RequestBody CallUserFilter callUserFilter) throws UserNotExistsException, Exception {
        try{
            List<CallUserAndDate> callsCant = callService.getCallsByUserByDate(callUserFilter);
            return callsCant.size()>0 ? ResponseEntity.ok(callsCant) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            throw ex;
        }
    }


    }



