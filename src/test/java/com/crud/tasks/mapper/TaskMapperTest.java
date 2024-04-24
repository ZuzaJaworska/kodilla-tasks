package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "title", "content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    void shouldMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        List<Task> tasksList = List.of(task1, task2);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasksList);

        //Then
        assertEquals(2, taskDtoList.size());
        assertEquals(task1.getId(), taskDtoList.get(0).getId());
        assertEquals(task2.getId(), taskDtoList.get(1).getId());
        assertEquals(task1.getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(task2.getTitle(), taskDtoList.get(1).getTitle());
    }
}
