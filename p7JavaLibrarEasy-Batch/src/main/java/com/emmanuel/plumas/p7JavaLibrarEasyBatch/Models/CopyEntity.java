package com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models;

public class CopyEntity {

	private Long copyId;
	private BookEntity bookEntity;
	
	public CopyEntity() {
		super();
	}

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public BookEntity getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}

	@Override
	public String toString() {
		return "CopyEntity [copyId=" + copyId + ", bookEntity=" + bookEntity + "]";
	}
	
}
