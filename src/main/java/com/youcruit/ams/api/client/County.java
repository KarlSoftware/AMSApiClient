package com.youcruit.ams.api.client;

public enum County {
    BLEKINGE(10, "Blekinge"),
    DALARNA(20, "Dalarna"),
    GOTLAND(9, "Gotland"),
    GAVLEBORG(21, "Gävleborg"),
    HALLAND(13, "Halland"),
    JAMTLAND(23, "Jämtland"),
    JONKOPING(6, "Jönköping"),
    KALMAR(8, "Kalmar"),
    KRONOBERG(7, "Kronoberg"),
    NORRBOTTEN(25, "Norrbotten"),
    SKANE(12, "Skåne"),
    STOCKHOLM(1, "Stockholm"),
    SODERMANLAND(4, "Södermanland"),
    UPPSALA(3, "Uppsala"),
    VARMLAND(17, "Värmland"),
    VASTERBOTTEN(24, "Västerbotten"),
    VASTERNORRLAND(22, "Västernorrland"),
    VASTMANLAND(19, "Västmanland"),
    VASTRAGOTALAND(14, "Västra Götaland"),
    OREBRO(18, "Örebro"),
    OSTERGOTLAND(5, "Östergötland"),
    UNDEFINED_CITY(90, "Ospecificerad arbetsort");
    
    private int id;
    private String description;
    County(int id , String description){
	this.id = id;
	this.description = description;
    }
    public int getId(){
	return id;
    }
    public String getDescription() {
	return description;
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
