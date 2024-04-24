package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloConfigTest {

    @Mock
    private TrelloConfig trelloConfig;

    @Test
    void shouldGetTrelloApiEndpoint() {
        //Given
        MockitoAnnotations.openMocks(this);
        String expectedApiEndpoint = "https://api.trello.com/1";
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn(expectedApiEndpoint);

        //When
        String testApiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        assertEquals(expectedApiEndpoint, testApiEndpoint);
    }

    @Test
    void shouldGetTrelloAppKey() {
        //Given
        MockitoAnnotations.openMocks(this);
        String expectedAppKey = "appKey";
        when(trelloConfig.getTrelloAppKey()).thenReturn(expectedAppKey);

        //When
        String testAppKey = trelloConfig.getTrelloAppKey();

        //Then
        assertEquals(expectedAppKey, testAppKey);
    }

    @Test
    void shouldGetTrelloToken() {
        //Given
        MockitoAnnotations.openMocks(this);
        String expectedToken = "token";
        when(trelloConfig.getTrelloToken()).thenReturn(expectedToken);

        //When
        String testToken = trelloConfig.getTrelloToken();

        //Then
        assertEquals(expectedToken, testToken);
    }

    @Test
    void shouldGetTrelloUsername() {
        //Given
        MockitoAnnotations.openMocks(this);
        String expectedUsername = "username";
        when(trelloConfig.getTrelloUsername()).thenReturn(expectedUsername);

        //When
        String testUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals(expectedUsername, testUsername);
    }
}
