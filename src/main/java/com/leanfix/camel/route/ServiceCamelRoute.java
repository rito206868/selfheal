package com.leanfix.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.leanfix.camel.transformation.BeanService;
import com.leanfix.data.model.Source;

/**
 * 
 * @author r.a.chakraborty
 *
 */
@Component
public class ServiceCamelRoute extends RouteBuilder {

	@Value("${rest.post.url}")
	String RESOLVER;

	@Autowired
	BeanService beanService;

	@Override
	public void configure() throws Exception {

		onException(HttpOperationFailedException.class).handled(false).end();

		/* ================API DOC URI Using Swagger================ */
		// http://localhost/camel/api-doc
		/* ================API URI===================== */
		// http://localhost/camel/api/selfheal

		restConfiguration()
				.component("servlet")
				.apiContextPath("/selfheal-api-doc")
				.apiProperty("api.title", "Self healing transformation Camel API")
				.apiProperty("api.version", "1.0")
				.apiProperty("cors", "true")
				.enableCORS(true)
				.bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true")
				.dataFormatProperty("json.in.disableFeatures", "FAIL_ON_EMPTY_BEANS");

		rest("/api")
				.post("/selfheal")
				.consumes("application/json")
				.description("Transformation API")
				.bindingMode(RestBindingMode.json)
				.type(Source.class)
				.to("direct:result");

		//Calling Mapping resolver service to fix input and validate parameters
		/*
		 * from("direct:validate") .streamCaching() .log(LoggingLevel.INFO, "${body}")
		 * .routeId("validate-source") .process(exchange -> { String jsonResponse =
		 * (String) exchange.getIn().getBody(String.class);
		 * exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
		 * exchange.getOut().setBody(jsonResponse); }).setHeader(Exchange.HTTP_METHOD,
		 * constant("POST")) .toD(RESOLVER + "?bridgeEndpoint=true")
		 * .to("direct:getDetail");
		 * 
		 * //Processing validated data with mapping to respective data model
		 * from("direct:getDetail") .routeId("data-processor") .streamCaching()
		 * .log(LoggingLevel.INFO, "${body}") .process("beanService")
		 * .removeHeaders("*") .to("direct:result");
		 */
		from("direct:result")
				.routeId("target")
				.streamCaching()
				.log(LoggingLevel.INFO, "${body}")
				.setBody().constant("Success:True")
				.log(LoggingLevel.INFO,"Completed");
	}
}
