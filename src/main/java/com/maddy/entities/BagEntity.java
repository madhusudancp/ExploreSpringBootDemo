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
@Table(name="BAG_T")
public class BagEntity extends ItemBaseEntity{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6034566040136712812L;
	
	public BagEntity(){
		
	}
	
	@Id
	@Column(name="BAGID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bagId;

	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="bag", orphanRemoval=true)
	@JoinTable(name="BAGS_SKUS", 
	  joinColumns=@JoinColumn(name="BAGID"),
	  inverseJoinColumns=@JoinColumn(name="SKUID"))
	private Set<SkuEntity> skus =  new HashSet<>();
	*/
	
	
	public Integer getBagId() {
		return bagId;
	}

	public void setBagId(Integer bagId) {
		this.bagId = bagId;
	}

/*	public Set<SkuEntity> getSkus() {
		return skus;
	}

	public void setSkus(Set<SkuEntity> skus) {
		this.skus = skus;
	}
*/
	
	
}
