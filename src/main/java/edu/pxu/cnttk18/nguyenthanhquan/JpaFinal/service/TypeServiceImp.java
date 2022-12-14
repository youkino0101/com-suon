package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.CustomerType;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository.CustomerTypeRepository;

@Service
public class TypeServiceImp implements TypeService {
	@Autowired
	private CustomerTypeRepository typeRepository;

	public List<CustomerType> getAll() {
		return typeRepository.findAll();
	}

}