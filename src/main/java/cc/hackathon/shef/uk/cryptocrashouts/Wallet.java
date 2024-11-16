package cc.hackathon.shef.uk.cryptocrashouts;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Map;

/**
 * Provides static methods to get the current balance of a given crypto wallet
 */
public class Wallet {

    /**
     * Gets the balance of a specified bitcoin wallet
     * @param walletId The wallet id
     * @return Balance of the wallet
     */
    public static double btcWalletValue(String walletId) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://rest.cryptoapis.io/blockchain-data/bitcoin/mainnet/addresses/" + walletId + "/balance")
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", Dotenv.configure().load().get("API_KEY"))
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, Map.class);

            // extract the amount of bitcoin
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            Map<String, Object> item = (Map<String, Object>) data.get("item");
            Map<String, Object> confirmedBalance = (Map<String, Object>) item.get("confirmedBalance");

            String balance = (String) confirmedBalance.get("amount");
            return Double.parseDouble(balance);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get the balance of an ethereum wallet
     * @param walletId Wallet address
     * @return Balance of the wallet
     */
    public static double ethWalletValue(String walletId) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://rest.cryptoapis.io/blockchain-data/ethereum/mainnet/addresses/0x00000000219ab540356cBB839Cbe05303d7705Fa/balance?context=yourExampleString")
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", Dotenv.configure().load().get("API_KEY"))
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, Map.class);

            // extract the amount of ethereum
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            Map<String, Object> item = (Map<String, Object>) data.get("item");
            Map<String, Object> confirmedBalance = (Map<String, Object>) item.get("confirmedBalance");

            String balance = (String) confirmedBalance.get("amount");
            return Double.parseDouble(balance);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static double bogeWalletValue(String walletId) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://rest.cryptoapis.io/blockchain-data/dogecoin/mainnet/addresses/DEgDVFa2DoW1533dxeDVdTxQFhMzs1pMke/balance?context=yourExampleString")
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", Dotenv.configure().load().get("API_KEY"))
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, Map.class);

            // extract the amount of doge
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            Map<String, Object> item = (Map<String, Object>) data.get("item");
            Map<String, Object> confirmedBalance = (Map<String, Object>) item.get("confirmedBalance");

            String balance = (String) confirmedBalance.get("amount");
            return Double.parseDouble(balance);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
