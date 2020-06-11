package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser;

    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String dni;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    //cuando consultamos uno tenga estado del otro

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "customer-city")//referencia para la entidad
    @JoinColumn(name = "id_city")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "user-type")//referencia para la entidad
    @JoinColumn(name = "id_user_type")
    private UserType userType;






}
