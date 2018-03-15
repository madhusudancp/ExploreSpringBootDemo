package com.maddy.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class ItemBaseEntity extends BaseEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3552013768900003407L;
	@Column(name = "REFNAME",nullable=true)
    private String refName;
	@Column(name = "VERSION",nullable=true)
    private String version;
	@Column(name = "TYPE",nullable=true)
    private String type;
	
	
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
