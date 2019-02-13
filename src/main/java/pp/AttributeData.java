package pp;

import java.util.Set;


public class AttributeData
{
    public static final String FIELD_NAME_REALMS = "realms";

    public Set<Realm> getRealms () { return realms; }
    public void setRealms (Set<Realm> realms) { this.realms = realms; }
    private Set<Realm> realms;



}