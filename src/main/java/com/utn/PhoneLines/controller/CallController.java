package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.CallInfraestructure;
import com.utn.PhoneLines.model.dto.CallRangeDate;
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

    private final CallService callService;
    private final SessionManager sessionManager;

    @Autowired
    public CallController(CallService callService, SessionManager sessionManager) {
        this.callService = callService;
        this.sessionManager = sessionManager;
    }


    @PostMapping("/infraestructure/")
    public ResponseEntity<Infraestructure> getInfraData(@RequestHeader("Authorization") String token,@RequestBody CallInfraestructure callInfraestructure) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(callService.addCallFromInfraestructure(callInfraestructure));
        }catch (Exception ex){
            throw ex;
        }
    }

    @GetMapping("/Client/allcalls")
    public  ResponseEntity<List<CallUserAndDate>> getCallsOfUserByDate(@RequestHeader("Authorization") String token, @RequestBody CallRangeDate callRangeDate) throws UserNotExistsException {
       User currentUser = sessionManager.getCurrentUser(token);
        callRangeDate.setIdUser(currentUser.getIdUser());

            List<CallUserAndDate> listtCalls = callService.getCallsByUserByDate(callRangeDate);
            return listtCalls.size()>0 ? ResponseEntity.ok(listtCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @GetMapping("/Employee/allcalls/{idUser}")
    public  ResponseEntity<List<CallUserAndDate>> getCallsById(@RequestHeader("Authorization") String token, @PathVariable Integer idUser) throws UserNotExistsException {
        try{
            List<CallUserAndDate> listCalls = callService.getCallsByUser(idUser);
            return listCalls.size()>0 ? ResponseEntity.ok(listCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            throw ex;
        }
    }

    }



