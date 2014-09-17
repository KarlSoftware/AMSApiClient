package com.youcruit.ams.api.client.serialization;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

import com.youcruit.ams.api.client.object.Ad;
import com.youcruit.ams.api.client.object.Application;
import com.youcruit.ams.api.client.object.Contact;
import com.youcruit.ams.api.client.object.ContactList;
import com.youcruit.ams.api.client.object.Details;
import com.youcruit.ams.api.client.object.DriversLicenseClasses;
import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;
import com.youcruit.ams.api.client.object.Requirement;
import com.youcruit.ams.api.client.object.SearchItem;
import com.youcruit.ams.api.client.object.SearchItemList;
import com.youcruit.ams.api.client.object.Terms;
import com.youcruit.ams.api.client.object.Workplace;

public class AMSSerializationModule extends SimpleModule {

    public AMSSerializationModule() {
	super("AMSSerializationModule", new Version(0, 2, 3, null));
    }
    
    @Override
    public void setupModule(SetupContext context)
    {
	context.setMixInAnnotations(SearchItem.class, SearchItemMixIn.class);
	context.setMixInAnnotations(SearchItemList.class, SearchItemListMixIn.class);
	context.setMixInAnnotations(Ad.class, AdMixIn.class);
	context.setMixInAnnotations(Requirement.class, RequirementMixIn.class);
	context.setMixInAnnotations(Application.class, ApplicationMixIn.class);
	context.setMixInAnnotations(Contact.class, ContactMixIn.class);
	context.setMixInAnnotations(ContactList.class, ContactListMixIn.class);
	context.setMixInAnnotations(Details.class, DetailsMixIn.class);
	context.setMixInAnnotations(DriversLicenseClasses.class, DriversLicenseClassesMixIn.class);
	context.setMixInAnnotations(MatchData.class, MatchDataMixIn.class);
	context.setMixInAnnotations(MatchDataList.class, MatchDataListMixIn.class);
	context.setMixInAnnotations(Terms.class, TermsMixIn.class);
	context.setMixInAnnotations(Workplace.class, WorkplaceMixIn.class);
    }
}
