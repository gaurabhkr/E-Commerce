package com.protot.ECommerceb.homep;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.protot.ECommerceb.models.ItemDetail;

import jakarta.transaction.Transactional;
@Repository
public interface HomepDAO  extends JpaRepository<ItemDetail,UUID> {
	
	
	@Transactional
	@Modifying
	@Query(value="SELECT id, item_name ,item_price, item_category, item_deliv	FROM public.item;" , nativeQuery = true)
	public List<ItemDetail> finditemhome();
	
	//To delete an item used by admin to delete an item from homepage
	@Transactional
	@Modifying
	@Query(value="DELETE FROM public.item	WHERE id=CAST(:id AS UUID) ",nativeQuery=true)
	public void deleteoneitem(@Param("id") UUID id);
	
	@Transactional
	@Modifying
	@Query(value="Update public.item Set item_images=item_images::TEXT[] || ARRAY[CAST(?2 AS TEXT)] ::TEXT[] "
				+ "WHERE id=CAST(?1 AS UUID) ;",nativeQuery = true)
	public void insertimage(UUID itemi,String images[]);
	
	
	//Order by Price
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM public.item a WHERE "
			+ "LOWER(a.item_name)     LIKE   LOWER  (CONCAT  ('%',   CAST(?1 AS TEXT),  '%'))  OR "
			+ "LOWER(a.item_category) LIKE   LOWER  (CONCAT  ('%',  CAST(?1 AS TEXT),'%'))     OR "
			+ "LOWER(a.item_price)    LIKE   LOWER  (CONCAT  ('%',  CAST(?1 AS TEXT),'%'))     OR "
			+ "LOWER(a.item_seller)   LIKE   LOWER  (CONCAT  ('%',  CAST(?1 AS TEXT),'%'))     OR "
			+ "LOWER(a.item_about)    LIKE   LOWER  (CONCAT  ('%',  CAST(?1 AS TEXT),'%'))        "
			+"ORDER BY item_price ASC "
			,nativeQuery = true)
	public List<ItemDetail> searchsect(String searchtext);
		
		
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM public.item  WHERE item_category LIKE (CONCAT  ('%',   CAST(?1 AS TEXT),  '%')) "
			+ "ORDER BY item_price ASC ",nativeQuery=true)
	public List<ItemDetail> searchcategory(String category);
	}