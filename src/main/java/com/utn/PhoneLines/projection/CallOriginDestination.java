package com.utn.PhoneLines.projection;

import com.utn.PhoneLines.model.Call;

import java.util.List;

public interface CallOriginDestination {

    Integer getId();
    Integer getDuration();
    Integer getDateCall();
    Integer getTotalPrice();
    Integer getCostPrice();

}
