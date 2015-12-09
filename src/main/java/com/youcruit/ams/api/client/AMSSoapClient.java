package com.youcruit.ams.api.client;

import javax.xml.ws.BindingProvider;

import com.youcruit.ams.api.soap.WSOccupation;
import com.youcruit.ams.api.soap.WSOccupationSoap;

public class AMSSoapClient {
    public static final String ENDPOINT = "http://api.arbetsformedlingen.se/af/v0/Occupation/wsoccupation.asmx";

    public static WSOccupationSoap createClient() {
	WSOccupationSoap wsOccupationSoap = new WSOccupation().getWSOccupationSoap();
	BindingProvider bindingProvider = (BindingProvider) wsOccupationSoap;
	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);
	return wsOccupationSoap;
    }

}
