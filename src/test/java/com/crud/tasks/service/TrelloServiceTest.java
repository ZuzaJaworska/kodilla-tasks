package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void testFetchTrelloBoards() {
        // Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("id1");
        trelloBoardDto.setName("name1");
        List<TrelloBoardDto> trelloBoardDtos = List.of(trelloBoardDto);
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();

        //Then
        assertEquals(1, result.size());
        assertEquals("id1", result.get(0).getId());
        assertEquals("name1", result.get(0).getName());
    }

    @Test
    public void testCreateTrelloCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card Name", "description", "top", "id2");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("id", "card name", "url");
        when(trelloClient.createNewCard(any(TrelloCardDto.class))).thenReturn(createdTrelloCardDto);
        when(adminConfig.getAdminMail()).thenReturn("admin@admin.com");

        // When
        CreatedTrelloCardDto result = trelloService.createTrelloCard(trelloCardDto);

        // Then
        verify(trelloClient, times(1)).createNewCard(trelloCardDto);
        verify(simpleEmailService, times(1)).send(any(Mail.class));
        assertEquals("id", result.getId());
        assertEquals("card name", result.getName());
        assertEquals("url", result.getShortUrl());
    }
}
