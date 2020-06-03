package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallLast;
import com.utn.PhoneLines.projection.CallOriginDestination;
import com.utn.PhoneLines.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CallService {

    private final CallRepository callRepository;
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
    public List<CallLast> getCallLast(){
        return callRepository.getCallLast();
    }

    public List<CallOriginDestination>  getCallOriginDestination(Integer idOrigin, Integer idDestination) {
        return callRepository.getCallOriginDestination(idOrigin,idDestination);
    }
}
