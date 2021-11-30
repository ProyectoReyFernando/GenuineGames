package com.genuinegames.entity;

import java.io.Serializable;
import java.util.Collection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -2903057787229786019L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "tlf")
	private int tlf;

	@Column(name = "mail")
	private String mail;

	@Column(name = "fnac")
	private String fnac;

	@Column(name = "sex")
	private String sex;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;

	@OneToMany(mappedBy = "user")
	private Collection<Comments> comments;

	public User() {

	}

	public User(String username, String pwd, int tlf, String mail, String fnac, String sex, Role role,
			Collection<Comments> comments) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.tlf = tlf;
		this.mail = mail;
		this.fnac = fnac;
		this.sex = sex;
		this.role = role;
		this.comments = comments;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getFnac() {
		return fnac;
	}

	public void setFnac(String fnac) {
		this.fnac = fnac;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Comments> getComments() {
		return comments;
	}

	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}

}
