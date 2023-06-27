package hr.fer.oop.zad2;

import java.util.Objects;

public class BasketballPlayer {
    private String name;
    private String surname;
    private double pointsAvg;
    private double assistsAvg;
    private double reboundsAvg;
    private int position;

    public BasketballPlayer(String name, String surname, double pointsAvg, double assistsAvg, double reboundsAvg, int position) {
        this.name = name;
        this.surname = surname;
        this.pointsAvg = pointsAvg;
        this.assistsAvg = assistsAvg;
        this.reboundsAvg = reboundsAvg;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getPointsAvg() {
        return pointsAvg;
    }

    public void setPointsAvg(double pointsAvg) {
        this.pointsAvg = pointsAvg;
    }

    public double getAssistsAvg() {
        return assistsAvg;
    }

    public void setAssistsAvg(double assistsAvg) {
        this.assistsAvg = assistsAvg;
    }

    public double getReboundsAvg() {
        return reboundsAvg;
    }

    public void setReboundsAvg(double reboundsAvg) {
        this.reboundsAvg = reboundsAvg;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasketballPlayer other) {
            return this.hashCode() == other.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + Objects.hash(surname) + Objects.hash(position);
    }

    @Override
    public String toString() {
        return String.format("%s %s(%d) [%.1f, %.1f, %.1f]", name, surname, position, pointsAvg, assistsAvg, reboundsAvg);
    }
}
