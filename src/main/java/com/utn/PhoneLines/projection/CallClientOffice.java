package com.utn.PhoneLines.projection;

import java.time.LocalDateTime;

public interface CallClientOffice {

    String getNumberorigin();
    String getNumberdestination();
    String getCitydestination();
    LocalDateTime getDatecall();
    Integer getDuration();
    double getCostprice();
    double getTotalprice();
    String getCityDestination();
    String getCityorigin();
}
