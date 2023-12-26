package cn.codebro.server.domain;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    private Long time;

    ApiResponse(Integer code, String message, Object data, Long time) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = time;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static class ApiResponseBuilder {
        private Integer code;
        private String message;
        private Object data;

        public ApiResponseBuilder(ApiResponseEnums apiResponseEnums, Object data) {
            this.code = apiResponseEnums.code;
            this.message = apiResponseEnums.message;
            this.data = data;
        }

        public ApiResponseBuilder(ApiResponseEnums apiResponseEnums) {
            this(apiResponseEnums, null);
        }

        public ApiResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(code, message, data, System.currentTimeMillis());
        }
    }

    public enum ApiResponseEnums {

        ;
        private final Integer code;
        private final String message;

        ApiResponseEnums(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
