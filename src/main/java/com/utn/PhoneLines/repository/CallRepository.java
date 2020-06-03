package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallLast;
import com.utn.PhoneLines.projection.CallOriginDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CallRepository  extends JpaRepository<Call,Integer> {

    @Query(value="SELECT calls.total_price as last, customers.name, customers.dni from calls INNER JOIN phones on phones.id_phone=calls.id_origin_phone inner JOIN customers on customers.id_customer=phones.id_customer  ORDER BY calls.date_call DESC LIMIT 1",nativeQuery = true)
    List<CallLast> getCallLast();
/*
    @Query(value="SELECT calls.total_price as last, customers.name, customers.dni from calls INNER JOIN phones on phones.id_phone=calls.id_origin_phone inner JOIN customers on customers.id_customer=phones.id_customer   WHERE id_customer = ?1 ORDER BY calls.date_call DESC LIMIT 1",nativeQuery = true)
    List<CallLast> getCallLast(Integer id_customer);*/
    @Query(value="SELECT cu.name, count(ca.id_origin_phone)as cant from calls ca inner join phones  ph on id_origin_phone=id_phone inner join customers cu on ph.id_customer=cu.id_customer group by cu.id_customer",nativeQuery = true)
    List<CallCant> getCallCant();

    /*PARCIAL*/
    
    @Query(value="SELECT  c.id_call as id,c.duration, c.date_call,c.total_price,c.cost_price from calls c where c.id_origin_phone=:idOrigin AND c.id_destination_phone=:idDestination",nativeQuery = true)
    List<CallOriginDestination>  getCallOriginDestination(@Param("idOrigin")Integer idOrigin, @Param("idDestination")Integer idDestination);

}
