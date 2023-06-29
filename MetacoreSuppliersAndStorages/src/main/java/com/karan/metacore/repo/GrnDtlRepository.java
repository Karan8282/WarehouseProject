package com.karan.metacore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.karan.metacore.model.GrnDtl;

public interface GrnDtlRepository 
	extends JpaRepository<GrnDtl, Integer>
{
	@Query("SELECT dtl FROM GrnDtl dtl INNER JOIN dtl.grn AS grn WHERE grn.id=:grnId")
	List<GrnDtl> getAllGrnDtlByGrnId(Integer grnId);

	@Modifying
	@Query("UPDATE GrnDtl SET status=:status WHERE id=:dtlId")
	void updateGrnDtlStatusById(String status, Integer dtlId);
}
