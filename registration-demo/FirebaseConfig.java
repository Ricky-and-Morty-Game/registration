package com.example.registrationdemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

// Configurtation for Firebase Connection
public class FirebaseConfig {
    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        // Directory to a JSON file pulled from Firebase settings, this should be placed in the project directory
        InputStream serviceAcc = getClass().getResourceAsStream("rickandmorty-434ab-firebase-adminsdk-3ngbs-054c91de4c.json");
        // Initialized Firebase Options with credentials and direct link to Firebase Database
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAcc))
                .setDatabaseUrl("https://rickandmorty-434ab-default-rtdb.firebaseio.com/")
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
