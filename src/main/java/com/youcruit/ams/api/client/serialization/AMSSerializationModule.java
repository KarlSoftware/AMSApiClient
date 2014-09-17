package com.youcruit.ams.api.client.serialization;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

import com.youcruit.ams.api.client.object.SearchItem;

public class AMSSerializationModule extends SimpleModule {

    public AMSSerializationModule() {
	super("AMSSerializationModule", new Version(0, 2, 3, null));
    }
    
    @Override
    public void setupModule(SetupContext context)
    {
	context.setMixInAnnotations(SearchItem.class, SearchItemMixIn.class);
    }
}
