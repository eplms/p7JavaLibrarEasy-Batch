package com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models;

public class UserEntity {
	private Long userId;
	private String userLastName;
	private String userFirstName;
	private String userPhoneNumber;
	private String userEmail;
	private String userPassword;
	
	public UserEntity() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userLastName=" + userLastName + ", userFirstName=" + userFirstName
				+ ", userPhoneNumber=" + userPhoneNumber + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ "]";
	}
}
