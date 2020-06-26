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
@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPhone;

    @NotNull
    private String number;

   /* @NotNull
    private Integer id_phone_type;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_phone_type")
    private PhoneType phoneType;

    @OneToMany(mappedBy = "phone")
    private List<Invoice> listInvoices;


    /*@OneToMany(mappedBy = "phone")
    private List<Call> listCalls;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCity")
    private City city;

    @NotNull
    private boolean active;
}
