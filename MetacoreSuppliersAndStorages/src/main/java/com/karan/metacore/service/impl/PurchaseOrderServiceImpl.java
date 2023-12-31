package com.karan.metacore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karan.metacore.model.PurchaseDtl;
import com.karan.metacore.model.PurchaseOrder;
import com.karan.metacore.repo.PurchaseDtlRepository;
import com.karan.metacore.repo.PurchaseOrderRepository;
import com.karan.metacore.service.IPurchaseOrderService;
import com.karan.metacore.util.AppUtil;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository repo;
	
	@Autowired
	private PurchaseDtlRepository dtlRepo;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return repo.save(po).getId();
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return repo.findAll();
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return repo.findById(id).get();
	}
	
	//screen#2 methods
	@Override
	public void addPoPart(PurchaseDtl purchaseDtl) {
		dtlRepo.save(purchaseDtl);
	}
	
	@Override
	public List<PurchaseDtl> getPurchaseDtlByOrderId(Integer orderId) {
		return dtlRepo.getPurchaseDtlByOrderId(orderId);
	}
	@Override
	public void deletePurchaseDtl(Integer dtlId) {
		dtlRepo.deleteById(dtlId);
	}
	@Transactional
	public void updatePoStatusByOrderId(String orderStatus, Integer orderId) {
		repo.updatePoStatusByOrderId(orderStatus, orderId);
	}
	
	@Override
	public Integer getCountOfItemsByOrderId(Integer orderId) {
		return dtlRepo.getCountOfItemsByOrderId(orderId);
	}
	
	@Override
	public String getStatusByOrderId(Integer orderId) {
		return repo.getStatusByOrderId(orderId);
	}
	
	@Override
	public Optional<Integer> getPurchaseDtlByPartIdAndPoId(Integer partId, Integer orderId) {
		return dtlRepo.getPurchaseDtlByPartIdAndPoId(partId, orderId);
	}
	
	@Transactional
	public void updatePurchaseDtlQtyByDtlId(Integer dtlId, Integer newQty) {
		dtlRepo.updatePurchaseDtlQtyByDtlId(dtlId, newQty);
	}
	
	@Override
	public Map<Integer, String> getPoOrderIdAndCode(String status) {
		List<Object[]> list = repo.getPoOrderIdAndCode(status);
		return AppUtil.convertToMap(list);
	}
	
}
