package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using=ProfessionCategoryListDeserializer.class)
public class ProfessionCategoryList extends SearchItemList<ProfessionCategory> {
}
