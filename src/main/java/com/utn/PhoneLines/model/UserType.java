package com.utn.PhoneLines.model;

import com.sun.istack.NotNull;
import com.utn.PhoneLines.model.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="usertypes")
public class UserType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUserType;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private UserTypeEnum name;


}
