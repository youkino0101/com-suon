package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service;

import java.util.List;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.TypeCustomer;

public interface TypeCustomerService {
	List<TypeCustomer> getAll();
	void save(TypeCustomer typeCustomer);
}
