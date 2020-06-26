package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.CallsClientTop;
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
    Infraestructure addCallFromInfraestructure(@Param("numberOrigin") String numberOrigin, @Param("numberDestination") String numberDestination, @Param("duration") float duration, @Param("dateCall") Date dateCall);

    @Query(value = " CALL sp_CallsUserRangeDate(:iduser,:datefrom,:dateto);", nativeQuery = true)
    List<CallsClient> getReportCallsByUserByDate(@Param("iduser") Integer idUser, @Param("datefrom") Date dateFrom, @Param("dateto") Date dateTo );

    @Query(value = " CALL sp_top10CallsbyUser(:iduser);", nativeQuery = true)
     List<CallsClientTop> getTopCallsbyUser(Integer iduser);

//backoffice
    @Query(value = " CALL sp_CallsbyUserBackoffice(:iduser);", nativeQuery = true)
    List<Call> getCallsByUserBackoffice(@Param("iduser") Integer idUser);


    // jpa brinda : List<CallUserAndDate> findByDateCallBetweenFromAndTo (LocalDateTime from, LocalDateTime to, User user);
}
