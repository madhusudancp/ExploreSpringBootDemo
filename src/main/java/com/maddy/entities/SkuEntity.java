package com.maddy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SKU_T")
public class SkuEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8362711847603020755L;

	public SkuEntity(){
		
	}
	
	
	@Id
	@Column(name="SKUID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer skuId;
	
	@Column(name="ISACTIVE",nullable = false, columnDefinition = "BIT", length = 1)
	private boolean isActive = false;
	
	@Column(name="PURCHASELINK")
	private String purchaseLink;
	
	  
	/*@ManyToOne(cascade=CascadeType.MERGE)
	*/
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="BAGID",referencedColumnName="BAGID",nullable=true)
	private BagEntity bag ;
	  
	/*@ManyToOne(cascade=CascadeType.MERGE)
	*/
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SHOEID",referencedColumnName="SHOEID",nullable=true)
	private ShoeEntity shoe ;
	  
	
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPurchaseLink() {
		return purchaseLink;
	}
	public void setPurchaseLink(String purchaseLink) {
		this.purchaseLink = purchaseLink;
	}
	public BagEntity getBag() {
		return bag;
	}
	public void setBag(BagEntity bag) {
		this.bag = bag;
	}
	/*public Set<BagEntity> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<BagEntity> departments) {
		this.departments = departments;
	}*/
	public ShoeEntity getShoe() {
		return shoe;
	}
	public void setShoe(ShoeEntity shoe) {
		this.shoe = shoe;
	}
	
	
}
