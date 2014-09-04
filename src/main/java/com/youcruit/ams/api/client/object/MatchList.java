package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class MatchList {
    @JacksonXmlProperty(localName="antal_platsannonser")
    private int count;
    @JacksonXmlProperty(localName="antal_platsannonser_exakta")
    private int countExact;
    @JacksonXmlProperty(localName="antal_platsannonser_narliggande")
    private int countAdjacent;
    @JacksonXmlProperty(localName="antal_sidor")
    private int countPages;
    private List<MatchData> matchDataList;
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getCountExact() {
        return countExact;
    }
    public void setCountExact(int count_exact) {
        this.countExact = count_exact;
    }
    public int getCountAdjacent() {
        return countAdjacent;
    }
    public void setCountAdjacent(int count_adjacent) {
        this.countAdjacent = count_adjacent;
    }
    public int getCountPages() {
        return countPages;
    }
    public void setCountPages(int count_pages) {
        this.countPages = count_pages;
    }
    public List<MatchData> getMatchDataList() {
	if(matchDataList==null){
	    matchDataList = new ArrayList<MatchData>();
	}
        return matchDataList;
    }
    public void setMatchDataList(List<MatchData> matchDataList) {
        this.matchDataList = matchDataList;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + countAdjacent;
	result = prime * result + countExact;
	result = prime * result + countPages;
	result = prime * result + ((matchDataList == null) ? 0 : matchDataList.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof MatchList)) return false;
	MatchList other = (MatchList) obj;
	if (count != other.count) return false;
	if (countAdjacent != other.countAdjacent) return false;
	if (countExact != other.countExact) return false;
	if (countPages != other.countPages) return false;
	if (matchDataList == null) {
	    if (other.matchDataList != null) return false;
	} else if (!matchDataList.equals(other.matchDataList)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "MatchList [count=" + count + ", countExact=" + countExact + ", countAdjacent=" + countAdjacent + ", countPages=" + countPages + ", matchDataList=" + matchDataList + "]";
    }
}
