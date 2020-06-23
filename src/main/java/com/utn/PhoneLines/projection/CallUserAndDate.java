package com.utn.PhoneLines.projection;

import java.time.LocalDateTime;


public interface CallUserAndDate {


    String getNumberorigin();
    String getNumberdestination();
    LocalDateTime getDatecall();
    Integer getDuration();
    double getTotalprice();
    String getCityDestination();
    String getCityorigin();


}
