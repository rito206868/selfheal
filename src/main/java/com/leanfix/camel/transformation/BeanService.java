package com.leanfix.camel.transformation;

import java.util.Arrays;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leanfix.data.model.LabRecord;
import com.leanfix.data.model.PatientRecord;
import com.leanfix.data.model.Source;

@Component
public class BeanService implements Processor {

	private Logger log = LoggerFactory.getLogger(BeanService.class);
	DozerBeanMapper mapper = new DozerBeanMapper();
	final ObjectMapper jsonmapper = new ObjectMapper();

	/**
	 * 
	 */
	public void process(Exchange exchange) throws Exception {

		// getting the request object
		String body = (String) exchange.getIn().getBody(String.class);
		jsonmapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		final Source source = jsonmapper.readValue(body, Source.class);
		log.info(source.getInternalID());
		log.info(source.getName());

		configureMapper("patientInfo-mapper.xml");
		PatientRecord patientRecord = mapper.map(source, PatientRecord.class);

		configureMapper("labInfo-mapper.xml");
		LabRecord labRecord = mapper.map(source, LabRecord.class);

		log.info("Patient-> " + patientRecord.getName() + ", Department-> " + labRecord.getDepartment()
				+ ", Uniqueue Reference ID-> " + patientRecord.getInternalID() + ", Upload Status-> Successful");
		exchange.getIn().setBody(labRecord);

	}

	/**
	 * 
	 * @param mappingFileUrls
	 */
	public void configureMapper(String... mappingFileUrls) {
		mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
	}

}
