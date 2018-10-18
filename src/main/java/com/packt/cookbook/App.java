package com.packt.cookbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App

{
    public static AttributeData attributeData;
    public static void setAttributeData (String parserInput) throws IOException
    {
        if (parserInput == null) {
            App.attributeData = null;
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            ObjectReader reader = mapper.reader(new TypeReference<AttributeData>() {});
//            JsonNode rootNode = mapper.readTree(parserInput); // this line will not check field mismatch
//            String rootText = rootNode.asText();  // asText after readTree will give us empty string, need to use node.get(fieldname)
//            JsonNode realmSetNode = rootNode.get("realmSet");
//            JsonNode mapNode = rootNode.get("mapData");
//            System.out.println(mapNode.asText());

            App.attributeData = reader.readValue(parserInput);
            System.out.println(App.attributeData.getRealmSet());
            System.out.println("in try");
        }
        catch (Exception e) {
            System.out.println("in exception");
            System.out.println(e.getMessage());
            App.attributeData = null;
        }
    }

    public static void main( String[] args )
    {
        String parserRealmSet = "{ \"realmSet\" : [ "

            + "{ \"customerSiteName\": \"some_site_name\" , "
            + "  \"aribaSNNetworkId\": \"some_work_id\", "
            + "\"serviceManagerType\": \"some_manager_type\" "
            //            + " \"extraField:\" : \"extraValue\" "
            + "} ], "
            + "\"mapData\" : "
            + "{ \"map_field1\": \"map_value1\" , "
            + " \"map_field2\": \"map_value2\" "
            + "} } ";

        String parserInput = "{ \"realmSet\" : [], "
            + "\"mapData\" : "
            + "{ \"customerSiteName\": \"some_site_name\" , "
            + "  \"aribaSNNetworkId\": \"some_work_id\", "
                + "\"serviceManagerType\": \"some_manager_type\" "
//            + " \"extraField:\" : \"extraValue\" "
            + "}} ";
        try {
            setAttributeData(parserRealmSet);
            Map<String, String> mapData = new HashMap<>(attributeData.getMapData());
            System.out.println(mapData.get("map_field1"));
            List<AttributeData.Realm> realmSet = new ArrayList<AttributeData.Realm>(attributeData.getRealmSet());
            System.out.println(realmSet.get(0).getAribaSNNetworkId());
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("exception block");
        }
    }
}
