package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.CallCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CallRepository  extends JpaRepository<Call,Integer> {


    @Query(value="SELECT cu.name, count(ca.id_origin_phone)as cant from calls ca inner join phones  ph on id_origin_phone=id_phone inner join users cu on ph.id_user=cu.id_user group by cu.id_user",nativeQuery = true)
    List<CallCant> getCallCant();
}
