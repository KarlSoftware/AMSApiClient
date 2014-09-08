package com.youcruit.ams.api.client.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youcruit.ams.api.client.deserializers.ProfessionSubCategoryListDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=ProfessionSubCategoryListDeserializer.class)
public class ProfessionSubCategoryList extends SearchItemList<ProfessionSubCategory>  implements AMSList<ProfessionSubCategory>{
}
