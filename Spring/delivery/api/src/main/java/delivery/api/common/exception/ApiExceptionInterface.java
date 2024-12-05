package delivery.api.common.exception;

import delivery.api.common.error.ErrorCodeInterface;

public interface ApiExceptionInterface {
    ErrorCodeInterface getErrorCodeInterface();

    String getErrorDescription();
}
