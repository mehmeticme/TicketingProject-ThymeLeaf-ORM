
package com.practice.converter;

import com.practice.dto.TaskDTO;
import com.practice.service.TaskService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDTOConverter implements Converter<String, TaskDTO> {

    private TaskService taskService;

    public TaskDTOConverter(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDTO convert(String source) {
        Long id = Long.parseLong(source);
        return taskService.findById(id);
    }
}