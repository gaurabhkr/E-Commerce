package com.protot.ECommerceb.login;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.protot.ECommerceb.models.UserLogin;

import jakarta.transaction.Transactional;

//Class for JPA or Hibernate methods
// We will extends JPA class < Classmodel name , primary key datatyp>
@Repository
public interface LoginDAO extends JpaRepository<UserLogin, UUID> {
	
    public UserLogin findByUsername(String name);
    
    @Transactional
    @Modifying
	@Query( value="UPDATE public.user_login    SET   username=cast(?2 AS text)	WHERE user_id= cast(?1 AS uuid)  ; " ,nativeQuery=true)
	public  void updateusername(UUID id,String username) ;
	
    @Transactional
    @Modifying
	@Query(value=" UPDATE public.user_login	SET password=cast(?2 AS text)	WHERE user_id= cast(?1 AS uuid) ;",nativeQuery=true)
	public  void updateuserpassword(UUID id,String password);
	
}
