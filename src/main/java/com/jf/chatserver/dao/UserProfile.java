package com.jf.chatserver.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_PROFILE")
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="NICK_NAME")
	private String nickName;
	@Column(name="PASSWORD")
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_EMAILS" , joinColumns=@JoinColumn(name="USER_ID"))	
	private Set<String> emailIds = new HashSet<String>();
	@Column(name="CELL_PHONE")
	private String cellPh;
	@Column(name="HOME_PHONE")
	private String resPh;
	@Column(name="WORK_PHONE")
	private String workPh;
	@Column(name="DOB")
	private Date birthDate;
	@Column(name="MALE")
	private boolean isMale;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<String> getEmailIds() {
		return emailIds;
	}
	public void setEmailIds(Set<String> emailIds) {
		this.emailIds = emailIds;
	}
	public String getCellPh() {
		return cellPh;
	}
	public void setCellPh(String cellPh) {
		this.cellPh = cellPh;
	}
	public String getResPh() {
		return resPh;
	}
	public void setResPh(String resPh) {
		this.resPh = resPh;
	}
	public String getWorkPh() {
		return workPh;
	}
	public void setWorkPh(String workPh) {
		this.workPh = workPh;
	}
	//TODO: format date
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userName=" + userName
				+ ", nickName=" + nickName + ", password=" + password
				+ ", emailIds=" + emailIds + ", cellPh=" + cellPh + ", resPh="
				+ resPh + ", workPh=" + workPh + ", birthDate=" + birthDate
				+ ", isMale=" + isMale + "]";
	}	

}
