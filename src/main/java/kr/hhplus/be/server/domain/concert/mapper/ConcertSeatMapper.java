package kr.hhplus.be.server.domain.concert.mapper;

import kr.hhplus.be.server.domain.concert.model.ConcertSeat;
import kr.hhplus.be.server.domain.concert.model.ConcertSeatProjection;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConcertSeatMapper {
    ConcertSeatMapper INSTANCE = Mappers.getMapper(ConcertSeatMapper.class);

    AvailableSeatResponse toResponse(ConcertSeatProjection seatProjection);

    List<AvailableSeatResponse> toResponseList(List<ConcertSeatProjection> seatProjections);

    ReservationResponse toReservationResponse(ConcertSeat concertSeat);
}
