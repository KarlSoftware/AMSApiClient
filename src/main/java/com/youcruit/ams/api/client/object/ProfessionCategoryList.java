package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youcruit.ams.api.client.deserializers.ProfessionCategoryListDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=ProfessionCategoryListDeserializer.class)
public class ProfessionCategoryList extends SearchItemList<ProfessionCategory> {
}
