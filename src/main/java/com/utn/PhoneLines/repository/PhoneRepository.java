package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {

    @Query(value = "SELECT * FROM phones WHERE number = ?1",nativeQuery = true)
    Phone findByNumber(String phoneNumber);

    Phone save(Phone phone);

    Optional<Phone> findById(Integer id);

    void delete(Phone phone);

}
