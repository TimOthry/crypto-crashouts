package cc.hackathon.shef.uk.cryptocrashouts.controllers;
import cc.hackathon.shef.uk.cryptocrashouts.CryptoResponse;
import cc.hackathon.shef.uk.cryptocrashouts.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CryptoController {

    private final CryptoService cryptoService;

    @Autowired
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto")
    public String getCryptoData(Model model) {
        // Fetch crypto data (e.g., for Bitcoin)
        CryptoResponse response = cryptoService.getCryptoData("btc");

        if (response != null) {
            // Add response data to the model for use in the view
            model.addAttribute("crypto", response);
        } else {
            model.addAttribute("error", "Could not fetch crypto data.");
        }
        // Return the view name (e.g., crypto.html)
        return "crypto";
    }
}
