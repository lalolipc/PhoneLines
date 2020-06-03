package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CustomerCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query(value="SELECT ci.name, count(cu.id_customer)as cant from cities ci inner join customers cu on ci.id_city=cu.id_city group by ci.id_city",nativeQuery = true)
    List<CustomerCant>getCustomerCant();
    @Query(value = "SELECT * FROM customers WHERE name = ?1",nativeQuery = true)
     List<Customer> findByName();
    @Query(value = "SELECT * FROM customers WHERE id_customer = ?1",nativeQuery = true)
    Customer getById(Integer idCustomer);


}
