package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
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
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_origin_phone")
    @JoinColumn(name = "idOriginPhone")
    private Phone originPhone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_origin_phone")
    @JoinColumn(name = "idDestinationPhone")
    private Phone destinationPhone;

    @NotNull
    private Date dateCall;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_rate")
    @JoinColumn(name = "idRate")
    private Rate rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "id_invoice")
    @JoinColumn(name = "idInvoice")
    private Invoice invoice;

    @NotNull
    private Integer duration;
    @NotNull
    private float totalPrice;
    @NotNull
    private float costPrice;
    @NotNull
    private float salePrice;
    @NotNull
    private int id_user;
    @NotNull
    private String numberOrigin;
    @NotNull
    private String numberDestination;
    @NotNull
    private String cityOrigin;
    @NotNull
    private String cityDestination;










}
