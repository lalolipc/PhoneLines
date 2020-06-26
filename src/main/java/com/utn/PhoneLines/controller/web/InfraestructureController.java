package com.utn.PhoneLines.controller.web;

import com.utn.PhoneLines.controller.CallController;
import com.utn.PhoneLines.model.dto.CallInfraestructure;
import com.utn.PhoneLines.projection.Infraestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/infrastructure")
public class InfraestructureController {

    CallController callController;
    @Autowired
    public InfraestructureController(CallController callController) {
        this.callController = callController;
    }

    @PostMapping("/addCall/")
    public ResponseEntity<Infraestructure> getInfraData(@RequestHeader("Authorization") String sessionToken,String from,String to,Integer duration,
                                                        @PathVariable(value = "startDate", required = true) @DateTimeFormat(pattern = "YYYY-MM-DD") String startDate) {
        CallInfraestructure c=new CallInfraestructure(from,to,duration, Date.valueOf(startDate));
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(callController.addCall(c));
        }catch (Exception ex){
            throw ex;
        }
    }

}
