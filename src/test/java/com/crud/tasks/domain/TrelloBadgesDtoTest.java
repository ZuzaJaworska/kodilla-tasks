package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloBadgesDtoTest {

    @InjectMocks
    private TrelloBadgesDto trelloBadgesDto;

    @Mock
    private TrelloAttachmentsByTypeDto attachmentsByTypeDto;

    @Test
    public void testTrelloBadgesDtoVotes() {
        // Given
        MockitoAnnotations.openMocks(this);
        trelloBadgesDto.setVotes(10);

        // Then
        assertEquals(10, trelloBadgesDto.getVotes());
    }

    @Test
    public void testTrelloBadgesDtoAttachments() {
        // Given
        MockitoAnnotations.openMocks(this);
        trelloBadgesDto.setAttachments(attachmentsByTypeDto);

        // When
        when(attachmentsByTypeDto.getTrello()).thenReturn(null);

        // Then
        assertNull(trelloBadgesDto.getAttachments().getTrello());
    }
}
