package com.youcruit.ams.api.client.object;

import static com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_ROOT_VALUE;

import org.junit.Before;

public class AbstractListTest extends AbstractTest {
    @Before
    public void setupListObjectMapper(){
	om.enable(UNWRAP_ROOT_VALUE);
    }
}
