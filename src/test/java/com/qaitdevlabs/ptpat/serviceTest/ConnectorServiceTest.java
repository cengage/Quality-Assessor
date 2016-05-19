package com.qaitdevlabs.ptpat.serviceTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.qaitdevlabs.ptpat.connector.JenkinsParseConnector;
import com.qaitdevlabs.ptpat.service.impl.GenericServiceImpl;

public class ConnectorServiceTest {
	private java.util.List emptyList;

	public GenericServiceImpl genericService;

	@Before
	public void setup() {
		genericService = new GenericServiceImpl();
		emptyList = new java.util.ArrayList();
	}

	@Test
	public final void testXmlAsInputStream() throws SAXException, IOException,
			ParserConfigurationException {
		DocumentBuilder dBuilder = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();

			dBuilder = dbFactory.newDocumentBuilder();

			InputStream inputStream = ConnectorServiceTest.class
					.getResourceAsStream("/com/qaitdevlabs/ptpat/customXml/JenkinsConfigFile.xml");
			Document doc = dBuilder.parse(inputStream);
			NodeList nodeList = doc.getElementsByTagName("project");
			String tagName = "project";
			List<Object> objList = genericService
					.fetchAndParseXmlAsInputStream(inputStream, tagName);
			Assert.assertEquals(doc, objList.get(0));
			Assert.assertEquals(nodeList, objList.get(1));
		} finally {

		}
	}

	@Test
	public final void testXmlAsUrl() {
		try {
			String url = null, tagName = null;
			System.out.println(url);
		} finally {

		}
	}
}
