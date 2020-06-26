package com.utn.PhoneLines.model;

import com.sun.istack.NotNull;
import com.utn.PhoneLines.model.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="phonetypes")
public class PhoneType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPhoneType;

    @NotNull
    private String name;


}