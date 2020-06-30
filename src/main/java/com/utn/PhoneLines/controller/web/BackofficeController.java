package com.utn.PhoneLines.controller.web;

import com.utn.PhoneLines.controller.CallController;
import com.utn.PhoneLines.controller.InvoiceController;
import com.utn.PhoneLines.controller.PhoneController;
import com.utn.PhoneLines.controller.UserController;
import com.utn.PhoneLines.exceptions.*;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.PhoneDto;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.model.dto.UpdatePhoneDto;
import com.utn.PhoneLines.model.dto.UpdateUserDto;
import com.utn.PhoneLines.projection.CallClientOffice;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.session.SessionManager;
import com.utn.PhoneLines.utils.locationUri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/backoffice")
public class BackofficeController {

    CallController callController;
    SessionManager sessionManager;
    InvoiceController invoiceController;
    UserController userController;
    PhoneController phoneController;

    @Autowired
    public BackofficeController(CallController callController, SessionManager sessionManager, InvoiceController invoiceController, UserController userController, PhoneController phoneController) {
        this.callController = callController;
        this.sessionManager = sessionManager;
        this.invoiceController = invoiceController;
        this.userController = userController;
        this.phoneController = phoneController;
    }

    //ok
    @GetMapping( "/calls/{idUser}")
    public ResponseEntity<List<CallClientOffice>> getCallsByUserBackoffice(@RequestHeader("Authorization") String sessionToken,
                                                                           @PathVariable(value = "idUser", required = true) Integer idUser)
            throws  UserNotExistsException {
        return this.callController.getCallsByUserBackoffice(sessionToken,idUser);

    }

    // MANEJO DE CLIENTES
//ok
    @GetMapping("/users/{idUser}")
    public ResponseEntity<User> getUserById (@RequestHeader("Authorization") String sessionToken,
                                             @PathVariable(value = "idUser", required = true)Integer idUser) throws UserException, UserNotExistsException {
        getCurrentUser(sessionToken);
        return this.userController.getUserById(idUser);
    }

    //ok
    @DeleteMapping("/users/{idUser}")
    public ResponseEntity deleteUser(@RequestHeader("Authorization") String sessionToken,
                                     @PathVariable(value = "idUser", required = true) Integer idUser) throws UserException, UserNotExistsException {
        getCurrentUser(sessionToken);
        this.userController.delete(idUser);
        return ResponseEntity.ok().build();
    }
//ok

    @PutMapping("/users/{idUser}")
    public ResponseEntity<User> updateClient(@RequestHeader("Authorization") String sessionToken,
                                             @PathVariable(value = "idUser", required = true) Integer idUser,
                                             @RequestBody UpdateUserDto updateUserDto) throws UserException, UserNotExistsException {
        getCurrentUser(sessionToken);

        return this.userController.update(idUser, updateUserDto);
    }


    /*
        @PutMapping("/users/{idUser}")
    public ResponseEntity<User> updateClient(@RequestHeader("Authorization") String sessionToken,
                                             @PathVariable(value = "idUser", required = true) Integer idUser,
                                             @RequestBody UpdateUserDto updateUserDto) throws ValidationException, UserException, javax.xml.bind.ValidationException {
        getCurrentUser(sessionToken);

        return this.userController.update(idUser, updateUserDto);
    }*/

    //ALTA, BAJA y SUSPENCION DE LINEAS
//ok
    @PostMapping("/phone-lines")
    public ResponseEntity addPhoneLine(@RequestHeader("Authorization") String sessionToken,
                                       @RequestBody PhoneDto phone)throws UserException,ValidationException,PhoneAlreadyExistException  {
        getCurrentUser(sessionToken);
        ResponseEntity responseEntity;

        try {
            URI uri = locationUri.getLocation(this.phoneController.addPhone(phone).getIdPhone());
            responseEntity = ResponseEntity.created(uri).build();
        } catch (ValidationException | PhoneAlreadyExistException e) {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return responseEntity;


    }
    //ok
    @PutMapping("/changestatus/")
    public ResponseEntity disablePhoneLine (@RequestHeader("Authorization") String sessionToken,
                                            @RequestBody UpdatePhoneDto updatePhoneDto)throws UserException, UserException, PhoneNotExistsException {

        getCurrentUser(sessionToken);
        this.phoneController.changeStatus(updatePhoneDto);
        return ResponseEntity.ok().build();
    }



    //ok
    @DeleteMapping("/phone-lines/{idPhoneLine}")
    public ResponseEntity deletePhoneLine (@RequestHeader("Authorization") String sessionToken,
                                           @PathVariable(value = "idPhoneLine", required = true) Integer idPhoneLine) throws PhoneNotExistsException, UserException {


        getCurrentUser(sessionToken);
        this.phoneController.delete(idPhoneLine);
        return ResponseEntity.ok().build();
    }


    //ok
    private User getCurrentUser(String sessionToken) throws UserException {

        return Optional.ofNullable(sessionManager.getCurrentUser(sessionToken))
                .orElseThrow(() -> new UserException("User not Logged"));
    }

//nohacer pero guardar
    /*

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestHeader("Authorization") String sessionToken, @RequestBody User user) throws UserException {
        getCurrentUser(sessionToken);
        return this.userController.addUser(user);
    }
*/
}
