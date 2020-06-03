package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="calls")
public class Call {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCall;

    //cuando consultamos una tabla tenga estado de la otra
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_origin_phone")
    @JoinColumn(name = "idOriginPhone")
    private Phone originPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_origin_phone")
    @JoinColumn(name = "idDestinationPhone")
    private Phone destinationPhone;

    private Date dateCall;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_rate")
    @JoinColumn(name = "idRate")
    private Rate rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_invoice")
    @JoinColumn(name = "idInvoice")
    private Invoice invoice;

    private Integer duration;
    private float totalPrice;
    private float costPrice;










}
