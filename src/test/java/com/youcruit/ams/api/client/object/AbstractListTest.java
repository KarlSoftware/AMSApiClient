package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.junit.Before;

public class AbstractListTest extends AbstractTest {
    @Before
    public void setupListObjectMapper(){
	om.configure(Feature.UNWRAP_ROOT_VALUE, true);
    }
}
