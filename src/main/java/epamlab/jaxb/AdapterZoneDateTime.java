package epamlab.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;


public class AdapterZoneDateTime extends XmlAdapter<String, ZonedDateTime> {
    @Override
    public ZonedDateTime unmarshal(String v) throws Exception {
        return ZonedDateTime.parse(v);
    }

    @Override
    public String marshal(ZonedDateTime v) throws Exception {
        return v.toString();
    }
}
