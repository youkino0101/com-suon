package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productTags")
public class ProductTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "productTagName")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
}
