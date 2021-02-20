package com.smart_house.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Value;

import java.io.IOException;

@Value
@Builder(setterPrefix = "with")
@JsonSerialize(using = SimpleResponseDto.CustomSerializer.class)
public class SimpleResponseDto {
    String name;
    Object value;

    public static class CustomSerializer extends JsonSerializer<SimpleResponseDto> {

        @Override
        public void serialize(SimpleResponseDto value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeObjectField(value.getName(), value.getValue());
            gen.writeEndObject();
        }
    }
}
