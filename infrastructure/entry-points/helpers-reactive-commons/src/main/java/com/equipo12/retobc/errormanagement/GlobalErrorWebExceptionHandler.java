package com.equipo12.retobc.errormanagement;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;

import com.equipo12.retobc.helpersutil.HelpersUtil;

import reactor.core.publisher.Mono;

import java.util.Map;

// https://www.baeldung.com/spring-webflux-errors
@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
			ApplicationContext applicationContext, ServerCodecConfigurer codecConfigurer) {
		super(errorAttributes, resourceProperties, applicationContext);
		this.setMessageWriters(codecConfigurer.getWriters());
		// TODO Auto-generated constructor stub
	}


	@Override
    protected RouterFunction<ServerResponse> getRoutingFunction(
      ErrorAttributes errorAttributes) {

        return RouterFunctions.route(
          RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(
       ServerRequest request) {

    	HelpersUtil helpersUtil = new HelpersUtil();
    	
        Map<String, String> errorMessage = helpersUtil.getErrorMessage(/*header.getTransactionTracker(),*/ getError(request));

        if (errorMessage.isEmpty()) {
            Map<String, Object> errorPropertie = getErrorAttributes(request, true);
            String stat = String.valueOf(errorPropertie.get(HelpersUtil.STATUS));
            String detail = String.valueOf(errorPropertie.get(HelpersUtil.DETAIL));
            errorMessage.put(HelpersUtil.STATUS, stat);
            errorMessage.put(HelpersUtil.DETAIL, detail);
            return helpersUtil.responseError(errorMessage);
        }

        return helpersUtil.responseError(errorMessage);
    }

}