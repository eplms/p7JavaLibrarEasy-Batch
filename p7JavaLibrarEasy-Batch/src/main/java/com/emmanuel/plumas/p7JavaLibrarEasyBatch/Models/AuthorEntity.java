package com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models;

public class AuthorEntity {
	private Long authorId;
	private String authorLastName;
	private String authorFirstName;
	
	public AuthorEntity() {
		super();
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	@Override
	public String toString() {
		return "AuthorEntity [authorId=" + authorId + ", authorLastName=" + authorLastName + ", authorFirstName="
				+ authorFirstName + "]";
	}
}
