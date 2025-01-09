package kr.hhplus.be.server.mapper;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.dto.QueueTokenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QueueTokenMapper {
    QueueTokenMapper INSTANCE = Mappers.getMapper(QueueTokenMapper.class);

    QueueTokenDTO.CreateQueueTokenResponse toWebDto(QueueToken queueToken);
}
