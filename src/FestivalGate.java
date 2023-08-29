import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FestivalGate {
    private final BlockingQueue<TicketType> ticketsQueue;

    public FestivalGate() {
        ticketsQueue = new ArrayBlockingQueue<>(1000); // arbitrary capacity
    }

    public void validateTicket(TicketType ticketType) {
        ticketsQueue.add(ticketType);
    }

    public BlockingQueue<TicketType> getTicketsQueue() {
        return ticketsQueue;
    }
}