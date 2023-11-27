package com.example.checkpoint.Mapper;

import com.example.checkpoint.Entity.ScoreEntity;
import com.example.checkpoint.Model.Request.ScoreRequest;
import com.example.checkpoint.Model.Response.ScoreResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScoreMapper {

    private final ModelMapper modelMapper;

    public ScoreEntity toEntity (ScoreRequest scoreRequest){
        ScoreEntity scoreEntity = modelMapper.map(scoreRequest , ScoreEntity.class);
        return  scoreEntity;
    }

    public ScoreResponse toResponse(ScoreEntity scoreEntity){
        ScoreResponse studentManagementResponse = modelMapper.map(scoreEntity , ScoreResponse.class);
        return studentManagementResponse;
    }
 
    public  List<ScoreResponse> toResponses(List<ScoreEntity> scoreEntities){
        List<ScoreResponse> scoreResponses = new ArrayList<>();
        for (ScoreEntity entity: scoreEntities) {
            scoreResponses.add(this.toResponse(entity));
        }
        return scoreResponses;
    }

}
