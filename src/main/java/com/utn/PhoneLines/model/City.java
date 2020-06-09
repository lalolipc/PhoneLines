package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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

    @NotNull
    private String name;

    @NotNull
    private String prefix;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "city-state")//referencia para la entidad
    @JoinColumn(name = "id_state")
    private State state;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="city", cascade=CascadeType.ALL)
    @JsonBackReference(value="listCustomers")
    private List<Customer> listCustomers;

    @OneToMany(mappedBy = "cityFrom")
    @JsonBackReference(value="listRatesFrom")
    private List<Rate> listRatesFrom;
    @OneToMany(mappedBy = "cityTo")
    @JsonBackReference(value="listRatesTo")
    private List<Rate> listRatesTo;

}
