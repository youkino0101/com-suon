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
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "birthDay")
	private String birthDay;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "phone")		
	//@Pattern(regexp = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/", message = "Số điện thoại sai định dạng!")
	private String phone;
	
	@Column(name = "number_card")
	private String numberCard;
	
	@Email(message = "email không đúng định dạng") 
	private String email;
	
	@Column(name = "address")
	@NotEmpty(message = "Vui lòng nhập địa chỉ!")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="customerType", nullable=false)
	private CustomerType customerType;

	public Customer() {
		super();
	}

	public Customer(long id, String fullName, String birthDay, String sex, String phone, String numberCard,
			String email, String address, CustomerType customerType) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.sex = sex;
		this.phone = phone;
		this.numberCard = numberCard;
		this.email = email;
		this.address = address;
		this.customerType = customerType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
}
