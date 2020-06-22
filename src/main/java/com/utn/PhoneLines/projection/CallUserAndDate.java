package com.utn.PhoneLines.projection;

import java.time.LocalDateTime;
import java.util.Date;

public interface CallUserAndDate {

    String getNumberOrigin();
    String getCityOrigin();
    String getNumberDestination();
    String getCityDestination();
    //double getTotalPrice();
    double getDuration();
    LocalDateTime getDateCall();

    void setNumberOrigin(String numberOrigin);
    void setCityOrigin(String cityOrigin);
    void setNumberDestination(String numberDestination);
    void setCityDestination(String cityDestination);
    void setDuration(double duration);
    void setDateCall(LocalDateTime numberOrigin);
}
