package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.CallInput;
import com.utn.PhoneLines.model.dto.CallUserFilter;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.projection.Infraestructure;
import com.utn.PhoneLines.repository.CallRepository;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CallService {

    private final CallRepository callRepository;
   // private final UserRepository userRepository;
    @Autowired
    public CallService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }


    public List<Call> getAll() {

        return callRepository.findAll();
    }
    public void add(Call call) {

        this.callRepository.save(call);
    }
    public List<CallCant> getCallCant(){
        return callRepository.getCallCant();
    }

    public Infraestructure addCallFromInfraestructure(CallInput call) {
        try {
            return callRepository.addCallFromInfraestructure(call.getNumberOrigin(), call.getNumberDestination(), call.getDuration(), call.getCallDate());

        }catch (Exception ex){
            throw ex;
        }

    }


    public List<CallUserAndDate> getCallsByUserByDate(CallUserFilter callUserFilter) throws UserNotExistsException {
       // User u= userRepository.findById(callUserFilter.getIdUser()).orElseThrow(() -> new UserNotExistsException());

        return callRepository.getReportCallsByUserByDate(callUserFilter.getIdUser(),callUserFilter.getDateFrom(),callUserFilter.getDateTo());
    }



}
