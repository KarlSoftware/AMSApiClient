package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionCategoryList;

public final class ProfessionCategoryListDeserializer extends AbstractListDeserializer<ProfessionCategory, ProfessionCategoryList> {
    public ProfessionCategoryListDeserializer() {
	super(ProfessionCategory.class, ProfessionCategoryList.class, "sokdata");
    }
}