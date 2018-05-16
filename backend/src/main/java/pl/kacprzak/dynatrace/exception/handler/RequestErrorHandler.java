package pl.kacprzak.dynatrace.exception.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import pl.kacprzak.dynatrace.exception.DynatraceRequestException;

import java.io.IOException;

public class RequestErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if(response.getRawStatusCode()>=400)
            return true;

        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        throw new DynatraceRequestException();
    }
}