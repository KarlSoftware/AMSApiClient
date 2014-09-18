package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;

import com.youcruit.ams.api.client.serialization.AMSSerializationModule;

public class AbstractTest {

    protected static ObjectMapper om;

    @BeforeClass
    public static void setUpObjectMapper(){
	om = new ObjectMapper();
	om.registerModule(new AMSSerializationModule());
    }

}