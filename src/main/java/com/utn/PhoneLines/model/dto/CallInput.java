package com.utn.PhoneLines.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallInput {

private  String originNumber;
private  String destinationNumber;
private float duration;
private Date callDate;


}
