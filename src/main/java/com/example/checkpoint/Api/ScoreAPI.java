package com.example.checkpoint.Api;

import com.example.checkpoint.Model.Request.ScoreRequest;
import com.example.checkpoint.Model.Response.ScoreResponse;
import com.example.checkpoint.Model.Response.Response;
import com.example.checkpoint.Model.Response.StudentCheckResponse;
import com.example.checkpoint.Service.ScoreService;
import com.example.checkpoint.Utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.API_VERSION )
@RequiredArgsConstructor
public class ScoreAPI {

    private final ScoreService scoreService;

    @PostMapping()
    Response<ScoreResponse> createStudent(@RequestBody ScoreRequest scoreRequest) throws Exception {
        return new  Response<> (scoreService.createScore(scoreRequest));
    }

    @GetMapping("/{id}")
    Response<ScoreResponse> findById(@PathVariable Integer id) throws Exception {
        return new  Response<>(scoreService.findById(id));
    }

    @GetMapping(Constants.CHECK_SCORE)
    List<ScoreResponse> getAll() {
        return scoreService.findByAll();
    }


    @GetMapping(Constants.LIST_STUDENT)
    Response<List<StudentCheckResponse>> getStudent(@RequestParam Double score) throws Exception{
        return new  Response<> (scoreService.getStudent(score));
    }
}
