package com.kevvlvl.financedatasvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class StockDto {

    private String name;
    private BigDecimal value;
}
