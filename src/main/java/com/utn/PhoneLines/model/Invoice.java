package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private Date dateInvoice;
    private float costPrice;
    private float totalPrice;
    private Date dueDate;
    private String status;//debe estar en enum



    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "fk_id_phone")
    @JoinColumn(name = "idPhone")
    private Phone phone;
}
