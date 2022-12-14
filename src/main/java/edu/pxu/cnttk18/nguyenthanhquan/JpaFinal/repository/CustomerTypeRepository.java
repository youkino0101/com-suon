package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.CustomerType;

@Repository("customerTypeRepository")
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {

}