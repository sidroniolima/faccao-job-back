package br.com.tetrati.faccao.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> 
{
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void serialize(LocalDateTime dateTime, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException 
	{
		gen.writeString(dateTime.format(dtf));
	}

}
