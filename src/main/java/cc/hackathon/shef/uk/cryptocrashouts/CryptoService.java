package cc.hackathon.shef.uk.cryptocrashouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {

    @Value("${cryptoapi.key}")  // Add your API key to application.properties
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public CryptoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CryptoResponse getCryptoData(String symbol) {
        // Construct the URL with the correct parameters
        String url = "https://rest.cryptoapis.io/market-data/exchange-rates/by-symbols/" + symbol + "/usd?calculationTimestamp=" + (System.currentTimeMillis() / 1000);

        // Set the authorization header
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", apiKey);

        // Create an HttpEntity with the headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send GET request and deserialize the response to CryptoResponse
        ResponseEntity<CryptoResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CryptoResponse.class);

        return response.getBody();
    }
}