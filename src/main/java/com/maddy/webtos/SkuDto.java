package com.maddy.webtos;

public class SkuDto extends BaseDto {

	
	private Integer skuId;
	private String purchaseLink;
	private Boolean isActive;
    private Integer bagId;
    private Integer shoeId;
	
	
	
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	public String getPurchaseLink() {
		return purchaseLink;
	}
	public void setPurchaseLink(String purchaseLink) {
		this.purchaseLink = purchaseLink;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getBagId() {
		return bagId;
	}
	public void setBagId(Integer bagId) {
		this.bagId = bagId;
	}
	public Integer getShoeId() {
		return shoeId;
	}
	public void setShoeId(Integer shoeId) {
		this.shoeId = shoeId;
	}
	
	
	
	
	
}
