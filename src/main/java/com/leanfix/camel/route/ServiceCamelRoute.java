package com.leanfix.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author r.a.chakraborty
 *
 */
@Component
public class ServiceCamelRoute extends RouteBuilder {


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
				.to("direct:result");

		
		from("direct:result")
				.routeId("target")
				.streamCaching()
				.setBody().constant("Success:True")
				.log(LoggingLevel.INFO,"Completed");
	}
}
