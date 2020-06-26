package com.utn.PhoneLines.controller.web;

import com.utn.PhoneLines.controller.CallController;
import com.utn.PhoneLines.controller.InvoiceController;
import com.utn.PhoneLines.controller.UserController;
import com.utn.PhoneLines.exceptions.UserException;
import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.CallRangeDate;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserController userController;
    private final CallController callController;
    private final InvoiceController invoiceController;
    private final SessionManager sessionManager;

    @Autowired
    public ApiController(final UserController userController, CallController callController, InvoiceController invoiceController, final SessionManager sessionManager){
        this.userController = userController;
        this.callController = callController;
        this.invoiceController = invoiceController;
        this.sessionManager = sessionManager;
    }

    @GetMapping("/")
    public ResponseEntity<User> getInfo(@RequestHeader("Authorization") String sessionToken) throws UserException {
        User currentUser = getCurrentUser(sessionToken);

        return ResponseEntity.ok(currentUser);

    }
/*
    @PutMapping("/info")
    public ResponseEntity<User> update(@RequestHeader("Authorization") String sessionToken,
                                       @RequestBody LoginRequestDto client) throws UserException, ValidationException{
        User currentUser = getCurrentUser(sessionToken);

        return  this.userController.update(currentUser.getIdUser(), client);

    }

    @GetMapping("/calls")
    public ResponseEntity<List<Call>> getCalls(@RequestHeader("Authorization") String sessionToken) throws UserException {

        User currentUser = getCurrentUser(sessionToken);

        return this.callController.getUserCalls(currentUser.getIdUser());
    }

    @GetMapping("/calls/most-called-places")
    public ResponseEntity<List<Locality>> getMost(@RequestHeader("Authorization") String sessionToken) throws UserException {

        User currentUser = getCurrentUser(sessionToken);

        return this.callController.getLocalitiesToByCallIdUser(currentUser.getIdUser());
    }



*/


    @GetMapping( "/calls/between-dates/{startDate}/{finalDate}")
    public ResponseEntity<List<CallUserAndDate>> getCallsBtwDates(@RequestHeader("Authorization") String sessionToken,
                                                                  @PathVariable(value = "startDate", required = true) @DateTimeFormat(pattern = "YYYY-MM-DD") String startDate,
                                                                  @PathVariable(value = "finalDate", required = true) @DateTimeFormat(pattern = "YYYY-MM-DD") String finalDate)
            throws UserException, UserNotExistsException {

        User currentUser = getCurrentUser(sessionToken);
        return this.callController.getCallsOfUserByDate(sessionToken, new CallRangeDate(currentUser.getIdUser(), Date.valueOf(startDate),Date.valueOf(finalDate)));

    }

    /*

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getBills(@RequestHeader("Authorization") String sessionToken) throws UserException {

        User currentUser = getCurrentUser(sessionToken);

        return this.billController.getBillsByIdUser(currentUser.getIdUser());

    }

    @GetMapping("/bills/between-dates/{startDate}/{finalDate}")
    public ResponseEntity<List<Bill>> getBillsBtwDates(@RequestHeader("Authorization") String sessionToken,
                                                       @PathVariable(value = "startDate", required = true) String startDate,
                                                       @PathVariable(value = "finalDate", required = true) String finalDate) throws UserException {
        User currentUser = getCurrentUser(sessionToken);

        return this.billController.getBillsBtwDatesByIdUser( startDate, finalDate, currentUser.getIdUser());


    }
*/
    private User getCurrentUser(String sessionToken) throws UserException {

        return Optional.ofNullable(sessionManager.getCurrentUser(sessionToken))
                .orElseThrow(() -> new UserException("User not Logged"));
    }
}
