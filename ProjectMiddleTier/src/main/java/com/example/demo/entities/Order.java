package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pet_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderid;
	
	Date orderdate;
	
	String paymenttype;
	
	int amount;
	
	int transactionid;
	
	
	@OneToOne
	@JoinColumn(name="petid")
	Pet petid;
	
	@OneToOne
	@JoinColumn(name="sellerid")
	Seller sellerid;
	
	@OneToOne
	@JoinColumn(name="buyerid")
	Buyer buyerid;

	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Date orderdate, String paymenttype, int amount, int transactionid, Pet petid, Seller sellerid,
			Buyer buyerid) {
		super();
		this.orderdate = orderdate;
		this.paymenttype = paymenttype;
		this.amount= amount;
		this.transactionid = transactionid;
		this.petid = petid;
		this.sellerid = sellerid;
		this.buyerid = buyerid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Pet getPetid() {
		return petid;
	}

	public void setPetid(Pet petid) {
		this.petid = petid;
	}

	public Seller getSellerid() {
		return sellerid;
	}

	public void setSellerid(Seller sellerid) {
		this.sellerid = sellerid;
	}

	public Buyer getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Buyer buyerid) {
		this.buyerid = buyerid;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderdate=" + orderdate + ", paymenttype=" + paymenttype + ", price="
				+ amount + ", transactionid=" + transactionid + ", petid=" + petid + ", sellerid=" + sellerid
				+ ", buyerid=" + buyerid + "]";
	}

	
}
