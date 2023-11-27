package com.example.checkpoint.Service;

import com.example.checkpoint.Entity.ScoreEntity;
import com.example.checkpoint.Exception.BadRequestException;
import com.example.checkpoint.Exception.ResponseException;
import com.example.checkpoint.Mapper.ScoreMapper;
import com.example.checkpoint.Model.Request.ScoreRequest;
import com.example.checkpoint.Model.Response.Response;
import com.example.checkpoint.Model.Response.ScoreResponse;
import com.example.checkpoint.Model.Response.StudentCheckResponse;
import com.example.checkpoint.Repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    private final ScoreRepository scoreRepository;

    //private final RestTemplate restTemplate;


    @Override
    public ScoreResponse createScore(ScoreRequest scoreRequest) throws Exception {
        ScoreEntity scoreEntity = scoreMapper.toEntity(scoreRequest);
        return scoreMapper.toResponse(scoreRepository.save(scoreEntity));
    }

    @Override
    public ScoreResponse findById(Integer id) throws Exception {
        Optional<ScoreEntity> scoreEntityOptional = scoreRepository.findById(id);
        if (scoreEntityOptional.isPresent()) {
            throw new ResponseException(BadRequestException.SCORE_NOT_FOUND.getMessage(), BadRequestException.SCORE_NOT_FOUND.getErrorCode());

        }
        ScoreEntity PointEntity = scoreEntityOptional.get();
        ScoreResponse scoreResponse = scoreMapper.toResponse(PointEntity);
        return scoreResponse;
    }

    @Override
    public List<ScoreResponse> findByAll() {
        List<ScoreEntity> pointEntities = scoreRepository.findAll();
        List<ScoreResponse> pointResponses = scoreMapper.toResponses(pointEntities);
        return pointResponses;
    }


    @Override
    public List<StudentCheckResponse> getStudent(Double score) throws Exception {
        List<ScoreEntity> scoreEntities = scoreRepository.findByScore(score);

        if (scoreEntities.isEmpty()){
            throw new ResponseException(BadRequestException.SCORE_NOT_FOUND.getMessage() , BadRequestException.SCORE_NOT_FOUND.getErrorCode());
        }
        List<StudentCheckResponse> studentResponseList = new ArrayList<>();
        for (ScoreEntity item:scoreEntities) {
            StudentCheckResponse studentResponse = new StudentCheckResponse();
            studentResponse.setStudentId(item.getStudentId());
            studentResponse.setScore(item.getScore());
            StudentCheckResponse response = getStudentList(studentResponse.getStudentId());
            studentResponse.setName(response.getName());
            studentResponse.setGender(response.getGender());
            studentResponse.setClassRoom(response.getClassRoom());
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    public StudentCheckResponse getStudentList(Integer studentId) {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        String x = UriComponentsBuilder.fromHttpUrl("http://localhost:8001/api/v1/"+ studentId).toUriString();

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Response<StudentCheckResponse>> xxx = new RestTemplate().exchange(x,
                HttpMethod.GET,
                entity, new ParameterizedTypeReference<>() {});
        return xxx.getBody().getData();
    }
}
