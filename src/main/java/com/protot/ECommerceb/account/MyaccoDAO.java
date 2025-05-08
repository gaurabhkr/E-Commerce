package com.protot.ECommerceb.account;

import java.util.UUID;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.protot.ECommerceb.models.MyAcco;

import jakarta.transaction.Transactional;
@Repository
public interface MyaccoDAO extends JpaRepository<MyAcco,UUID> {
	
	
	//When we will address=':address' then param will not work
	//we will use cast method to put address  
	@Transactional
	@Modifying
	@Query(value="UPDATE public.user_account	SET address= cast(:address AS text)   WHERE id = cast(:iid AS uuid) ;",nativeQuery=true)
	public void Updateaddress(@Param("iid")UUID id,@Param("address") String address) ;
	
	@Transactional
	@Modifying
	@Query(value="UPDATE public.user_account	SET contact= cast(?2 AS text) WHERE id = cast(?1 AS uuid) ;",nativeQuery=true)
	public void updatecontact(UUID id,String contact);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE public.user_account	SET email= cast(?2 AS text)    WHERE id = cast(?1 AS uuid) ;",nativeQuery=true)
	public void updateemail(UUID id,String email);
	
}
