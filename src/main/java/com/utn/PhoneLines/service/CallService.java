package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.dto.CallInfraestructure;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.CallsClientTop;
import com.utn.PhoneLines.projection.Infraestructure;
import com.utn.PhoneLines.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Service
public class CallService {

    private final CallRepository callRepository;
   // private final UserRepository userRepository;
    @Autowired
    public CallService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }



    public Call add(Call call) {

        return this.callRepository.save(call);
    }


    public Infraestructure addCallFromInfraestructure(CallInfraestructure call) {
        try {
            return callRepository.addCallFromInfraestructure(call.getNumberOrigin(), call.getNumberDestination(), call.getDuration(), call.getCallDate());

        }catch (Exception ex){
            throw ex;
        }

    }


    public List<CallsClient> getCallsByUserByDate(RangeDate rangeDate) throws UserNotExistsException {
       // User u= userRepository.findById(callUserFilter.getIdUser()).orElseThrow(() -> new UserNotExistsException());

        return callRepository.getReportCallsByUserByDate(rangeDate.getIdUser(), rangeDate.getDateFrom(), rangeDate.getDateTo());
    }

    public List<CallsClientTop> getTopDestination(Integer idUser) throws UserNotExistsException{

        return callRepository.getTopCallsbyUser(idUser);

    }

    public List<Call> getCallsByUser(Integer idUser) throws UserNotExistsException{


        return callRepository.getCallsByUserBackoffice(idUser);




    }


}
