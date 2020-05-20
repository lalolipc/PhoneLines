package com.utn.PhoneLines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Cities")

public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCity;

    private String name;
    private String province_name;
    private String prefix;
    @OneToMany(mappedBy = "user")
    private List<User> listUsers;


}
