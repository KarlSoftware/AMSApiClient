package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using=ProfessionListDeserializer.class)
public class ProfessionList extends SearchItemList<Profession> {

}
