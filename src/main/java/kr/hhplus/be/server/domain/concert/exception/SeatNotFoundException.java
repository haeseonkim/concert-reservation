package kr.hhplus.be.server.domain.concert.exception;

public class SeatNotFoundException extends RuntimeException{
    public SeatNotFoundException(Long seatId) {
        super("Seat with ID " + seatId + " not found.");
    }
}