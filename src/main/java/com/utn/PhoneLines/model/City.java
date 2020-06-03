package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cities")

public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCity;

    private String name;
    private String provinceName;
    private String prefix;



    @OneToMany(fetch=FetchType.LAZY, mappedBy="city", cascade=CascadeType.ALL)
    private List<Customer> listCustomers;


}
