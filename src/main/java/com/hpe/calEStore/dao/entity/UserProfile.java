package com.hpe.calEStore.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * UserProfile generated by hbm2java
 */
@Entity
@Table(name = "user_profile", catalog = "eshop", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL_ID"))
public class UserProfile implements java.io.Serializable {

	private Integer userId;
	private Department department;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String mobileNumber;
	private String gender;
	private String profileInd;
	private Date createdDate;
	private String statusInd;
	private Date endDate;
	private String emailPrefInd;
	private String smsPrefInd;
	private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	public UserProfile() {
		// Do nothing... Hibernate needs this mandatory
	}

	public UserProfile(Department department, String firstName,
			String lastName, String emailId, String password,
			String mobileNumber, String gender, String profileInd,
			Date createdDate, String statusInd, String emailPrefInd,
			String smsPrefInd) {
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.profileInd = profileInd;
		this.createdDate = createdDate;
		this.statusInd = statusInd;
		this.emailPrefInd = emailPrefInd;
		this.smsPrefInd = smsPrefInd;
	}

	public UserProfile(Department department, String firstName,
			String lastName, String emailId, String password,
			String mobileNumber, String gender, String profileInd,
			Date createdDate, String statusInd, Date endDate,
			String emailPrefInd, String smsPrefInd,
			Set<PurchaseOrder> purchaseOrders, Set<Address> addresses) {
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.profileInd = profileInd;
		this.createdDate = createdDate;
		this.statusInd = statusInd;
		this.endDate = endDate;
		this.emailPrefInd = emailPrefInd;
		this.smsPrefInd = smsPrefInd;
		this.purchaseOrders = purchaseOrders;
		this.addresses = addresses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false, length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL_ID", unique = true, nullable = false, length = 30)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "MOBILE_NUMBER", nullable = false, length = 15)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "GENDER", nullable = false, length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "PROFILE_IND", nullable = false, length = 2)
	public String getProfileInd() {
		return this.profileInd;
	}

	public void setProfileInd(String profileInd) {
		this.profileInd = profileInd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "STATUS_IND", nullable = false, length = 2)
	public String getStatusInd() {
		return this.statusInd;
	}

	public void setStatusInd(String statusInd) {
		this.statusInd = statusInd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "EMAIL_PREF_IND", nullable = false, length = 2)
	public String getEmailPrefInd() {
		return this.emailPrefInd;
	}

	public void setEmailPrefInd(String emailPrefInd) {
		this.emailPrefInd = emailPrefInd;
	}

	@Column(name = "SMS_PREF_IND", nullable = false, length = 2)
	public String getSmsPrefInd() {
		return this.smsPrefInd;
	}

	public void setSmsPrefInd(String smsPrefInd) {
		this.smsPrefInd = smsPrefInd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public Set<PurchaseOrder> getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
