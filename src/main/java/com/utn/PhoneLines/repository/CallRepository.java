package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallLast;
import com.utn.PhoneLines.projection.CustomerCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CallRepository  extends JpaRepository<Call,Integer> {

    @Query(value="SELECT calls.total_price as last, customers.name, customers.dni from calls INNER JOIN phones on phones.id_phone=calls.id_origin_phone inner JOIN customers on customers.id_customer=phones.id_customer  ORDER BY calls.date_call DESC LIMIT 1",nativeQuery = true)
    List<CallLast> getCallLast();
    @Query(value="SELECT cu.name, count(ca.id_origin_phone)as cant from calls ca inner join phones  ph on id_origin_phone=id_phone inner join customers cu on ph.id_customer=cu.id_customer group by cu.id_customer",nativeQuery = true)
    List<CallCant> getCallCant();
}
