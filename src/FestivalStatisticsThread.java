import java.util.concurrent.BlockingQueue;

class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // Generate statistics every 5 seconds
                BlockingQueue<TicketType> ticketsQueue = gate.getTicketsQueue();
                int totalParticipants = ticketsQueue.size();
                int fullCount = 0, fullVipCount = 0, freePassCount = 0, oneDayCount = 0, oneDayVipCount = 0;

                for (TicketType ticket : ticketsQueue) {
                    switch (ticket) {
                        case FULL:
                            fullCount++;
                            break;
                        case FULL_VIP:
                            fullVipCount++;
                            break;
                        case FREE_PASS:
                            freePassCount++;
                            break;
                        case ONE_DAY:
                            oneDayCount++;
                            break;
                        case ONE_DAY_VIP:
                            oneDayVipCount++;
                            break;
                    }
                }

                System.out.println("Statistics:\n" +
                        "Total Participants: " + totalParticipants + "\n" +
                        "Full Tickets: " + fullCount + "\n" +
                        "Full VIP Tickets: " + fullVipCount + "\n" +
                        "Free Passes: " + freePassCount + "\n" +
                        "One Day Tickets: " + oneDayCount + "\n" +
                        "One Day VIP Tickets: " + oneDayVipCount + "\n");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}