package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.TypeCustomer;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository.TypeCustomerRepository;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService{
	
	@Autowired
	private TypeCustomerRepository typeCustomerRepository;
	
	@Override
	public List<TypeCustomer> getAll() {
		return typeCustomerRepository.findAll();
	}

	@Override
	public void save(TypeCustomer typeCustomer) {
		
		typeCustomerRepository.save(typeCustomer);
	}

}
