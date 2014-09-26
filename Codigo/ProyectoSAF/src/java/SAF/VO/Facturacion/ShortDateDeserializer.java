package SAF.VO.Facturacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.sql.Timestamp;

public class ShortDateDeserializer extends JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {

        java.util.Date date= new java.util.Date();
	return new Timestamp(date.getTime());
    }
}