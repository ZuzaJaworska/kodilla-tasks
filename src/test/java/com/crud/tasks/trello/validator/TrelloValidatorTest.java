package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrelloValidatorTest {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    void shouldValidateCard() {
        // Given
        TrelloCard trelloCard = new TrelloCard("name", "desc", "top", "id1");
        TrelloCard testCard = new TrelloCard("test", "testdesc", "top", "id2");

        //When & Then
        trelloValidator.validateCard(trelloCard);
        trelloValidator.validateCard(testCard);
        //check logs
    }

    @Test
    void shouldValidateTrelloBoards() {
        // Given
        TrelloBoard trelloBoard = new TrelloBoard("id1", "name", new ArrayList<>());
        TrelloBoard testBoard = new TrelloBoard("id2", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoards = List.of(trelloBoard, testBoard);

        //When
        List<TrelloBoard> validatedBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, validatedBoards.size());
        assertTrue(validatedBoards.contains(trelloBoard));
        assertFalse(validatedBoards.contains(testBoard));
        //check logs
    }
}
