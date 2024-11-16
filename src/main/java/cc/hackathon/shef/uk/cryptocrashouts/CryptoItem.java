package cc.hackathon.shef.uk.cryptocrashouts;

public class CryptoItem {
    private long calculationTimestamp;
    private String fromAssetId;
    private String fromAssetSymbol;
    private String rate;
    private String toAssetId;
    private String toAssetSymbol;

    // Getters and Setters
    public long getCalculationTimestamp() {
        return calculationTimestamp;
    }

    public void setCalculationTimestamp(long calculationTimestamp) {
        this.calculationTimestamp = calculationTimestamp;
    }

    public String getFromAssetId() {
        return fromAssetId;
    }

    public void setFromAssetId(String fromAssetId) {
        this.fromAssetId = fromAssetId;
    }

    public String getFromAssetSymbol() {
        return fromAssetSymbol;
    }

    public void setFromAssetSymbol(String fromAssetSymbol) {
        this.fromAssetSymbol = fromAssetSymbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getToAssetId() {
        return toAssetId;
    }

    public void setToAssetId(String toAssetId) {
        this.toAssetId = toAssetId;
    }

    public String getToAssetSymbol() {
        return toAssetSymbol;
    }

    public void setToAssetSymbol(String toAssetSymbol) {
        this.toAssetSymbol = toAssetSymbol;
    }
}
