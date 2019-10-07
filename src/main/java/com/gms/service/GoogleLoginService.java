package com.gms.service;

import com.gms.domain.Account;
import com.gms.dto.AccountDetailDto;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@Service
public class GoogleLoginService {

    private static HttpTransport transport = new NetHttpTransport();
    private static JsonFactory jsonFactory = new JacksonFactory();

    private static final String CLIENT_ID_1 = "476310390299-pvf5n4a0l7mk42vdv1bt86i1ug72dhkd.apps.googleusercontent.com";
    private static GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            // Specify the CLIENT_ID of the app that accesses the backend:
//            .setAudience(Collections.singletonList(CLIENT_ID))
            // Or, if multiple clients access the backend:
            .setAudience(Arrays.asList(CLIENT_ID_1))
            .build();


    //returns email of google user if token is valid other wise returns null
    public String verifyGoogleIdToken(String idTokenString) throws GeneralSecurityException, IOException {
        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
            return email;
            // Use or store profile information
            // ...
//            accountService.findOrCreateAccountForGoogleUser(email, name);

        }
        System.out.println("Invalid ID token.");
        return null;

    }
}
