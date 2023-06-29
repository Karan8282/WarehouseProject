package com.karan.metacore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="wh_user_type_tab")
public class WhUserType {
	
	@Id
	@GeneratedValue(generator = "wh_usr_gen")
	@SequenceGenerator(name = "wh_usr_gen", sequenceName = "wh_usr_gen_seq")
	@Column(name="wh_usr_id_col")
	private Integer id;
	
	@Column(name="wh_usr_type_col", length = 10, nullable = false)
	private String userType;
	
	@Column(name="wh_usr_code_col", length = 10,unique = true, nullable = false)
	private String userCode;
	
	@Column(name="wh_usr_for_col")
	private String userFor;
	
	@Column(name="wh_usr_email_col",unique = true, nullable = false)
	private String userEmail;
	
	@Column(name="wh_usr_contact_col", length = 100)
	private String userContact;
	
	@Column(name="wh_usr_id_type_col", nullable = false)
	private String userIdType;
	
	@Column(name="wh_usr_if_other_col")
	private String userIfOther;
	
	@Column(name="wh_usr_id_num_col", unique = true, nullable = false)
	private String userIdNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getUserIfOther() {
		return userIfOther;
	}

	public void setUserIfOther(String userIfOther) {
		this.userIfOther = userIfOther;
	}

	public String getUserIdNum() {
		return userIdNum;
	}

	public void setUserIdNum(String userIdNum) {
		this.userIdNum = userIdNum;
	}
	
	
}
