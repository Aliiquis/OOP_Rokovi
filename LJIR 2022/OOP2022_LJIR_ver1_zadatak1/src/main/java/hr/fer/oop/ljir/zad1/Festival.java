package hr.fer.oop.ljir.zad1;

import java.util.Arrays;

public class Festival extends MusicEvent {
    private int duration;
    private TicketType[] tickets;

    public Festival(String[] lineup, double price, int duration, TicketType[] tickets) {
        super(lineup, price);
        this.duration = duration;
        this.tickets = tickets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TicketType[] getTickets() {
        return tickets;
    }

    public void setTickets(TicketType[] tickets) {
        this.tickets = tickets;
    }

    @Override
    public String checkLineup() {
        return getLineup().length >= duration ? "Lineup:" + Arrays.toString(getLineup()) : "Add artists to lineup.";
    }

    @Override
    public double calculatePrice() {
        int sum = 0;
        for (TicketType ticket : tickets) {
            switch (ticket) {
                case MULTI_DAY_PASSES -> sum += getPrice() * duration * 0.8;
                case DAILY_TICKET -> sum += getPrice();
                case VIP -> sum += getPrice() * duration * 2;
            }
        }
        return sum;
    }
}
