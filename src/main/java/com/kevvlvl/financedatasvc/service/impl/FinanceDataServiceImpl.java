package com.kevvlvl.financedatasvc.service.impl;

import com.kevvlvl.financedatasvc.dto.StockDto;
import com.kevvlvl.financedatasvc.service.FinanceDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
@Slf4j
public class FinanceDataServiceImpl implements FinanceDataService {

    private final KafkaTemplate<String, StockDto> kafkaTemplate;

    private static final String TOPIC_STOCKS = "stocks";

    @Autowired
    public FinanceDataServiceImpl(KafkaTemplate<String, StockDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public StockDto getLatestData() {

        Random r = new Random();
        BigDecimal stockValue = BigDecimal.valueOf(r.nextDouble() * (80 - 60));

        // TODO: do not hardcode param name
        StockDto stock = new StockDto("FAKESTOCK.Z", stockValue);

        this.kafkaTemplate.send(TOPIC_STOCKS, stock);

        log.info("Stock value: {}", stock);
        return stock;
    }
}
