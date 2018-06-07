package br.com.tetrati.faccao.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class JsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> 
{
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException 
	{
		String date = parser.getText();
		
		return LocalDateTime.parse(date, dtf);
	}

}
