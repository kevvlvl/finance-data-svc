package com.kevvlvl.financedatasvc.handler;

import com.kevvlvl.financedatasvc.service.FinanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class FinanceDataHandler {

    private final FinanceDataService service;

    @Autowired
    public FinanceDataHandler(FinanceDataService service) {
        this.service = service;
    }

    public Mono<ServerResponse> data(ServerRequest request) {

        Optional<String> stockName = request.queryParam("stockName");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(service.getLatestData(stockName.orElseThrow())));
    }
}
