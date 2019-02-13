package pp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Hello world!
 *
 */
public class Test

{
    public static AttributeData attributeData;
    public String addAttributeString;
    public static void setAttributeData (String parserInput) throws IOException
    {
        if (parserInput == null) {
            Test.attributeData = null;
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

            Test.attributeData = reader.readValue(parserInput);
            System.out.println(Test.attributeData.getRealms());
            System.out.println("in try");
        }
        catch (Exception e) {
            System.out.println("in exception");
            System.out.println(e.getMessage());
            Test.attributeData = null;
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
//        try {
//            setAttributeData(parserRealmSet);
//            List<Realm> realmSet = new ArrayList<Realm>(attributeData.getRealms());
//            System.out.println(realmSet.get(0).getAnid());
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            System.out.println("exception block");
//        }

        String teststr = "";
        try {

            HashSet<Realm> realms = new HashSet<Realm>();
            Realm realm1 = new Realm();
            realm1.setRealmName("ADP");
            realm1.setAnid("AN1234563");
            realm1.setProduct("Buyer");

            Realm realm2 = new Realm();
            realm2.setRealmName("ADP-T");
            realm2.setAnid("AN1234563-T");
            realm2.setProduct("Buyer");
            realms.add(realm1);
            realms.add(realm2);

            AttributeData attributeData = new AttributeData();
            attributeData.setRealms(realms);
            ObjectWriter objectWriter = new ObjectMapper().writer();
            teststr = objectWriter.writeValueAsString(attributeData);

            int i = 0;
            for (char c:teststr.toCharArray()) {
                System.out.print(i);
                System.out.print(c);
                System.out.println();
                i = i+1;
            }

        } catch (Exception e) {
            System.out.println("set error");
        }

        String ts = "{\"realms\":[{\"realmName\":\"ADP\",\"anid\":\"AN1234563\",\"product\":\"Buyer\"},{\"realmName\":\"ADP-T\",\"anid\":\"AN1234563-T\",\"product\":\"Buyer\"}]}";
        try {
            String attributeDataString = ts;
            ObjectMapper mapper = new ObjectMapper();
//            AttributeData attributeData = mapper.readValue(attributeDataString, AttributeData.class);

//            String realmsString = attributeData.getRealms().toString();
//            System.out.println(realmsString);
            ObjectReader reader = mapper.reader(new TypeReference<AttributeData>() {
            });
            reader.readValue(attributeDataString);


        } catch (IOException e) {
            System.out.println("retrieve error");
        }

//        Long myLong = null;
//        long mylong = (long) myLong; // this will be a NullPointerException

        String regex = ".*([+][0-9]+)@sap.com";//([+][0-9]+)@sap.com$";

        String email = "abc@sap.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        // https://stackoverflow.com/questions/38296673/replace-group-1-of-java-regex-with-out-replacing-the-entire-regex?rq=1
        if (m.matches()) {
            System.out.println(m.group(1));
            StringBuffer sb = new StringBuffer();
            m.appendReplacement(sb, m.group(0).replaceFirst(Pattern.quote(m.group(1)), ""));
            System.out.println(sb.toString());
        }
        email = email.replace(regex, "");




    }
}
