package com.karan.metacore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.metacore.model.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

}
