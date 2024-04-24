package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminConfigTest {

    @Mock
    private AdminConfig adminConfig;

    @Test
    void shouldGetAdminMail() {
        //Given
        MockitoAnnotations.openMocks(this);
        String expectedAdminMail = "admin@admin.com";
        when(adminConfig.getAdminMail()).thenReturn(expectedAdminMail);

        //When
        String actualAdminMail = adminConfig.getAdminMail();

        //Then
        assertEquals(expectedAdminMail, actualAdminMail);
    }
}
