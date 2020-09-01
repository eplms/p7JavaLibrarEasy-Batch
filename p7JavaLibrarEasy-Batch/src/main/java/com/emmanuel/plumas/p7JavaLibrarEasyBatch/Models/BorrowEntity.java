package com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models;

import java.util.Date;

public class BorrowEntity {

	private Long borrowId;
	private Date startDate;
	private Date endDate;
	private CopyEntity copyEntity;
	private UserEntity userEntity;
	private Boolean isExtended;
	private Boolean isReturned; 
	
	public BorrowEntity() {
		super();
	}

	public Long getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Long borrowId) {
		this.borrowId = borrowId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CopyEntity getCopyEntity() {
		return copyEntity;
	}

	public void setCopyEntity(CopyEntity copyEntity) {
		this.copyEntity = copyEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Boolean getIsExtended() {
		return isExtended;
	}

	public void setIsExtended(Boolean isExtended) {
		this.isExtended = isExtended;
	}

	public Boolean getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(Boolean isReturned) {
		this.isReturned = isReturned;
	}
	
	@Override
	public String toString() {
		return "BorrowEntity [borrowId=" + borrowId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", copyEntity=" + copyEntity + ", userEntity=" + userEntity + ", isExtended=" + isExtended + ", isReturned=" + isReturned + "]";
	}

}
