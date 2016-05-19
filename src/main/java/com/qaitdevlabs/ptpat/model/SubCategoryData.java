package com.qaitdevlabs.ptpat.model;

import java.io.Serializable;
import java.util.Date;

public class SubCategoryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String subCategoryRawData;

	private String subCategoryTargetData;

	private String subCategoryCalculatedData;

	private Date createdDate;

	private Date lastModifiedDate;

	private ProductCategory productCategory;

	private SubCategory subCategory;

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

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

}
