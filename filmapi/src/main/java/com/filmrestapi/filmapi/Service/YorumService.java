package com.filmrestapi.filmapi.Service;

import com.filmrestapi.filmapi.dto.YorumDto;
import com.filmrestapi.filmapi.entity.Yorum;
import com.filmrestapi.filmapi.repository.YorumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class YorumService {
    @Autowired
    YorumRepository yorumRepository;

    public List<YorumDto> getAll() {
        List<Yorum>YorumList = yorumRepository.findAll();
        return (List<YorumDto>) YorumList.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public YorumDto fromEntityToDto(Yorum yorum) {
        YorumDto yorumDto = new YorumDto(yorum.getFid(), yorum.getUser(), yorum.getIcerig());
        return yorumDto;
    }

    public List<YorumDto>getFilmID(Integer FilmID){
        List<Yorum> YorumList = yorumRepository.findByfid(FilmID);
        return (List<YorumDto>) YorumList.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public void saveNewYorum(YorumDto yorumDto){
        Yorum yorum = fromDtoToEntity(yorumDto);
        yorumRepository.save(yorum);
    }

    public Yorum fromDtoToEntity(YorumDto yorumDto){
        Yorum yorum = new Yorum(yorumDto.getFid(), yorumDto.getUser(), yorumDto.getIcerig());
        return yorum;
    }
}
