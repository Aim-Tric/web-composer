package cn.codebro.server.module.web;

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
public class ServerResponseAware implements ResponseBodyAdvice<Object> {


    @ExceptionHandler(Exception.class)
    public ApiResponse exceptionHandler(Exception e) {
        return new ApiResponse.ApiResponseBuilder(ApiResponse.ApiResponseEnums.FAILURE).build();
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        NonUnionResponse methodAnnotation = returnType.getMethodAnnotation(NonUnionResponse.class);
        return ObjectUtil.isNull(methodAnnotation);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResponse) {
            return body;
        }
        return new ApiResponse.ApiResponseBuilder(ApiResponse.ApiResponseEnums.SUCCESS, body).build();
    }
}
