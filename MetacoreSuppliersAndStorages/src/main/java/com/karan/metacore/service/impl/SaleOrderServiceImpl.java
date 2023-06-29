package com.karan.metacore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karan.metacore.model.SaleDtl;
import com.karan.metacore.model.SaleOrder;
import com.karan.metacore.repo.SaleDtlRepo;
import com.karan.metacore.repo.SaleOrderRepository;
import com.karan.metacore.service.ISaleOrderService;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private SaleOrderRepository repo;
	@Autowired
	private SaleDtlRepo dtlRepo;

	@Override
	@Transactional()
	public Integer saveSaleOrder(SaleOrder order) {
		return repo.save(order).getId();
	}

	@Override
	@Transactional()
	public void updateSaleOrder(SaleOrder order) {
		repo.save(order);
	}

	@Override
	@Transactional()
	public void deleteSaleOrder(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SaleOrder> getOneSaleOrder(Integer id) {
		return repo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaleOrder> getAllSaleOrders() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isSaleOrderExist(Integer id) {
		return repo.existsById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isSaleOrderCodeExist(String orderCode) {
		return repo.getOrderCodeCount(orderCode) > 0 ? true : false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getStockModeCount() {
		return repo.getstockModeCount();
	}

	/**
	 * Screen#2 Service
	 */
	@Override
	@Transactional
	public Integer addPartToSo(SaleDtl dtl) {
		return dtlRepo.save(dtl).getId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaleDtl> getSaleDtlWithSoId(Integer saleId) {
		return dtlRepo.getSaleDtlWithSoId(saleId);
	}

	@Override
	@Transactional
	public void deleteSaleDtl(Integer id) {
		dtlRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void updateSaleOrderStatus(String status, Integer id) {
		repo.updateSaleOrderStatus(status, id);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getSaleDtlCountWithSoId(Integer saleId) {
		return dtlRepo.getSaleDtlCountWithSoId(saleId);
	}

	@Override
	public Map<Integer, String> getSoIdAndCodeByStatus(String status) {
		return repo.getSoIdAndCodeByStatus(status).stream()
				.collect(Collectors.toMap(ob -> Integer.valueOf(ob[0].toString()), ob -> ob[1].toString()));
	}
}
