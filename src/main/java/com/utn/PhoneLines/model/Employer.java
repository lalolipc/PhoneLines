package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employers")
public class Employer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEmployer;

    private String name;
    private String lastName;
    private String dni;
    private String userName;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "fk_id_city")
    @JoinColumn(name = "idCity")
    private City city;

}
