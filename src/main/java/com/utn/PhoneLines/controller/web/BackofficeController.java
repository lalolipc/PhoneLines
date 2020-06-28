package com.utn.PhoneLines.controller.web;

import com.utn.PhoneLines.controller.CallController;
import com.utn.PhoneLines.controller.InvoiceController;
import com.utn.PhoneLines.exceptions.UserException;
import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.CallClientOffice;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/backoffice")
public class BackofficeController {

    CallController callController;
    SessionManager sessionManager;
    InvoiceController invoiceController;

    @Autowired
    public BackofficeController(CallController callController, SessionManager sessionManager, InvoiceController invoiceController) {
        this.callController = callController;
        this.sessionManager = sessionManager;
        this.invoiceController = invoiceController;
    }


    @GetMapping( "/calls/{idUser}")
    public ResponseEntity<List<CallClientOffice>> getCallsByUserBackoffice(@RequestHeader("Authorization") String sessionToken,
                                                                           @PathVariable(value = "idUser", required = true) Integer idUser)
            throws  UserNotExistsException {
        return this.callController.getCallsByUserBackoffice(sessionToken,idUser);

    }
/*Borrar
    @GetMapping( "/invoices/")
    public ResponseEntity<List<Invoice>> findAll(@RequestHeader("Authorization") String sessionToken)
            throws UserException, UserNotExistsException {

        return this.invoiceController.findAll(sessionToken);

    }*/


    private User getCurrentUser(String sessionToken) throws UserException {

        return Optional.ofNullable(sessionManager.getCurrentUser(sessionToken))
                .orElseThrow(() -> new UserException("User not Logged"));
    }
}
