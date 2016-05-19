package com.qaitdevlabs.ptpat.dto;

import java.util.List;

public class DataDTO {

	private Long selectedProductId;
	private Long selectedCategoryId;
	private Long selectedSubCategoryId;
	private String selectedSubCategoryName;
	private List<ProductDTO> productDTOList;
	private List<CategoryDTO> categoryDTOList;
	private List<SubCategoryDTO> subCategoryDTOList;
	private List<SubCategoryDataDTO> subCategoryDataDTOList;

	public List<CategoryDTO> getCategoryDTOList() {
		return categoryDTOList;
	}

	public void setCategoryDTOList(List<CategoryDTO> categoryDTOList) {
		this.categoryDTOList = categoryDTOList;
	}

	public List<SubCategoryDTO> getSubCategoryDTOList() {
		return subCategoryDTOList;
	}

	public void setSubCategoryDTOList(List<SubCategoryDTO> subCategoryDTOList) {
		this.subCategoryDTOList = subCategoryDTOList;
	}

	public Long getSelectedCategoryId() {
		return selectedCategoryId;
	}

	public void setSelectedCategoryId(Long selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}

	public Long getSelectedSubCategoryId() {
		return selectedSubCategoryId;
	}

	public void setSelectedSubCategoryId(Long selectedSubCategoryId) {
		this.selectedSubCategoryId = selectedSubCategoryId;
	}

	public Long getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(Long selectedProductId) {
		this.selectedProductId = selectedProductId;
	}

	public List<ProductDTO> getProductDTOList() {
		return productDTOList;
	}

	public void setProductDTOList(List<ProductDTO> productDTOList) {
		this.productDTOList = productDTOList;
	}

	public List<SubCategoryDataDTO> getSubCategoryDataDTOList() {
		return subCategoryDataDTOList;
	}

	public void setSubCategoryDataDTOList(
			List<SubCategoryDataDTO> subCategoryDataDTOList) {
		this.subCategoryDataDTOList = subCategoryDataDTOList;
	}

	public String getSelectedSubCategoryName() {
		return selectedSubCategoryName;
	}

	public void setSelectedSubCategoryName(String selectedSubCategoryName) {
		this.selectedSubCategoryName = selectedSubCategoryName;
	}

}