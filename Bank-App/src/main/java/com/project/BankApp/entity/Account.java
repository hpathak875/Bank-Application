package com.project.BankApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="bank")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="accountHolderName")
    private String accountHolderName;
    @Column(name="acctNo",unique = true)
    private String acctNo;
    @Column(name="phoneNo")
    private String phoneNo;
    @Column(name="email")
    private String email;
    @Column(name="balance")
    private double balance;
    @Column(name="status")
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long id, String accountHolderName, String acctNo, String phoneNo, String email, double balance,
			String status) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.acctNo = acctNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.balance = balance;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountHolderName=" + accountHolderName + ", acctNo=" + acctNo + ", phoneNo="
				+ phoneNo + ", email=" + email + ", balance=" + balance + ", status=" + status + "]";
	}
    
    
}