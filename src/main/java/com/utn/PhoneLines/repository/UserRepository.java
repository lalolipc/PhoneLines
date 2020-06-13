package com.utn.PhoneLines.repository;

import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.projection.UserCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value="SELECT ci.name, count(u.id_user)as cant from cities ci inner join users u on ci.id_city=u.id_city group by ci.id_city",nativeQuery = true)
    List<UserCant> getUserCant();
    @Query(value = "SELECT * FROM users WHERE name = ?1",nativeQuery = true)
     List<User> findByName();
    @Query(value = "SELECT * FROM users WHERE id_user = ?1",nativeQuery = true)
    User getById(Integer idUser);

    @Query(value = "SELECT * FROM users WHERE user_name= ?1 AND password = ?2", nativeQuery = true)
    User getByUserNameAndPassword(String userName, String password);
}
