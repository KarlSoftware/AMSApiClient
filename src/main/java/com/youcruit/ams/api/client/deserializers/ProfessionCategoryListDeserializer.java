package com.youcruit.ams.api.client.deserializers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.youcruit.ams.api.client.exceptions.MatchListProcessingException;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionCategoryList;

public final class ProfessionCategoryListDeserializer extends JsonDeserializer<ProfessionCategoryList> {
    private static final Class<ProfessionCategoryList> LIST_CLAZZ = ProfessionCategoryList.class;
    private static final Class<ProfessionCategory> TYPE_CLAZZ = ProfessionCategory.class;
    private static final String ARRAY_ELEMENT_TAG = "sokdata";

    @Override
    public ProfessionCategoryList deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	ProfessionCategoryList result = new ProfessionCategoryList();
	while (jp.nextToken() != null) {
	    if (jp.getCurrentToken().compareTo(JsonToken.FIELD_NAME) == 0) {
		if (jp.getCurrentName().equals(ARRAY_ELEMENT_TAG)) {
		    jp.nextToken();
		    
		    ProfessionCategory d = jp.readValueAs(TYPE_CLAZZ);
		    result.getProfessionCategories().add(d);
		} else {
		    String localName = jp.getCurrentName();
		    String fieldName = null;
		    Class<?> fieldType = null;
		    for (Field f : LIST_CLAZZ.getDeclaredFields()) {
			JacksonXmlProperty a = f.getAnnotation(JacksonXmlProperty.class);
			if (a != null && a.localName().equals(localName)) {
			    fieldType = f.getType();
			    fieldName = f.getName();
			    break;
			}
		    }
		    if (fieldName != null) {
			jp.nextToken();
			Object value = null;
			if(Integer.class.isAssignableFrom(fieldType)){
			    value = jp.getValueAsInt();
			}else{
			    value = jp.getValueAsString();
			}
			try {
			    BeanUtils.setProperty(result, fieldName, value);
			} catch (IllegalAccessException e1) {
			    throw new MatchListProcessingException("Caught problem when trying to set " + fieldName + " and value " + value, e1);
			} catch (InvocationTargetException e1) {
			    throw new MatchListProcessingException("Caught problem when trying to set " + fieldName + " and value " + value, e1);
			}
		    }
		}
	    }
	}
	return result;
    }
}