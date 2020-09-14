package com.ylp.test.mapper;

import com.ylp.test.entity.TaskCron;

import java.util.List;

public interface TaskCronMapper {
    TaskCron getCronById(String id);
    List<TaskCron> queryAllTasks();
    String queryCron(String taskName);

}
