package com.youcruit.ams.api.client;

import java.net.MalformedURLException;

import javax.xml.ws.BindingProvider;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.youcruit.ams.api.soap.OccupationList;
import com.youcruit.ams.api.soap.WSOccupation;
import com.youcruit.ams.api.soap.WSOccupationSoap;

public class SoapINTTest {

    public static final String ENDPOINT = "http://api.arbetsformedlingen.se/af/v0/Occupation/wsoccupation.asmx";
    private WSOccupationSoap wsOccupationSoap;

    @BeforeClass
    public static void setupDump() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class.forName("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe").getField("dump").set(null, true);
    }

    @Before
    public void setup() throws MalformedURLException {
        wsOccupationSoap = new WSOccupation().getWSOccupationSoap();
        BindingProvider bindingProvider = (BindingProvider) this.wsOccupationSoap;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);
    }

    @Test
    public void getOccupations() {
        OccupationList allOccupations = wsOccupationSoap.getAllOccupations();
        System.err.println(allOccupations);
    }
}
