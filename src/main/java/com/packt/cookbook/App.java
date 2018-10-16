package com.packt.cookbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

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
            JsonNode rootNode = mapper.readTree(parserInput);
            JsonNode realmSetNode = rootNode.get("realmSet");
            JsonNode mapNode = rootNode.get("mapData");
//            System.out.println(mapNode.asText());
            System.out.println("after mapNode");
            App.attributeData = reader.readValue(parserInput);
            System.out.println(App.attributeData.getMapData().getAribaSNNetworkId());
            System.out.println("after mapNode");
        }
        catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            App.attributeData = null;
        }
    }

    public static void main( String[] args )
    {
        String parserInput = "{ \"realmSet\" : [], "
            + "\"mapData\" : "
            + "{ \"customerSiteName\": \"some_site_name\" , "
            + "  \"aribaSNNetworkId\": \"some_work_id\", "
                + "\"serviceManagerType\": \"some_manager_type\" } "
            + "} ";
        try {
            setAttributeData(parserInput);
            System.out.println(attributeData);
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("exception block");
        }
        System.out.println( "Hello World!" );
    }
}
