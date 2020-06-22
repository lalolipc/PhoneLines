package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idInvoice;

    @NotNull
    private LocalDateTime dateInvoice;

    @NotNull
    private float costPrice;
    @NotNull
    private float totalPrice;

    @NotNull
    private LocalDateTime dueDate;
    @NotNull
    private Integer calls_amount;

    @NotNull
    private boolean paid;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhone")
    private Phone phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;
}