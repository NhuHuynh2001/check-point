package com.example.checkpoint.Service;

import com.example.checkpoint.Model.Request.ScoreRequest;
import com.example.checkpoint.Model.Response.ScoreResponse;
import com.example.checkpoint.Model.Response.StudentCheckResponse;

import java.util.List;

public interface ScoreService {

    ScoreResponse createScore(ScoreRequest scoreRequest) throws Exception;

    ScoreResponse findById(Integer id) throws Exception;

    List<ScoreResponse> findByAll();

    List<StudentCheckResponse> getStudent(Double score) throws Exception;
}
