package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youcruit.ams.api.client.deserializers.ProfessionListDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=ProfessionListDeserializer.class)
public class ProfessionList extends SearchItemList<Profession> {

}
