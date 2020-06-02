package com.utn.PhoneLines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "city")
    private List<Customer> listCustomers;


}
