package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.BeforeClass;

import com.youcruit.ams.api.client.serialization.AMSSerializationModule;

public class AbstractTest {

    protected ObjectMapper om;

    @BeforeClass
    public void setUpObjectMapper(){
	om = new ObjectMapper();
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
	om.registerModule(new AMSSerializationModule());
    }

}