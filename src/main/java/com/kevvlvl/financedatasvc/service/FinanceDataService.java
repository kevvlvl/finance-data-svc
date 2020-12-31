package com.kevvlvl.financedatasvc.service;

import com.kevvlvl.financedatasvc.dto.StockDto;

public interface FinanceDataService {

    StockDto getLatestData(String stockName);
}
