package com.maddy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SHOE_T")
public class ShoeEntity extends ItemBaseEntity{

	
	private static final long serialVersionUID = 6034566040136712812L;
	
	public ShoeEntity(){
		
	}
	
	@Id
	@Column(name="SHOEID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shoeId;

	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="bag", orphanRemoval=true)
	@JoinTable(name="SHOES_SKUS", 
	  joinColumns=@JoinColumn(name="SHOEID"),
	  inverseJoinColumns=@JoinColumn(name="SKUID"))
	private Set<SkuEntity> skus =  new HashSet<>();*/

	public Integer getShoeId() {
		return shoeId;
	}

	public void setShoeId(Integer shoeId) {
		this.shoeId = shoeId;
	}

	/*public Set<SkuEntity> getSkus() {
		return skus;
	}

	public void setSkus(Set<SkuEntity> skus) {
		this.skus = skus;
	}
*/	
	
	
	
	
	
}
