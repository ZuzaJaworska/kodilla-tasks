package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Autowired
    private TaskRepository taskRepository;

    @AfterEach
    void cleanUp() {
        taskRepository.deleteAll();
    }

    @Test
    void shouldSaveTaskAndGetTaskById() throws TaskNotFoundException {
        //Given
        Task task = new Task("Title", "Content");

        //When
        dbService.saveTask(task);
        Task savedTask = dbService.getTask(task.getId());

        //Then
        assertNotNull(savedTask);
        assertEquals(task, savedTask);
    }

    @Test
    void shouldGetAllTasks() {
        //Given
        Task task1 = new Task("Title1", "Content1");
        Task task2 = new Task("Title2", "Content2");
        dbService.saveTask(task1);
        dbService.saveTask(task2);

        //When
        List<Task> tasks = dbService.getAllTasks();

        //Then
        assertEquals(2, tasks.size());
        assertEquals(task1.getTitle(), tasks.get(0).getTitle());
    }

    @Test
    void shouldDeleteTask() {
        //Given
        Task task1 = new Task("Title1", "Content1");
        Task task2 = new Task("Title2", "Content2");
        dbService.saveTask(task1);
        dbService.saveTask(task2);

        //When
        dbService.deleteTask(task1.getId());
        List<Task> tasks = dbService.getAllTasks();

        //Then
        assertEquals(1, tasks.size());
        assertFalse(taskRepository.existsById(task1.getId()));
        assertTrue(taskRepository.existsById(task2.getId()));
    }

    @Test
    void shouldThrowExceptionIfTaskNotFound() {
        //Given
        Long taskId = 1L;

        //When & Then
        assertThrows(TaskNotFoundException.class, () -> dbService.getTask(taskId));
    }
}
