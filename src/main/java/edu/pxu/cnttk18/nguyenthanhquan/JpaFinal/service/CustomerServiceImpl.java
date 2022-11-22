package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.Customer;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	@Override
	public void remove(Integer id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return customerRepository.findAll(pageable);
	}

	@Override
	public Page<Customer> findAllByFullNameContaining(String fullName, Pageable pageable) {
		// TODO Auto-generated method stub
		return customerRepository.findAllByFullNameContaining(fullName, pageable);
	}

	@Override
	public void save(Customer artist) {
		customerRepository.save(artist);
	}
}
