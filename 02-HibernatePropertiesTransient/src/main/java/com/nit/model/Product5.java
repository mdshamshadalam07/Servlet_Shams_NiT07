package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product5 {
	@Id
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pcode")
	private String prodCode;
	@Column(name="pcost")
	private Double prodCost;
	@Column(name="pgst")
	private Double prodGst;
	public Product5() {
		super();
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public Double getProdGst() {
		return prodGst;
	}
	public void setProdGst(Double prodGst) {
		this.prodGst = prodGst;
	}
	@Override
	public String toString() {
		return "Product5 [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", prodGst="
				+ prodGst + "]";
	}
}