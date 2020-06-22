package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTypeRepository extends JpaRepository<PhoneType,Integer> {
}
