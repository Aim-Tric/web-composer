package cn.codebro.server.infrastructure.external;

import cn.codebro.server.module.ApiResponse;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ServerResponseAware implements ResponseBodyAdvice<ApiResponse> {


    @ExceptionHandler(Exception.class)
    public ApiResponse exceptionHandler(Exception e) {
        return null;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        NonUnionResponse methodAnnotation = returnType.getMethodAnnotation(NonUnionResponse.class);
        return ObjectUtil.isNull(methodAnnotation);
    }

    @Override
    public ApiResponse beforeBodyWrite(ApiResponse body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        return null;
    }
}
