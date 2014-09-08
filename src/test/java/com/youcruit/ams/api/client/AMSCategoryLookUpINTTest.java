package com.youcruit.ams.api.client;

import com.youcruit.ams.api.client.object.Profession;
import com.youcruit.ams.api.client.object.ProfessionCategory;
import com.youcruit.ams.api.client.object.ProfessionSubCategory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AMSCategoryLookUpINTTest {

    public static final String PROFESSION_ID = "6242";
    private static AMSLookUp lookup;
    private static String amsApiUrl = "http://api.arbetsformedlingen.se";

    @BeforeClass
    public static void setup() throws IOException, URISyntaxException {
	lookup = AMSLookUp.instance();
	long timer = System.currentTimeMillis();
	lookup.fetch(amsApiUrl);
	System.out.println("Fetch execution time: " + (System.currentTimeMillis() - timer) + " ms");
    }

    @Test
    public void testCategoryLookup() {
	ProfessionCategory category = lookup.getCategoryByProfessionId(PROFESSION_ID);
	System.out.println(category.toString());
	ProfessionSubCategory subCategory = lookup.getSubCategoryByProfessionId(PROFESSION_ID);
	System.out.println(subCategory.toString());
	Profession profession = lookup.getProfessionById(PROFESSION_ID);
	System.out.println(profession.toString());
    }
}
