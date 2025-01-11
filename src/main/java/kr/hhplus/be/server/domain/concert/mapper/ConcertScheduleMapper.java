package kr.hhplus.be.server.domain.concert.mapper;

import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper
public interface ConcertScheduleMapper {
    ConcertScheduleMapper INSTANCE = Mappers.getMapper(ConcertScheduleMapper.class);

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Mapping(target = "date", expression = "java(scheduleProjection.getScheduleDate().format(FORMATTER))")
    AvailableDateResponse toResponse(ConcertScheduleProjection scheduleProjection);

    List<AvailableDateResponse> toResponseList(List<ConcertScheduleProjection> scheduleProjections);
}
