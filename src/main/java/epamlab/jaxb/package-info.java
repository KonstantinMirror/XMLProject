@XmlJavaTypeAdapters({@XmlJavaTypeAdapter(value = AdapterZoneDateTime.class, type = ZonedDateTime.class)}) package epamlab.jaxb;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.ZonedDateTime;