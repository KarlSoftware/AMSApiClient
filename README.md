Java API Client for http://api.arbetsformedlingen.se/
=====================================================

Usage
-----

The client is built and distributed with Maven
### Maven dependencies
Add our Maven Snapshot repository to your pom file
```
<repository>
    <id>youcruit-cloudbees-snapshot</id>
    <name>youcruit-cloudbees-snapshot</name>
    <url>http://repository-youcruit.forge.cloudbees.com/snapshot/</url>
    <releases>
        <enabled>false</enabled>
    </releases>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```

Also add the dependency to your pom
```
<dependency>
    <groupId>com.youcruit.ams.api.client</groupId>
    <artifactId>AMSApiClient</artifactId>
    <version>0.2.4-SNAPSHOT</version>
</dependency>
```

### Simple usage:

```java
AMSApiClient client = new AMSApiClient("http://api.arbetsformedlingen.se", "youremail@example.com");
//The Api is paged and the first page starts at 1
AMSQuery query = new AMSQueryBuilder(AMSQuery.EndPoint.MATCHING).county(County.VARMLAND).page(1).build();
MatchDataList dataList = client.executeQuery(query, MatchDataList.class);
for(MatchData d : dataList.getList()) {
	AMSQuery adQuery = new AMSQueryBuilder(AMSQuery.EndPoint.AD).id(d.getAdId()).build();
	Ad ad = client.executeQuery(adQuery, Ad.class);
	System.out.println(ad);
}
```

### More examples:
See AMSApiClientINTTest.java in the com.youcruit.ams.api.client package for more examples of how to use the client.

### Notes on usage
The API end point sometimes returns a response code of 500 or 404 (the latter even though it is returned in the MATCHING searches).
So be warned and handle thrown IOExceptions and AMSAPIExceptions accordingly.

Building
--------

mvn clean install