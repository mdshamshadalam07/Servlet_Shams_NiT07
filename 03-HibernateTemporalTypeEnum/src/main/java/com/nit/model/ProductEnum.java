package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ProductEnum {
	
		@Id
		@Column(name="pid")
		private Integer prod1Id;
		@Column(name="pcode")
		private String prod1Code;
		@Temporal(TemporalType.DATE)
		private Date mfgDate;
		@Temporal(TemporalType.TIMESTAMP)
		private Date ExpDate;
		@Temporal(TemporalType.TIME)
		private Date TestSlot;
		public ProductEnum() {
			super();
		}
		public Integer getProd1Id() {
			return prod1Id;
		}
		public void setProd1Id(Integer prod1Id) {
			this.prod1Id = prod1Id;
		}
		public String getProd1Code() {
			return prod1Code;
		}
		public void setProd1Code(String prod1Code) {
			this.prod1Code = prod1Code;
		}
		public Date getMfgDate() {
			return mfgDate;
		}
		public void setMfgDate(Date mfgDate) {
			this.mfgDate = mfgDate;
		}
		public Date getExpDate() {
			return ExpDate;
		}
		public void setExpDate(Date expDate) {
			ExpDate = expDate;
		}
		public Date getTestSlot() {
			return TestSlot;
		}
		public void setTestSlot(Date testSlot) {
			TestSlot = testSlot;
		}
		@Override
		public String toString() {
			return "ProductEnum [prod1Id=" + prod1Id + ", prod1Code=" + prod1Code + ", mfgDate=" + mfgDate
					+ ", ExpDate=" + ExpDate + ", TestSlot=" + TestSlot + "]";
		}
		
}
