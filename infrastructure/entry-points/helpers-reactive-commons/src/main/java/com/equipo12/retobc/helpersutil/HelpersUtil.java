package com.equipo12.retobc.helpersutil;

import com.equipo12.retobc.model.commons.BalanceAndMovementException;
import com.equipo12.retobc.model.commons.ErrorBalanceAndMovement;
import com.equipo12.retobc.model.commons.ListError;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HelpersUtil {


    public static final String HREF = "href";
    public static final String STATUS = "status";
    public static final String CODE = "code";
    public static final String TITLE = "title";
    public static final String DETAIL = "detail";
    public static final String TRANSACTION_CODE = "transactionCode";
    public static final String EMPTY = "";
    public static final String TRANSANCTIONCODE = "0001";
    

    public Mono<ServerResponse> responseError(Map<String, String> map) {

        String codeError = map.get(CODE);
        String detail = map.get(DETAIL);
        String href = map.get(HREF);
        String status = map.get(STATUS);
        String title = map.get(TITLE);
        ErrorBalanceAndMovement errorBalanceAndMovement = ErrorBalanceAndMovement
											                .builder()
											                .code(codeError).detail(detail).status(status).title(title).href(href)
											                .build();

        return ServerResponse
                .status(HttpStatus.OK)
//        		.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .header(TRANSACTION_CODE, TRANSANCTIONCODE)
                .body(Mono.just(getErrorLCEntity(errorBalanceAndMovement)), ListError.class);
    }
    
    public ErrorBalanceAndMovement errorBalanceAndMovement(Map<String, String> map) {

        String codeError = map.get(CODE);
        String detail = map.get(DETAIL);
        String href = map.get(HREF);
        String status = map.get(STATUS);
        String title = map.get(TITLE);
        return ErrorBalanceAndMovement
                .builder()
                .code(codeError).detail(detail).status(status).title(title).href(href)
                .build();
    }

    public ListError getErrorLCEntity(ErrorBalanceAndMovement errorBalanceAndMovement) {

        return  ListError.builder().errors(
                Arrays.asList(ErrorBalanceAndMovement
                        .builder()
                        .code(errorBalanceAndMovement.getCode())
                        .detail(errorBalanceAndMovement.getDetail())
                        .href(errorBalanceAndMovement.getHref())
                        .title(errorBalanceAndMovement.getTitle())
                        .status(errorBalanceAndMovement.getStatus())
                        .build()))
                .build();

    }


    public Map<String, String> getErrorMessage(Throwable error) {

        Map<String, String> errorResult = new HashMap<>();

        log.info("*****ERROR****ERROR**** ::::: " + error);

        if (error instanceof WebClientResponseException) {
            WebClientResponseException webException = (WebClientResponseException) error;
            ObjectMapper objectMapper = new ObjectMapper();
            ListError errorData = null;

            try {
                errorData =  objectMapper.readValue(webException.getResponseBodyAsString(), ListError.class);
            } catch (IOException e) {
                errorResult.put(CODE, String.valueOf(webException.getStatusCode().value()));
                errorResult.put(DETAIL, webException.getMessage());
                return errorResult;
            }

            errorResult.put(HREF, errorData.getErrors().get(0).getHref());
            errorResult.put(STATUS, errorData.getErrors().get(0).getStatus());
            errorResult.put(CODE, errorData.getErrors().get(0).getCode());
            errorResult.put(TITLE, errorData.getErrors().get(0).getTitle());
            errorResult.put(DETAIL, errorData.getErrors().get(0).getDetail());

        } else if (error instanceof NullPointerException) {
            errorResult.put(CODE, String.valueOf(HttpStatus.BAD_REQUEST.value()));
            errorResult.put(DETAIL, HttpStatus.BAD_REQUEST.getReasonPhrase());
        } else if(error instanceof BalanceAndMovementException){
            errorResult.put(CODE, ((BalanceAndMovementException) error).getCode());
            errorResult.put(DETAIL, error.getMessage());
        } else if (error instanceof ConnectTimeoutException) {
            errorResult.put(CODE, "409");
            errorResult.put(DETAIL, "Connect Timeout Exception - API CONNECT");
        }

        return errorResult;
    }
}
