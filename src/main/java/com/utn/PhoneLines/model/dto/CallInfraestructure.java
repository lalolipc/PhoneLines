package com.utn.PhoneLines.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;




@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallInfraestructure {


    private  String numberOrigin;
    private  String numberDestination;
    private float duration;
    private LocalDateTime callDate= LocalDateTime.now();


}
