package com.utn.PhoneLines.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RangeDate {
    private Integer idUser;
    private Date dateFrom;
    private Date dateTo;
}
