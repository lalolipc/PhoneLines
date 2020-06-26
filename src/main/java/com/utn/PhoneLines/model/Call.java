package com.utn.PhoneLines.model;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="calls")
public class Call {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_call")
    private Integer idCall;

    //cuando consultamos una tabla tenga estado de la otra

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_origin_phone")
    private Phone originPhone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_destination_phone")
    private Phone destinationPhone;

    @Column(name="date_call")
    private LocalDateTime dateCall;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rate")
    private Rate rate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @NotNull
    private Integer duration;
    @NotNull
    private double totalPrice;
    @NotNull
    private double costPrice;
    @NotNull
    private double salePrice;

    @NotNull
    private String numberOrigin;
    @NotNull
    private String numberDestination;
    @NotNull
    private String cityOrigin;
    @NotNull
    private String cityDestination;










}