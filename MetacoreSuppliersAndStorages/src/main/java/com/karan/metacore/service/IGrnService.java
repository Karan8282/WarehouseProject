package com.karan.metacore.service;

import java.util.List;
import java.util.Optional;

import com.karan.metacore.model.Grn;
import com.karan.metacore.model.GrnDtl;

public interface IGrnService {

	String saveGrn(Grn grn);
	List<Grn> getAllGrns();
	Optional<Grn> getOneGrn(Integer id);
	//screen#2
	void saveGrnDtl(GrnDtl dtl);
	List<GrnDtl> getAllGrnDtlByGrnId(Integer id);
	void updateGrnDtlStatusById(String status, Integer dtlId);	
}
