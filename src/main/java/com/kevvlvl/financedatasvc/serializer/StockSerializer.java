package com.kevvlvl.financedatasvc.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevvlvl.financedatasvc.dto.StockDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class StockSerializer implements Serializer<StockDto> {

    @Override
    public byte[] serialize(String s, StockDto stockDto) {

        byte[] retValue = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retValue = objectMapper.writeValueAsString(stockDto).getBytes();
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize object {}", stockDto);
            e.printStackTrace();
        } catch (Exception e) {
            log.error("Other exception", e);
            e.printStackTrace();
        }

        log.info("Serializing stockDto {}", stockDto);
        return retValue;
    }
}
