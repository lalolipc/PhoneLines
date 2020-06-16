package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.CallCant;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.projection.Infraestructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface CallRepository  extends JpaRepository<Call,Integer> {

//ste borrar luego
    @Query(value = "SELECT cu.name, count(ca.id_origin_phone)as cant from calls ca inner join phones  ph on id_origin_phone=id_phone inner join users cu on ph.id_user=cu.id_user group by cu.id_user", nativeQuery = true)
    List<CallCant> getCallCant();

    @Query(value = " CALL sp_infraestructure(:numberOrigin, :numberDestination, :duration, :dateCall);", nativeQuery = true)
    Infraestructure addCallFromInfraestructure(@Param("numberOrigin") String numberOrigin, @Param("numberDestination") String numberDestination, @Param("duration") float duration, @Param("dateCall") Date dateCall);

    @Query(value = " CALL sp_CallsUserRangeDate(:iduser,:datefrom,:dateto);", nativeQuery = true)
    List<CallUserAndDate> getReportCallsByUserByDate(@Param("iduser") Integer idUser, @Param("datefrom") Date dateFrom, @Param("dateto") Date dateTo );
}
