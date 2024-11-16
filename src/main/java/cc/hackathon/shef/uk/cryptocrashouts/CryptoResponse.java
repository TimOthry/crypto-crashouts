package cc.hackathon.shef.uk.cryptocrashouts;

public class CryptoResponse {
    private String apiVersion;
    private String requestId;
    private String context;
    private CryptoData data;  // Contains the 'item' object
    private Object error;

    // Getters and Setters
    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public CryptoData getData() {
        return data;
    }

    public void setData(CryptoData data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
