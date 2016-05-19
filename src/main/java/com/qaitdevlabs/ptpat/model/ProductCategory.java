package com.qaitdevlabs.ptpat.model;

import java.io.Serializable;
import java.util.Date;

public class ProductCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productCtegoryId;

	private Product product;

	private Category category;

	private String categoryRawData;

	private String categoryTargetData;

	private Date createdDate;

	private Date lastModifiedDate;

	public Long getProductCtegoryId() {
		return productCtegoryId;
	}

	public void setProductCtegoryId(Long productCtegoryId) {
		this.productCtegoryId = productCtegoryId;
	}

	public String getCategoryRawData() {
		return categoryRawData;
	}

	public void setCategoryRawData(String categoryRawData) {
		this.categoryRawData = categoryRawData;
	}

	public String getCategoryTargetData() {
		return categoryTargetData;
	}

	public void setCategoryTargetData(String categoryTargetData) {
		this.categoryTargetData = categoryTargetData;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
