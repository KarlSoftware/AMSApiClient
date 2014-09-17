package com.youcruit.ams.api.client.object;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessionSubCategoryList extends SearchItemList<ProfessionSubCategory>  implements AMSList<ProfessionSubCategory>{
}
