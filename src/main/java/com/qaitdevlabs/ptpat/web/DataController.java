package com.qaitdevlabs.ptpat.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.ptpat.dto.CategoryDTO;
import com.qaitdevlabs.ptpat.dto.DataDTO;
import com.qaitdevlabs.ptpat.dto.ProductCategoryDTO;
import com.qaitdevlabs.ptpat.dto.ProductDTO;
import com.qaitdevlabs.ptpat.dto.SubCategoryDTO;
import com.qaitdevlabs.ptpat.dto.SubCategoryDataDTO;
import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;
import com.qaitdevlabs.ptpat.service.ConnectorService;

@Controller
public class DataController {

	private ConnectorService connectorService;

	public ConnectorService getConnectorService() {
		return connectorService;
	}

	@Autowired
	public void setConnectorService(ConnectorService connectorService) {
		this.connectorService = connectorService;
	}

	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public String getProductList(DataDTO dataDTO, ModelMap model,
			HttpServletRequest request) {

		List<ProductDTO> productDtoList = new ArrayList<ProductDTO>();
		List<Product> productList = connectorService.fetchAllProducts();
		productDtoList = productModelToDto(productList, productDtoList);
		dataDTO.setProductDTOList(productDtoList);

		if (dataDTO.getSelectedProductId() != null) {
			List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
			List<Category> categoryList = connectorService
					.fetchAllCategoriesByProductId(dataDTO
							.getSelectedProductId());
			categoryDTOList = categoryModelToDto(categoryList, categoryDTOList);
			dataDTO.setCategoryDTOList(categoryDTOList);
		}

		if (dataDTO.getSelectedCategoryId() != null) {
			List<SubCategoryDTO> subCategoryDTOList = new ArrayList<SubCategoryDTO>();
			List<SubCategory> subCategoryList = connectorService
					.fetchAllSubCategoriesByProductAndCategoryId(
							dataDTO.getSelectedProductId(),
							dataDTO.getSelectedCategoryId());
			subCategoryDTOList = subCategoryModelToDto(subCategoryList,
					subCategoryDTOList);
			dataDTO.setSubCategoryDTOList(subCategoryDTOList);
		}

		if (dataDTO.getSelectedSubCategoryId() != null) {
			List<SubCategoryDataDTO> subCategoryDataDTOList = new ArrayList<SubCategoryDataDTO>();
			List<SubCategoryData> subCategoryDataList = connectorService
					.fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
							dataDTO.getSelectedProductId(),
							dataDTO.getSelectedCategoryId(),
							dataDTO.getSelectedSubCategoryId());
			subCategoryDataDTOList = subCategoryDataModelToDto(
					subCategoryDataList, subCategoryDataDTOList);

			dataDTO.setSubCategoryDataDTOList(subCategoryDataDTOList);
			for (SubCategoryDTO subCategoryDtoNew : dataDTO
					.getSubCategoryDTOList()) {
				if (subCategoryDtoNew.getSubCategoryId().longValue() == dataDTO
						.getSelectedSubCategoryId().longValue()) {
					dataDTO.setSelectedSubCategoryName(subCategoryDtoNew
							.getSubCategoryName());
				}

			}
		}

		model.addAttribute("dataDTO", dataDTO);
		return "productView";
	}

	private List<ProductDTO> productModelToDto(List<Product> productList,
			List<ProductDTO> productDtoList) {
		for (Product product : productList) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getProductId());
			productDTO.setProductCode(product.getProductCode());
			productDtoList.add(productDTO);
		}
		return productDtoList;
	}

	private List<CategoryDTO> categoryModelToDto(List<Category> categoryList,
			List<CategoryDTO> categoryDTOList) {
		for (Category category : categoryList) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			categoryDTOList.add(categoryDTO);
		}
		return categoryDTOList;
	}

	private List<SubCategoryDTO> subCategoryModelToDto(
			List<SubCategory> subCategoryList,
			List<SubCategoryDTO> subCategoryDTOList) {
		for (SubCategory subCategory : subCategoryList) {
			SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
			subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
			subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			subCategoryDTOList.add(subCategoryDTO);
		}
		return subCategoryDTOList;
	}
	
	private List<SubCategoryDataDTO> subCategoryDataModelToDto(
			List<SubCategoryData> subCategoryDataList,
			List<SubCategoryDataDTO> subCategoryDataDTOList) {
		for (SubCategoryData subCatData : subCategoryDataList) {
			SubCategoryDataDTO subCategoryDataDto = new SubCategoryDataDTO();
			subCategoryDataDto.setId(subCatData.getId());
			subCategoryDataDto.setCreatedDate(subCatData.getCreatedDate());
			subCategoryDataDto.setLastModifiedDate(subCatData
					.getLastModifiedDate());
			subCategoryDataDto.setSubCategoryCalculatedData(subCatData
					.getSubCategoryCalculatedData());
			subCategoryDataDto.setSubCategoryRawData(subCatData
					.getSubCategoryRawData());
			subCategoryDataDto.setSubCategoryTargetData(subCatData
					.getSubCategoryTargetData());

			SubCategoryDTO subCategoryDto = new SubCategoryDTO();
			subCategoryDto.setSubCategoryId(subCatData.getSubCategory()
					.getSubCategoryId());
			subCategoryDto.setSubCategoryName(subCatData.getSubCategory()
					.getSubCategoryName());
			subCategoryDataDto.setSubCategoryDTO(subCategoryDto);

			ProductDTO productDto = new ProductDTO();
			productDto.setId(subCatData.getProductCategory().getProduct()
					.getProductId());
			productDto.setProductCode(subCatData.getProductCategory()
					.getProduct().getProductCode());

			CategoryDTO categoryDto = new CategoryDTO();
			categoryDto.setCategoryId(subCatData.getProductCategory()
					.getCategory().getCategoryId());
			categoryDto.setCategoryName(subCatData.getProductCategory()
					.getCategory().getCategoryName());

			ProductCategoryDTO productCategoryDto = new ProductCategoryDTO();

			productCategoryDto.setProductCtegoryId(subCatData
					.getProductCategory().getProductCtegoryId());
			productCategoryDto.setCategoryDTO(categoryDto);
			productCategoryDto.setProductDTO(productDto);
			subCategoryDataDto.setProductCategoryDTO(productCategoryDto);
			subCategoryDataDTOList.add(subCategoryDataDto);
		}
		return subCategoryDataDTOList;
	}
	
}