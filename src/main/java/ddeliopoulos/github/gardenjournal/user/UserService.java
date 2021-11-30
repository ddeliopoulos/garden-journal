package ddeliopoulos.github.gardenjournal.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();


    private final HttpServletRequest request;

    private final GoogleIdTokenVerifier verifier;

    @Autowired
    UserService(HttpServletRequest request,
                @Value("${google.auth.client_id}") String clientId) {
        this.request = request;
        log.info("using client ID {}", clientId);
        this.verifier = new GoogleIdTokenVerifier.Builder(TRANSPORT, JSON_FACTORY)
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(clientId))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();
    }

    public String getUserEmail() {
        return getUserEmail(getTokenFromRequest(request));
    }

    @SneakyThrows
    private GoogleIdToken getTokenFromRequest(final HttpServletRequest request) {
        String token = request.getHeader("X-Auth-Token");
        log.info("got token {}", token);
        return verifier.verify(token);
    }

    private String getUserEmail(GoogleIdToken token) {
        return Optional.ofNullable(token)
                       .map(GoogleIdToken::getPayload)
                       .map(GoogleIdToken.Payload::getEmail)
                       .orElseThrow(() -> new IllegalArgumentException("invalid token!"));
    }


}