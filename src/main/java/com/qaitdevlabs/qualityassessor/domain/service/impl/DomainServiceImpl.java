package com.qaitdevlabs.qualityassessor.domain.service.impl;

import java.util.*;

import com.qaitdevlabs.qualityassessor.dto.DomainDTO;
import com.qaitdevlabs.qualityassessor.util.CustomDomainComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qaitdevlabs.qualityassessor.domain.dao.DomainDao;
import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.TreeNodeDTO;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.DomainMapping;

/**
 * 
 * @author anujchhabra
 * 
 */
@Service
public class DomainServiceImpl implements DomainService {

	private DomainDao domainDao;

	@Autowired
	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}

	@Override
	public List<TreeNodeDTO> getDomainList(String key) {
		Long id = Long.valueOf(key);
		List<TreeNodeDTO> nodeList = null;
		if (id == 0) {
			nodeList = getTreeNodeDTO(domainDao.getDomainList());
		} else {
			nodeList = getTreeNodeDTO(domainDao.getSubDomainList(id));
		}
		Collections.sort(nodeList, new CustomDomainComparator());
		return nodeList;
	}

	@SuppressWarnings("rawtypes")
	private List<TreeNodeDTO> getTreeNodeDTO(List object) {

		List<TreeNodeDTO> domainsDto = new ArrayList<TreeNodeDTO>();
		if (object.get(0) instanceof Domain) {
			@SuppressWarnings("unchecked")
			List<Domain> domains = object;
			Iterator<Domain> it = domains.iterator();

			while (it.hasNext()) {

				Domain domain = (Domain) it.next();
				TreeNodeDTO dto = getTreeNodeDTO(domain);
				int noOfChildren = domainDao.getSubDomainList(
						domain.getDomainId()).size();
				System.out.println("domainid and children"
						+ domain.getDomainId() + " " + noOfChildren);

				if (noOfChildren > 0) {
					dto.setIsLazy("true");
					System.out.println("lazy" + true);
				}
				domainsDto.add(dto);

			}
		} else {

			@SuppressWarnings("unchecked")
			List<DomainMapping> domainMappings = object;
			Iterator<DomainMapping> it = domainMappings.iterator();

			while (it.hasNext()) {

				DomainMapping domainMapping = (DomainMapping) it.next();
				Domain subDomain = domainMapping.getSubDomain();
				Domain domain = domainMapping.getDomain();
				TreeNodeDTO dto = getTreeNodeDTO(subDomain);

				int noOfChildren = domainDao.getSubDomainList(
						subDomain.getDomainId()).size();
				System.out.println("domainid and children"
						+ subDomain.getDomainId() + " " + noOfChildren);

				if (noOfChildren > 0) {
					dto.setIsLazy("true");
					System.out.println("lazy" + true);
				}

				dto.setParentKey(String.valueOf(domain.getDomainId()));
				dto.setWeightage(String.valueOf(domainMapping.getWeightage()));
				domainsDto.add(dto);

			}
		}
		return domainsDto;
	}

	private TreeNodeDTO getTreeNodeDTO(Domain domain) {

		TreeNodeDTO dto = new TreeNodeDTO();
		dto.setKey(String.valueOf(domain.getDomainId()));
		dto.setTitle(domain.getDomainName());
		dto.setWikipediaLink(domain.getWikipediaLink());
		dto.setCreationDate(domain.getCreationDate());
		// dto.setCreationUserName(domain.getCreationUser().getUsername());
		// dto.setModificationUserName(domain.getModificationUser().getUsername());
		dto.setModificationDate(domain.getModificationDate());

		return dto;
	}

	@Override
	public void updateDomain(TreeNodeDTO dto) {

		Long key = Long.valueOf(dto.getKey());
		String parent = dto.getParentKey();

		if (parent.equals("null")) {

			Domain domain = domainDao.get(key);
			domain.setModificationDate(dto.getModificationDate());
			domain.setDomainName(dto.getTitle());
			// domain.getModificationUser()
			domain.setIsParent(true);
			domain.setIsActive(true);
			domainDao.saveOrUpdateDomain(domain);

		} else {

			Long parentKey = Long.valueOf(parent);
			String domainName = dto.getTitle();
			int weightage = Integer.valueOf(dto.getWeightage());
			Date modificationDate = dto.getModificationDate();

			DomainMapping domainMapping = domainDao.getDomainMapping(parentKey,
					key);
			domainMapping.setWeightage(weightage);
			domainMapping.setModificationDate(modificationDate);
			domainDao.saveOrUpdateDomainMapping(domainMapping);

			Domain domain = domainMapping.getSubDomain();
			domain.setModificationDate(modificationDate);
			domain.setDomainName(domainName);
			domainDao.saveOrUpdateDomain(domain);
		}
	}

	@Override
	public TreeNodeDTO saveDomain(TreeNodeDTO dto) {

		String parentKey = dto.getParentKey();
		Domain subDomain = new Domain();
		subDomain.setDomainName(dto.getTitle());
		subDomain.setCreationDate(dto.getCreationDate());
		subDomain.setModificationDate(dto.getCreationDate());
		// domain.setWikipediaLink(wikipediaLink);
		// domain.setCreationUser(creationUser);
		// domain.setModificationUser(modificationUser);
		subDomain.setIsActive(true);
		if (parentKey.equals("null")) {
			System.out.println("null parent");
			subDomain.setIsParent(true);
			domainDao.saveOrUpdateDomain(subDomain);
		} else {
			subDomain.setIsParent(false);
			Long parentId = Long.valueOf(parentKey);
			int weightage = Integer.valueOf(dto.getWeightage());
			Domain domain = domainDao.get(parentId);
			DomainMapping domainMapping = new DomainMapping();
			domainMapping.setSubDomain(subDomain);
			domainMapping.setDomain(domain);
			domainMapping.setCreationDate(dto.getCreationDate());
			domainMapping.setModificationDate(dto.getCreationDate());
			domainMapping.setWeightage(weightage);
			domainDao.saveOrUpdateDomainMapping(domainMapping);
		}
		dto.setKey(String.valueOf(subDomain.getDomainId()));
		return dto;
	}

	@Override
	public boolean deleteDomain(String parentKey, String key) {
		boolean success = false;
		Long domainId = Long.valueOf(key);
		Long parentDomainId = null;

		if (parentKey.equals("null")) {

			Domain domain = domainDao.get(domainId);
			domain.setIsParent(false);
			domainDao.saveOrUpdateDomain(domain);
			success = true;
		} else {

			parentDomainId = Long.valueOf(parentKey);
			success = domainDao.deleteDomainMapping(parentDomainId, domainId);
		}
		return success;

	}

	@Override
	public int getRemainingWeightageInDomain(String domainKey) {
		Long domainId = Long.valueOf(domainKey);
		List<DomainMapping> domainMappings = domainDao
				.getSubDomainList(domainId);
		Iterator<DomainMapping> it = domainMappings.iterator();
		int totalSubDomainWeightage = 0;
		int remainingWeightage = 0;
		while (it.hasNext()) {
			DomainMapping domainMapping = (DomainMapping) it.next();
			totalSubDomainWeightage += domainMapping.getWeightage();
		}
		remainingWeightage = 100 - totalSubDomainWeightage;
		return remainingWeightage;
	}

	@Override
	public List<DomainDTO> getSubDomains(String key) {
		Long id = Long.valueOf(key);
		List<DomainDTO> list = new ArrayList<DomainDTO>();
		List<DomainMapping> domainMappings = domainDao.getSubDomainList(id);
		Iterator<DomainMapping> it = domainMappings.iterator();
		while (it.hasNext()) {
			DomainDTO dto = new DomainDTO();
			DomainMapping domainMapping = (DomainMapping) it.next();
			String domainName = domainMapping.getSubDomain().getDomainName();
			String weightage = String.valueOf(domainMapping.getWeightage());
			dto.setName(domainName);
			dto.setWeightage(weightage);
			list.add(dto);
		}
		return list; // To change body of implemented methods use File |
						// Settings | File Templates.
	}

	@Override
	public List<DomainDTO> getListOfRootDomains() {
		List<DomainDTO> listOfRootDomains = null;
		List<Domain> domains = domainDao.getDomainList();
		if (domains.size() > 0) {
			listOfRootDomains = new ArrayList<DomainDTO>();
			Iterator<Domain> domainList = domains.iterator();
			while (domainList.hasNext()) {
				Domain domain = (Domain) domainList.next();
				DomainDTO dto = new DomainDTO();
				dto.setId(String.valueOf(domain.getDomainId()));
				dto.setName(domain.getDomainName());
				listOfRootDomains.add(dto);
			}

		}
		return listOfRootDomains;
	}

//	public TreeNodeDTO getDomainHierarchy(Long id) {
//		Domain domain = (Domain) domainDao.get(id);
//		TreeNodeDTO node = getTreeNodeDTO(domain);
//		node.setChildren(getChildNodes(node, id));
//		return node;
//
//	}

//	public List<TreeNodeDTO> getChildNodes(TreeNodeDTO node, Long id) {
//
//		List<DomainMapping> subDomainMappingList = domainDao
//				.getSubDomainList(id);
//		Iterator<DomainMapping> it = subDomainMappingList.iterator();
//		while (it.hasNext()) {
//			List children = new ArrayList();
//			DomainMapping domainMapping = (DomainMapping) it.next();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
//			TreeNodeDTO child = getTreeNodeDTO(domainMapping.getDomain());
//			node.setChildren(getChildNodes(child, domainMapping.getDomain()
//					.getDomainId()));
//		}
//
//		return chidNodes;
//	}

	/*
	 * @Override public Domain get(Long id) { return domainDao.get(id); }
	 */
	/*
	 * private List<TreeNodeDTO> getTreeNodeDTO( List<DomainMapping>
	 * domainsMapping) { Iterator<DomainMapping> it = domainsMapping.iterator();
	 * List<TreeNodeDTO> domainsDto = new ArrayList<TreeNodeDTO>(); while
	 * (it.hasNext()) { DomainMapping domainMapping = (DomainMapping) it.next();
	 * TreeNodeDTO dto = new TreeNodeDTO(); Domain domain =
	 * domainMapping.getSubDomain();
	 * dto.setKey(String.valueOf(domain.getDomainId()));
	 * dto.setTitle(domain.getDomainName());
	 * dto.setWikipediaLink(domain.getWikipediaLink());
	 * dto.setCreationDate(domain.getCreationDate());
	 * dto.setCreationUserName(domain.getCreationUser().getUsername());
	 * dto.setModificationUserName(domain.getModificationUser().getUsername());
	 * dto.setModificationDate(domain.getModificationDate());
	 * domainsDto.add(dto); } return domainsDto; }
	 */
}
