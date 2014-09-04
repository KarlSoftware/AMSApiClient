package com.youcruit.ams.api.client.object;

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

final class MatchListDeserializer extends JsonDeserializer<MatchDataList> {
    private static final String MATCHNINGDATA = "matchningdata";

    @Override
    public MatchDataList deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	MatchDataList result = new MatchDataList();
	while (jp.nextToken() != null) {
	    if (jp.getCurrentToken().compareTo(JsonToken.FIELD_NAME) == 0) {
		if (jp.getCurrentName().equals(MATCHNINGDATA)) {
		    jp.nextToken();
		    MatchData d = jp.readValueAs(MatchData.class);
		    result.getMatchDataList().add(d);
		} else {
		    String localName = jp.getCurrentName();
		    String fieldName = null;
		    for (Field f : MatchDataList.class.getDeclaredFields()) {
			JacksonXmlProperty a = f.getAnnotation(JacksonXmlProperty.class);
			if (a != null && a.localName().equals(localName)) {
			    fieldName = f.getName();
			    break;
			}
		    }
		    if (fieldName != null) {
			jp.nextToken();
			int value = jp.getValueAsInt();
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