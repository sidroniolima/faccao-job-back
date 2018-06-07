package br.com.tetrati.faccao.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class JsonDateSerializer extends JsonSerializer<LocalDate> 
{
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException 
	{
		gen.writeString(date.format(dtf));
	}

}
