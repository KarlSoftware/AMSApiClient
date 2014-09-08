package com.youcruit.ams.api.client.deserializers;

import com.youcruit.ams.api.client.object.MatchData;
import com.youcruit.ams.api.client.object.MatchDataList;

public final class MatchListDeserializer extends AbstractListDeserializer<MatchData, MatchDataList> {
    protected MatchListDeserializer() {
	super(MatchData.class, MatchDataList.class, "matchningdata");
    }
}