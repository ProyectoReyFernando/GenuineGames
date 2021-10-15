package com.genuinegames.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;

public class UserDTO {

	@Column(name = "name")
	private String name;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "cpwd")
	private String cpwd;

	@Column(name = "tlf")
	private int tlf;

	@Column(name = "mail")
	private String mail;

	@Column(name = "fnac")
	private Date fnac;

	@Column(name = "sex")
	private String sex;

	public UserDTO() {
		super();
	}

	public UserDTO(String name, String pwd, String cpwd, int tlf, String mail, Date fnac, String sex) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.cpwd = cpwd;
		this.tlf = tlf;
		this.mail = mail;
		this.fnac = fnac;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
