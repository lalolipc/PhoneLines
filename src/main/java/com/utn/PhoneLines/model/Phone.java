package com.utn.PhoneLines.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPhone;

    private String number;
    private String phoneType;//debe estar en un enum

    @OneToMany(mappedBy = "phone")
    private List<Invoice> listInvoices;

    /*@OneToMany(mappedBy = "phone")
    private List<Call> listCalls;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "fk_id_customer")//referencia para la entidad
    @JoinColumn(name = "idCustomer")
    private Customer customer;
}
