package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor//lombok
@NoArgsConstructor//lombok
@Data//lombok, generar setter and getters
@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idInvoice;

    @NotNull
    private Date dateInvoice;
    @NotNull
    private float costPrice;
    @NotNull
    private float totalPrice;
    @NotNull
    private Date dueDate;
    @NotNull
    private String status;//debe estar en enum



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhone")
    private Phone phone;

    //para liquidar clientes necesito idUser en la Factura
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;
}
