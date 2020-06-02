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
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCustomer;

    private String name;
    private String lastName;
    private String dni;
     private String userName;
    private String password;
    //cuando consultamos uno tenga estado del otro
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "customer-city")//referencia para la entidad
    @JoinColumn(name = "idCity")
    private City city;






}
