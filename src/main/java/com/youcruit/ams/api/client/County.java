package com.youcruit.ams.api.client;

public enum County {
    BLEKINGE(10),
    DALARNA(20),
    GOTLAND(9),
    GAVLEBORG(21),
    HALLAND(13),
    JAMTLAND(23),
    JONKOPING(6),
    KALMAR(8),
    KRONOBERG(7),
    NORRBOTTEN(25),
    SKANE(12),
    STOCKHOLM(1),
    SODERMANLAND(4),
    UPPSALA(3),
    VARMLAND(17),
    VASTERBOTTEN(24),
    VASTERNORRLAND(22),
    VASTMANLAND(19),
    VASTRAGOTALAND(14),
    OREBRO(18),
    OSTERGOTLAND(5),
    UNDEFINED_CITY(90);
    
    private int id;
    County(int id ){
	this.id = id;
    }
    int getId(){
	return id;
    }
    public static County fromId(int id){
	for(County c : County.values()){
	    if(c.id == id){
		return c;
	    }
	}
	return null;
    }
}
