package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    @Query(value = " CALL sp_InvoicesUserRangeDate(:iduser,:datefrom,:dateto);", nativeQuery = true)
    List<InvoiceUserAndDate> getReportInvoicesByUserByDate(@Param("iduser") Integer idUser, @Param("datefrom") Date dateFrom, @Param("dateto") Date dateTo );

}
