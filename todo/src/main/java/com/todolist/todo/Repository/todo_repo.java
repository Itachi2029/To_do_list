package com.todolist.todo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todolist.todo.Models.todolist_model;

@Repository
public interface todo_repo extends JpaRepository<todolist_model, Integer> {
    @Query("select t from todolist_model t where t.usename LIKE %:usename%")
    public List<todolist_model> findtodobyUsername(@Param("usename") String usename);

}
