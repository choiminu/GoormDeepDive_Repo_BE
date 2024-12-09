package delivery.api.common.api;

import delivery.api.common.error.ErrorCodeInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> OK(T data) {
        Api<T> api = new Api<T>();
        api.result = Result.OK();
        api.body = data;
        return api;
    }

    public static Api<Object> ERROR(Result result) {
        Api<Object> api = new Api<>();
        api.result = result;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface) {
        Api<Object> api = new Api<>();
        api.result = Result.ERROR(errorCodeInterface);
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, Throwable tx) {
        Api<Object> api = new Api<>();
        api.result = Result.ERROR(errorCodeInterface, tx);
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, String description) {
        Api<Object> api = new Api<>();
        api.result = Result.ERROR(errorCodeInterface, description);
        return api;
    }
}
