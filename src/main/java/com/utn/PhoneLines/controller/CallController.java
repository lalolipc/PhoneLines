package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.CallInfraestructure;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.CallsClientTop;
import com.utn.PhoneLines.projection.Infraestructure;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.service.CallService;
import com.utn.PhoneLines.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
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




    public  ResponseEntity<List<CallsClient>> getCallsOfUserByDate(@RequestHeader("Authorization") String token, @RequestBody RangeDate rangeDate) throws UserNotExistsException {
        User currentUser = sessionManager.getCurrentUser(token);
        rangeDate.setIdUser(currentUser.getIdUser());

        List<CallsClient> listtCalls = callService.getCallsByUserByDate(rangeDate);
        return listtCalls.size()>0 ? ResponseEntity.ok(listtCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    public ResponseEntity<List<CallsClientTop>> getTopDestination(@RequestHeader("Authorization") String token, @RequestBody User currentUser)throws UserNotExistsException {


        List<CallsClientTop> listtCalls =  callService.getTopDestination(currentUser.getIdUser());
        return listtCalls.size()>0 ? ResponseEntity.ok(listtCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<List<Call>> getCallsByUserBackoffice(@RequestHeader("Authorization") String token, Integer idUser) throws UserNotExistsException{

        List<Call> listtCalls = callService.getCallsByUser(idUser);
        return listtCalls.size()>0 ? ResponseEntity.ok(listtCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public Infraestructure addCall(CallInfraestructure c) {
        return callService.addCallFromInfraestructure(c);
    }




/*
    @GetMapping("/Client/allcalls")
    public  ResponseEntity<List<CallUserAndDate>> getCallsOfUserByDate(@RequestHeader("Authorization") String token, @RequestBody CallRangeDate callRangeDate) throws UserNotExistsException {
       User currentUser = sessionManager.getCurrentUser(token);
        callRangeDate.setIdUser(currentUser.getIdUser());

            List<CallUserAndDate> listtCalls = callService.getCallsByUserByDate(callRangeDate);
            return listtCalls.size()>0 ? ResponseEntity.ok(listtCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }*/
/*
    @GetMapping("/Employee/allcalls/{idUser}")
    public  ResponseEntity<List<CallUserAndDate>> getCallsById(@RequestHeader("Authorization") String token, @PathVariable Integer idUser) throws UserNotExistsException {
        try{
            List<CallUserAndDate> listCalls = callService.getCallsByUser(idUser);
            return listCalls.size()>0 ? ResponseEntity.ok(listCalls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            throw ex;
        }
    }
*/
}



