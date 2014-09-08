package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.ProfessionSubCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategoryList;

public final class ProfessionSubCategoryListDeserializer extends AbstractListDeserializer<ProfessionSubCategory, ProfessionSubCategoryList> {

    public ProfessionSubCategoryListDeserializer() {
	super(ProfessionSubCategory.class, ProfessionSubCategoryList.class, "sokdata");
    }

}
