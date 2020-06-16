package com.utn.PhoneLines.projection;

import java.util.Date;

public interface CallUserAndDate {

    String getNumberOrigin();
    String getCityOrigin();
    String getNumberDestination();
    String getDestinationCity();
    float getTotalPrice();
    float getDuration();
    Date getDateCall();
}
