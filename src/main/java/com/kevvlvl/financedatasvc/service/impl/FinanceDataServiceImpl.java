package com.kevvlvl.financedatasvc.service.impl;

import com.kevvlvl.financedatasvc.service.FinanceDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Service
@Slf4j
public class FinanceDataServiceImpl implements FinanceDataService {

    private final KafkaTemplate<String, Float> kafkaTemplate;

    private static final String TOPIC_STOCKS = "stocks";

    @Autowired
    public FinanceDataServiceImpl(KafkaTemplate<String, Float> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public float getLatestData() {

        Random r = new Random();
        float stockValue = r.nextFloat() * (80 - 60);
        this.kafkaTemplate.send(TOPIC_STOCKS, stockValue);

        log.info("Stock value: {}", stockValue);
        return stockValue;
    }
}
