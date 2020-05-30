package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.projection.UserCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value="SELECT c.name, count(u.id_user)as cant from cities c inner join users u on c.id_city=u.id_city group by c.id_city",nativeQuery = true)
    List<UserCant>getUserCant();
}
