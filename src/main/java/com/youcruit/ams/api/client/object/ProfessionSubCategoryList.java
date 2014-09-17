package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using=ProfessionSubCategoryListDeserializer.class)
public class ProfessionSubCategoryList extends SearchItemList<ProfessionSubCategory>  implements AMSList<ProfessionSubCategory>{
}
