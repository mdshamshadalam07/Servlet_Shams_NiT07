package com.nit.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name="Custtab")
	public class Customer {
		@Id
		@Column(name="cid")
		private Integer CustId;
		@Column(name="cname")
		private String CustName;
		@Column(name="caddr")
		private String CustAddr;
		
		public Customer() {
			super();
		}
		
		public Integer getCustId() {
			return CustId;
		}
		public void setCustId(Integer CustId) {
			this.CustId = CustId;
		}
		public String getCustName() { return CustName;
		}
		public void setCustName(String CustName) { this.CustName = CustName;
		}
		public String getCustAddr() {
			return CustAddr;
		}
		public void setCustAddr(String CustAddr) {
			this.CustAddr = CustAddr;
		}
		@Override
		public String toString() { return "Student [CustId=" + CustId + ", CustName=" + CustName + ", CustAddr=" + CustAddr + "]";
		}
	}


