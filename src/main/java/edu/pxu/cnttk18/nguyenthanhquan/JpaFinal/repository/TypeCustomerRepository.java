package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.TypeCustomer;

@Repository("typeCustomerRepository")
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer, Integer>{

}
