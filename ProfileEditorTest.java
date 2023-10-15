package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ProfileEditorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        System.out.println();
    }


    @Test
    void validNameValidDescription() {
        //"Login" to profile by creating profile object
        String userName = "user";
        ProfileEditor.Profile userProfile = new ProfileEditor.Profile(userName);

        //Case 1: Test profile editor with valid name and valid description
        System.out.println("VALID name, VALID description:");
        assertTrue(userProfile.updateProfile("John Smith", "Hello"));

    }

    @Test
    void validNameInvalidDescription() {

        //Very long string to test invalid profile description
        String veryLongString = "hello".repeat(100);

        //"Login" to profile by creating profile object
        String userName = "user";
        ProfileEditor.Profile userProfile = new ProfileEditor.Profile(userName);

        //Case 2: Test profile editor with valid name and invalid description
        System.out.println("VALID name, INVALID description:");
        assertFalse(userProfile.updateProfile("John Smith", veryLongString));

    }

    @Test
    void validNameExceptionDescription() {
        //"Login" to profile by creating profile object
        String userName = "user";
        ProfileEditor.Profile userProfile = new ProfileEditor.Profile(userName);

        //Case 3: Test profile editor with valid name and exception description
        System.out.println("VALID name, EXCEPTION description:");
        assertThrows(IllegalArgumentException.class, ()->{
            userProfile.updateProfile("John Smith", " ");
        });
    }

    @Test
    void invalidNameValidDescription() {
        //"Login" to profile by creating profile object
        String userName = "user";
        ProfileEditor.Profile userProfile = new ProfileEditor.Profile(userName);

        //Case 4: Test profile editor with invalid name and valid description
        System.out.println("INVALID name, VALID description:");
        assertFalse(userProfile.updateProfile("12345", "Hello"));

    }

    @Test
    void exceptionNameValidDescription() {
        //"Login" to profile by creating profile object
        String userName = "user";
        ProfileEditor.Profile userProfile = new ProfileEditor.Profile(userName);

        //Case 7: Test profile editor with exception name and valid description
        System.out.println("EXCEPTION name, VALID description:");
        assertThrows(Exception.class, ()-> {
           userProfile.updateProfile(" ", "Hello");
        });

    }


}
