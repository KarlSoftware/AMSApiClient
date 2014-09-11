package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.Municipiality;
import com.youcruit.ams.api.client.object.MunicipialityList;

public class MunicipialityListDeserializer extends AbstractListDeserializer<Municipiality, MunicipialityList> {

    protected MunicipialityListDeserializer() {
	super(Municipiality.class, MunicipialityList.class, "sokdata");
    }

}
