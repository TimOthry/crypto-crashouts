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

    public CryptoData getCryptoData(String symbol) {
        String url = "https://cryptoapis.io/api/v1/cryptocurrency/" + symbol + "/data?apikey=" + apiKey;
        return restTemplate.getForObject(url, CryptoData.class);
    }
}