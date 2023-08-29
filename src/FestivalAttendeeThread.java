import java.util.Random;

class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        gate.validateTicket(ticketType);
        try {
            Thread.sleep(new Random().nextInt(100)); // Simulate random processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
