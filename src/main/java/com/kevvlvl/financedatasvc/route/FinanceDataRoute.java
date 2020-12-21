package com.kevvlvl.financedatasvc.route;

import com.kevvlvl.financedatasvc.handler.FinanceDataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FinanceDataRoute {

    @Bean
    public RouterFunction<ServerResponse> route(FinanceDataHandler financeDataHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/data").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), financeDataHandler::data);
    }
}
