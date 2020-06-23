package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.projection.RatesBackOffice;
import com.utn.PhoneLines.projection.CallUserAndDate;
import com.utn.PhoneLines.projection.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository
public interface CallRepository  extends JpaRepository<Call,Integer> {



    @Query(value = " CALL sp_infraestructure(:numberOrigin, :numberDestination, :duration, :dateCall);", nativeQuery = true)
    Infraestructure addCallFromInfraestructure(@Param("numberOrigin") String numberOrigin, @Param("numberDestination") String numberDestination, @Param("duration") float duration, @Param("dateCall") LocalDateTime dateCall);

    @Query(value = " CALL sp_CallsUserRangeDate(:iduser,:datefrom,:dateto);", nativeQuery = true)
    List<CallUserAndDate> getReportCallsByUserByDate(@Param("iduser") Integer idUser, @Param("datefrom") Date dateFrom, @Param("dateto") Date dateTo );

    @Query(value = " CALL sp_CallsbyUser(:iduser);", nativeQuery = true)
    List<CallUserAndDate> getCallsByUser(@Param("iduser")Integer idUser);

    // jpa brinda : List<CallUserAndDate> findByDateCallBetweenFromAndTo (LocalDateTime from, LocalDateTime to, User user);
}
