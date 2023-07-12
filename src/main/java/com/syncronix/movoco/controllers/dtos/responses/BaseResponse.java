package  com.syncronix.movoco.controllers.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
public class BaseResponse {

    private HttpStatus status;

    private Integer statusCode;

    private Object data;

    private String message;

    private Boolean success;

    private HttpStatus httpStatus;

    public ResponseEntity<BaseResponse> apply() {
        return new ResponseEntity<>(this, status);
    }
}
