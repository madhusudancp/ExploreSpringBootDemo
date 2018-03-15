package com.maddy.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8886492139752075823L;

	//private static final long serialVersionUID = 1L;
/*	@Column(name = "DB_CREATED_DATETIME",nullable=true, insertable = false, updatable = false)  
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;
	@Column(name = "DB_MODIFIED_DATETIME",nullable=true, insertable = false, updatable = false)  
    @Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDateTime;
	
	
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}*/
	
	
	

}
