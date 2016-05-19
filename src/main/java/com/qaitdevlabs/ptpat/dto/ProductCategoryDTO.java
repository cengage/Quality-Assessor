package com.qaitdevlabs.ptpat.dto;

import java.util.Date;

public class ProductCategoryDTO{
	
	private Long productCtegoryId;

	private ProductDTO productDTO;

	private CategoryDTO categoryDTO;

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

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
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
	
	
}