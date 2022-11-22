package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "typeCustomers")
public class TypeCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "typeCustomer")
	@NotNull(message = "không được để trống!!!")
	private String name;
	
	@OneToMany(mappedBy = "typeCustomer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Customer> customerList;

	public TypeCustomer() {
		super();
	}

	public TypeCustomer(int id, String name, List<Customer> customerList) {
		super();
		this.id = id;
		this.name = name;
		this.customerList = customerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
}
