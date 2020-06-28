package com.utn.PhoneLines.model.dto;

import lombok.Data;

@Data
public class UpdateUserDto {

    private Integer idLocality;

    private String name;

    private String lastname;

    private String userType;
}