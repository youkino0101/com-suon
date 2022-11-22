package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
	Page<Customer> findAllByFullNameContaining(String fullName, Pageable pageable);
}