package com.protot.ECommerceb.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.protot.ECommerceb.models.OrderAndCart;

import jakarta.transaction.Transactional;

@Repository
public interface OrderAndCartDAO extends JpaRepository<OrderAndCart,UUID>{
	
	//https://builtin.com/data-science/postgresql-in-array will help in query
	//https://www.commandprompt.com/education/array_remove-function-in-postgresql will help in query
	
	//Cart
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO public.orderandcart (id, cart, \"order\", orderstatus) "
			+ "	VALUES (CAST(?1 AS UUID), ARRAY[]::UUID[], ARRAY[]::UUID[], ARRAY[]::TEXT[]);",nativeQuery = true)
	public void createcart(UUID i);
	
	
	//used for update concatenate
	@Transactional
	@Modifying
    @Query(value="Update public.orderandcart Set cart=cart::UUID[] || ARRAY[CAST(?2 AS UUID)] ::UUID[] "
   		+ "WHERE id=CAST(?1 AS UUID) ;",nativeQuery=true)
	public void insertitemcart(UUID useri,UUID itemid);
	
	
	@Transactional
	@Modifying
    @Query(value="SELECT UNNEST(cart) FROM public.orderandcart "
   		+ "WHERE id=CAST(?1 AS UUID);",nativeQuery=true)
	public List<UUID> getcart(UUID id);
	
	
	//Used to remove an item using item id
	@Transactional
	@Modifying
	@Query(value="UPDATE public.orderandcart SET cart=array_remove(cart,CAST(?2 AS UUID))"
			+ "WHERE id=CAST(?1 AS UUID);",nativeQuery = true)
	public void deleteitemcart(UUID useri,UUID itemid);
	
	
	
	//Order
	
	@Transactional
	@Modifying
	@Query(value="SELECT UNNEST( \"order\" ) FROM public.orderandcart "   		
	+ "WHERE id=CAST(?1 AS UUID);",  nativeQuery=true)
	public List<UUID> getorder(UUID id);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE public.orderandcart SET \"order\"=ARRAY_APPEND(\"order\", CAST(?2 AS UUID)) ,"
			+ "orderstatus=ARRAY_APPEND(orderstatus,'Packaging')   "
			+ "WHERE "
			+ "id=CAST(?1 AS UUID);", nativeQuery=true)
	public void insertorder(UUID useri,UUID itemid);
	
	
	@Transactional
	@Modifying
	@Query(value="SELECT \"order\" FROM public.orderandcart\r\n"
			+ "	 WHERE id=CAST(?1 AS UUID) ;",nativeQuery=true)
	public UUID[] getorderarra(UUID id);
	
	
	@Transactional
	@Modifying
	@Query(value="SELECT orderstatus FROM public.orderandcart\r\n"
			+ "	 WHERE id=CAST(?1 AS UUID) ;",nativeQuery = true)
	public String[] getorderstatusarr(UUID id);
	
	
	@Transactional
	@Modifying
	@Query(value="Update public.orderandcart Set \"order\"=CAST(?2 AS UUID[]) ,"
			+ " orderstatus=CAST(?3 AS TEXT[]) "
			+ "WHERE "
			+ "id=CAST(?1 AS UUID) ;",nativeQuery = true)
	public void setorderstatuse(UUID id,UUID[] order,String[] orderstatus);
	
	
	@Transactional
	@Modifying
	@Query(value="SELECT \"order\" ,UNNEST(orderstatus) FROM public.orderandcart "
			+"	WHERE id=CAST(?1 AS UUID) ;" ,nativeQuery = true)
	public List<Pair<UUID,String>> getorderandorderstatus(UUID id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT UNNEST(orderstatus) FROM public.orderandcart "
			+ "		WHERE id=CAST(?1 AS UUID) ;",nativeQuery = true)
	public List<String> getorderstatus(UUID id);
	
	
}
