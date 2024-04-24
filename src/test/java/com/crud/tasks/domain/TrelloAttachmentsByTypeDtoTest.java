package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloAttachmentsByTypeDtoTest {

    @InjectMocks
    private TrelloAttachmentsByTypeDto trelloAttachmentsByTypeDto;

    @Test
    public void shouldTrelloAttachmentsByTypeDto() {
        // Given
        TrelloDto trello = new TrelloDto();
        trello.setBoard(1);
        trello.setCard(1);
        trelloAttachmentsByTypeDto.setTrello(trello);

        // When
        TrelloDto attachedTrello = trelloAttachmentsByTypeDto.getTrello();

        // Then
        assertEquals(1, attachedTrello.getBoard());
        assertEquals(1, attachedTrello.getCard());
    }
}
