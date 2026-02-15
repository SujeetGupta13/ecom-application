package com.app.ecom.repository;

import com.app.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //JpaRepository provide better performance and more operations like saveAndFlush, batch opertaions compare to CrudRepository

}
