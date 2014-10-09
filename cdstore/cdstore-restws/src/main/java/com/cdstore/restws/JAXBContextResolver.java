package com.cdstore.restws;

import java.util.List;

import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.restws.model.CdDriveJsonModel;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/*@Provider
 public class JAXBContextResolver implements ContextResolver<JAXBContext> {
 private JAXBContext context;
 private Class[] types = { CdDrive.class };

 public JAXBContextResolver() throws Exception {
 this.context = new JSONJAXBContext(JSONConfiguration.mapped()
 .arrays("employee").build(), types);
 }

 public JAXBContext getContext(Class<?> objectType) {
 System.out.println("TUG CALL");
 for (Class type : types) {
 if (type == objectType) {
 return context;
 }
 }
 return null;
 }
 }*/

@Provider
public class JAXBContextResolver implements ContextResolver<ObjectMapper> {
	final ObjectMapper defaultObjectMapper;
	final ObjectMapper combinedObjectMapper;

	public JAXBContextResolver() {
		defaultObjectMapper = createDefaultMapper();
		combinedObjectMapper = createCombinedObjectMapper();
	}

	public ObjectMapper getContext(final Class<?> type) {
		if (type == CdDriveJsonModel.class) {
			return combinedObjectMapper;
		} else if (type == CdDrive.class) {
			return combinedObjectMapper;
		} else if (type == List.class) {
			return combinedObjectMapper;
		} else {
			return defaultObjectMapper;
		}
	}

	private static ObjectMapper createCombinedObjectMapper() {
		return new ObjectMapper()
				.configure(SerializationFeature.WRAP_ROOT_VALUE, true)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
				.setAnnotationIntrospector(
						createJaxbJacksonAnnotationIntrospector());
	}

	private static ObjectMapper createDefaultMapper() {
		final ObjectMapper result = new ObjectMapper();
		result.enable(SerializationFeature.INDENT_OUTPUT);
		return result;
	}

	private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {
		final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector(
				TypeFactory.defaultInstance());
		final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
		return AnnotationIntrospector.pair(jacksonIntrospector,
				jaxbIntrospector);
	}
}