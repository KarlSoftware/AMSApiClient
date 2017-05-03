package com.youcruit.ams.api.client.serialization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.youcruit.ams.api.client.object.MatchData;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value="matchningslista")
public abstract class MatchDataListMixIn {
    @JsonProperty(value="antal_platsannonser")
    public abstract void setCount(int count);
    @JsonProperty(value="antal_platsannonser_exakta")
    public abstract void setCountExact(int count_exact);
    @JsonProperty(value="antal_platsannonser_narliggande")
    public abstract void setCountAdjacent(int count_adjacent);
    @JsonProperty(value="antal_sidor")
    public abstract void setCountPages(int count_pages);
    @JsonProperty(value="matchningdata")
    public abstract void setList(List<MatchData> list);

}
