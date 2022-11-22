package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nameCustomer")
	@NotNull(message = "không được để trống!!!")
	private String fullName;
	
	@Email(message = "email của m ko đúng m phải ghi như thế này này username@smtp.domain")
	@Column(nullable = true, length = 100)
	private String email;
	
	// @Pattern(regexp = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/", message = "Số điện Thoại ko đúngs")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="typeCustomer_id", nullable=false)
	private TypeCustomer typeCustomer;

	public Customer() {
		super();
	}

	public Customer(int id, String fullName, String email, String phone, TypeCustomer typeCustomer) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.typeCustomer = typeCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TypeCustomer getTypeCustomer() {
		return typeCustomer;
	}

	public void setTypeCustomer(TypeCustomer typeCustomer) {
		this.typeCustomer = typeCustomer;
	}
	
	
}
