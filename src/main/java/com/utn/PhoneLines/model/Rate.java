package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="rates")
public class Rate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRate;

    @NotNull
    private float minutePrice;
    @NotNull
    private float costPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_city_from")
    @JoinColumn(name="idCityFrom")
    private City cityFrom;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_city_to")
    @JoinColumn(name="idCityTo")
    private City cityTo;

    @OneToMany(mappedBy = "rate")
    private List<Call> listCalls;

}
