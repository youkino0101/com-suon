package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.Customer;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Long id) {
		return customerRepository.findById(id).get();
	}

	public void remove(Long id) {
		customerRepository.deleteById(id);
	}


	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public Page<Customer> findAllByFullNameContaining(String fullName, Pageable pageable) {
		return customerRepository.findAllByFullNameContaining(fullName, pageable);
	}

}
