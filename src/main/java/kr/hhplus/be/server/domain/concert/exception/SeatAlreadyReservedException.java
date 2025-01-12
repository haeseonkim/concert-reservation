package kr.hhplus.be.server.domain.concert.exception;

public class SeatAlreadyReservedException extends RuntimeException{
    public SeatAlreadyReservedException(Long seatId) {
        super("Seat with ID " + seatId + " is already reserved or unavailable.");
    }
}
