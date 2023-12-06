package app.sinulingga.thirdparty;

import app.sinulingga.thirdparty.service.NotSuccessException;
import app.sinulingga.thirdparty.service.SimpleThirdPartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class ThirdpartyApplication {
	private static final Logger log = LoggerFactory.getLogger(ThirdpartyApplication.class);


	public static void main(String[] args) {
		try {
			SimpleThirdPartyService service = new SimpleThirdPartyService();
			// see implementation doRequest() for more detail;
			service.doRequest();
		} catch (Exception e) {
			log.info("Exception: " + e.getMessage());
		}
	}

}
