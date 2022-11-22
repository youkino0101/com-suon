package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.Customer;

public interface CustomerService {

	Customer findById(Integer id);

	void remove(Integer id);

	Page<Customer> findAll(Pageable pageable);

	Page<Customer> findAllByFullNameContaining(String fullName, Pageable pageable);

	void save(Customer customer);

}

