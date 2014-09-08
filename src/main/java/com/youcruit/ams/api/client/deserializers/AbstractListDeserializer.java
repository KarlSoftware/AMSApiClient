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
import com.youcruit.ams.api.client.object.AMSList;

public abstract class AbstractListDeserializer<TYPE, LIST extends AMSList<TYPE>> extends JsonDeserializer<LIST>{
    private final String ARRAY_ELEMENT_TAG;
    private final Class<TYPE> TYPE_CLAZZ;
    private final Class<LIST> LIST_CLAZZ;
    
    protected AbstractListDeserializer(Class<TYPE> typeClazz, Class<LIST> listClass, String arrayElementTag){
	TYPE_CLAZZ = typeClazz;
	LIST_CLAZZ = listClass;
	ARRAY_ELEMENT_TAG = arrayElementTag;
    }

    private LIST createList() throws InstantiationException, IllegalAccessException
    {
        return LIST_CLAZZ.newInstance();
    }
    
    @Override
    public LIST deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	LIST result;
	try {
	    result = createList();
	} catch (InstantiationException e) {
	    throw new RuntimeException(e);
	} catch (IllegalAccessException e) {
	    throw new RuntimeException(e);
	}
	while (jp.nextToken() != null) {
	    if (jp.getCurrentToken().compareTo(JsonToken.FIELD_NAME) == 0) {
		if (jp.getCurrentName().equals(ARRAY_ELEMENT_TAG)) {
		    jp.nextToken();
		    
		    TYPE d = jp.readValueAs(TYPE_CLAZZ);
		    result.getList().add(d);
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
