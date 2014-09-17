package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using=MunicipialityListDeserializer.class)
public class MunicipialityList extends SearchItemList<Municipiality> {

}
