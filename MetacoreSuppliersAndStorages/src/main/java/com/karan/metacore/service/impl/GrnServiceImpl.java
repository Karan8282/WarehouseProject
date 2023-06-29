package com.karan.metacore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karan.metacore.model.Grn;
import com.karan.metacore.model.GrnDtl;
import com.karan.metacore.repo.GrnDtlRepository;
import com.karan.metacore.repo.GrnRepository;
import com.karan.metacore.service.IGrnService;

@Service
public class GrnServiceImpl implements IGrnService {

	@Autowired
	private GrnRepository repo;
	@Autowired
	private GrnDtlRepository dtlRepo;
	
	public String saveGrn(Grn grn) {
		return repo.save(grn).getId();
	}

	public List<Grn> getAllGrns() {
		return repo.findAll();
	}

	public Optional<Grn> getOneGrn(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void saveGrnDtl(GrnDtl dtl) {
		dtlRepo.save(dtl);
	}
	@Override
	public List<GrnDtl> getAllGrnDtlByGrnId(Integer grnId) {
		return dtlRepo.getAllGrnDtlByGrnId(grnId);
	}
	@Transactional
	public void updateGrnDtlStatusById(String status, Integer dtlId) {
		dtlRepo.updateGrnDtlStatusById(status, dtlId);
	}
}
