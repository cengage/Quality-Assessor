package com.qaitdevlabs.ptpat.dto;

import java.util.Date;

public class SubCategoryDataDTO {

	private Long id;

	private String subCategoryRawData;

	private String subCategoryTargetData;

	private String subCategoryCalculatedData;

	private Date createdDate;

	private Date lastModifiedDate;

	private ProductCategoryDTO productCategoryDTO;

	private SubCategoryDTO subCategoryDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubCategoryRawData() {
		return subCategoryRawData;
	}

	public void setSubCategoryRawData(String subCategoryRawData) {
		this.subCategoryRawData = subCategoryRawData;
	}

	public String getSubCategoryTargetData() {
		return subCategoryTargetData;
	}

	public void setSubCategoryTargetData(String subCategoryTargetData) {
		this.subCategoryTargetData = subCategoryTargetData;
	}

	public String getSubCategoryCalculatedData() {
		return subCategoryCalculatedData;
	}

	public void setSubCategoryCalculatedData(String subCategoryCalculatedData) {
		this.subCategoryCalculatedData = subCategoryCalculatedData;
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

	public ProductCategoryDTO getProductCategoryDTO() {
		return productCategoryDTO;
	}

	public void setProductCategoryDTO(ProductCategoryDTO productCategoryDTO) {
		this.productCategoryDTO = productCategoryDTO;
	}

	public SubCategoryDTO getSubCategoryDTO() {
		return subCategoryDTO;
	}

	public void setSubCategoryDTO(SubCategoryDTO subCategoryDTO) {
		this.subCategoryDTO = subCategoryDTO;
	}

}