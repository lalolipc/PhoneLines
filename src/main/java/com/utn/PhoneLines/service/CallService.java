package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.dto.CallInfraestructure;
import com.utn.PhoneLines.model.dto.CallRangeDate;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.projection.Infraestructure;
import com.utn.PhoneLines.repository.CallRepository;
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


    public List<CallUserAndDate> getCallsByUserByDate(CallRangeDate callRangeDate) throws UserNotExistsException {
       // User u= userRepository.findById(callUserFilter.getIdUser()).orElseThrow(() -> new UserNotExistsException());

        return callRepository.getReportCallsByUserByDate(callRangeDate.getIdUser(), callRangeDate.getDateFrom(), callRangeDate.getDateTo());
    }


    public List<CallUserAndDate> getCallsByUser(Integer idUser) {
        return callRepository.getCallsByUser(idUser);
    }
}
