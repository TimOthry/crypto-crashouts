package cc.hackathon.shef.uk.cryptocrashouts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Represents a card for a crypto currency
 */
public class Card {
    private final String name;
    private final double power;

    /**
     * Constructor for a card
     * @param name The name of the cryptocurrency
     * @param coinAmount The amount of the cryptocurrency the user owns
     */
    public Card(String name, double coinAmount) {
        this.name = name;
        this.power = coinAmount * getMarketValue(name);
    }

    private static double getMarketValue(String name) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://rest.cryptoapis.io/market-data/exchange-rates/by-symbols/" + name + "/usd")
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", "8a7c4da3dee5856d0cf935100e8ef0e31b1abd58")
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, Map.class);

            // extract the conversion rate
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            Map<String, Object> item = (Map<String, Object>) data.get("item");
            String rate = item.get("rate").toString();

            return Double.parseDouble(rate);
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public String toString() {
        return "Crypto: " + name + ", Power: " + power;
    }
}
