package com.utn.PhoneLines.model;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @JoinColumn(name = "idOriginPhone")
    private Phone originPhone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDestinationPhone")
    private Phone destinationPhone;

    @NotNull
    private LocalDateTime dateCall;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRate")
    private Rate rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInvoice")
    private Invoice invoice;

    @NotNull
    private double duration;
    @NotNull
    private double totalPrice;
    @NotNull
    private double costPrice;
    @NotNull
    private double salePrice;
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