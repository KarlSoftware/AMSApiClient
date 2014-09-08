package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.ProfessionGroup;
import com.youcruit.ams.api.client.object.ProfessionGroupList;

public final class ProfessionGroupListDeserializer extends AbstractListDeserializer<ProfessionGroup, ProfessionGroupList> {

    public ProfessionGroupListDeserializer() {
	super(ProfessionGroup.class, ProfessionGroupList.class, "sokdata");
    }

}
