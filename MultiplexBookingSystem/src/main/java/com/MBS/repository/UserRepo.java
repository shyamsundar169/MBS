package com.MBS.repository;



import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MBS.model.User;


@Repository

public interface UserRepo extends  JpaRepository<User,Integers> {

}
