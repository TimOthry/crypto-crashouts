package cc.hackathon.shef.uk.cryptocrashouts;
import cc.hackathon.shef.uk.cryptocrashouts.CryptoData;
import cc.hackathon.shef.uk.cryptocrashouts.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/api/crypto")
    public CryptoData getCryptoData(@RequestParam String symbol) {
        return cryptoService.getCryptoData(symbol);
    }
}
