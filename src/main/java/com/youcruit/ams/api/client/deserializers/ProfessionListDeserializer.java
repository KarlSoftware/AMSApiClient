package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionList;

public final class ProfessionListDeserializer extends AbstractListDeserializer<Profession, ProfessionList> {

    public ProfessionListDeserializer() {
	super(Profession.class, ProfessionList.class, "sokdata");
    }

}
