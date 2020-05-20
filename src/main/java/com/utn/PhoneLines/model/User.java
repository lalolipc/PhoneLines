package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor//lombok
@NoArgsConstructor//lombok
@Data//lombok, generar setter and getters
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser;

    private String name;
    private String lastName;
    private String dni;
    private String userType;
    private String userName;
    private String password;
    //cuando consultamos uno tenga estado del otro
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "user-city")//referencia para la entidad
    @JoinColumn(name = "idCity")
    private City city;

}
