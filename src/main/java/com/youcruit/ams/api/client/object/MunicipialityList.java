package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youcruit.ams.api.client.deserializers.MunicipialityListDeserializer;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=MunicipialityListDeserializer.class)
public class MunicipialityList extends SearchItemList<Municipiality> {

}
