package com.project.BankApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Log {
    @Id
    private Long id;
    private String transacType;
    private String transacStatus;
    private int initBal;
    private int finalBal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public int getInitBal() {
		return initBal;
	}
	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}
	public int getFinalBal() {
		return finalBal;
	}
	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}
	public Log(Long id, String transacType, String transacStatus, int initBal, int finalBal) {
		super();
		this.id = id;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", transacType=" + transacType + ", transacStatus=" + transacStatus + ", initBal="
				+ initBal + ", finalBal=" + finalBal + "]";
	}
    
}
