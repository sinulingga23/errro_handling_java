package app.sinulingga.thirdparty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.util.Calendar.SECOND;

@Service
public class SimpleThirdPartyService {
    private static final int TIMEOUT = 30;
    private static final int RC_SUCCESS = 200;
    private static final Logger log = LoggerFactory.getLogger(SimpleThirdPartyService.class);

    public void doRequest()
            throws URISyntaxException, HttpTimeoutException, IOException, InterruptedException, NotSuccessException {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://postman-echo.com/get"))
                    .timeout(Duration.of(TIMEOUT, ChronoUnit.SECONDS))
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != RC_SUCCESS)
                throw new NotSuccessException("Failed do request.");

            log.info("Success doing request.");
        } catch (URISyntaxException e) {
            log.info("URISyntaxException e: " + e.getMessage());
            throw e;
        } catch (HttpTimeoutException e) {
            log.info("HttpTimeoutException e: " + e.getMessage());
            throw e;
        } catch (IOException e) {
            log.info("IOException e: " + e.getMessage());
            throw e;
        } catch (InterruptedException e) {
            log.info("InterruptedException e: " + e.getMessage());
            throw e;
        } catch (NotSuccessException e) {
            log.info("NotSuccessException e: " + e.getMessage());
            throw e;
        }
    }
}
