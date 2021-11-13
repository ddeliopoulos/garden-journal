package ddeliopoulos.github.gardenjournal.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {

    private static final String CLIENT_ID = "826903811377-7vc3unief3g7bbn341cr06kbfvbb49no.apps.googleusercontent.com";
    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private final static GoogleIdTokenVerifier VERIFIER = new GoogleIdTokenVerifier.Builder(TRANSPORT, JSON_FACTORY)
            // Specify the CLIENT_ID of the app that accesses the backend:
            .setAudience(Collections.singletonList(CLIENT_ID))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

    private final HttpServletRequest request;

    public String getUserEmail() {
        return getUserEmail(getTokenFromRequest(request));
    }

    @SneakyThrows
    private GoogleIdToken getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("X-Auth-Token");
        return VERIFIER.verify(token);
    }
    private String getUserEmail(GoogleIdToken token) {
        if (token != null) {
            Payload payload = token.getPayload();

            // Print user identifier

            String email = payload.getEmail();
            boolean emailVerified = payload.getEmailVerified();
            if (emailVerified) {
                throw new IllegalArgumentException("user account not verified");
            }
            return email;
        } else {
            throw new IllegalArgumentException("invalid token!");
        }
    }


}