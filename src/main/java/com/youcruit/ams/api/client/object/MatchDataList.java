package com.youcruit.ams.api.client.object;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value="matchningslista")
public class MatchDataList implements AMSList<MatchData>{
    @JsonProperty(value="antal_platsannonser")
    private int count;
    @JsonProperty(value="antal_platsannonser_exakta")
    private int countExact;
    @JsonProperty(value="antal_platsannonser_narliggande")
    private int countAdjacent;
    @JsonProperty(value="antal_sidor")
    private int countPages;
    @JsonProperty(value="matchningdata")
    private List<MatchData> list;
    
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
    public List<MatchData> getList() {
	if(list==null){
	    list = new ArrayList<MatchData>();
	}
        return list;
    }
    public void setList(List<MatchData> list) {
        this.list = list;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + countAdjacent;
	result = prime * result + countExact;
	result = prime * result + countPages;
	result = prime * result + ((list == null) ? 0 : list.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof MatchDataList)) return false;
	MatchDataList other = (MatchDataList) obj;
	if (count != other.count) return false;
	if (countAdjacent != other.countAdjacent) return false;
	if (countExact != other.countExact) return false;
	if (countPages != other.countPages) return false;
	if (list == null) {
	    if (other.list != null) return false;
	} else if (!list.equals(other.list)) return false;
	return true;
    }
    @Override
    public String toString() {
	return "MatchDataList [count=" + count + ", countExact=" + countExact + ", countAdjacent=" + countAdjacent + ", countPages=" + countPages + ", list=" + list + "]";
    }
}
