package com.packt.cookbook;

import java.util.Map;
import java.util.Set;

public class AttributeData
{

    public Set<Realm> getRealmSet () { return realmSet; }
    public void setRealmSet (Set<Realm> realmSet) { this.realmSet = realmSet; }
    private Set<Realm> realmSet;

    public Map<String, String> mapData;
    public Map<String, String> getMapData () { return mapData; }
    public void setMapData (Map<String, String> mapData) { this.mapData = mapData; }

//    public MapData getMapData () { return mapData; }
//    public void setMapData (MapData mapData) { this.mapData = mapData; }
//    private MapData mapData;

    public static class Realm {
        public String getCustomerSiteName ()
        {
            return customerSiteName;
        }

        public void setCustomerSiteName (String customerSiteName)
        {
            this.customerSiteName = customerSiteName;
        }

        private String customerSiteName;

        public String getAribaSNNetworkId ()
        {
            return aribaSNNetworkId;
        }

        public void setAribaSNNetworkId (String aribaSNNetworkId)
        {
            this.aribaSNNetworkId = aribaSNNetworkId;
        }

        private String aribaSNNetworkId;

        public String getServiceManagerType ()
        {
            return serviceManagerType;
        }

        public void setServiceManagerType (String serviceManagerType)
        {
            this.serviceManagerType = serviceManagerType;
        }

        private String serviceManagerType;

//        public MapData () {
//
//        }

//        public MapData (String customerSiteName, String aribaSNNetworkId, String serviceManagerType)
//        {
//            this.customerSiteName = customerSiteName;
//            this.aribaSNNetworkId = aribaSNNetworkId;
//            this.serviceManagerType = serviceManagerType;
//        }
    }

}

