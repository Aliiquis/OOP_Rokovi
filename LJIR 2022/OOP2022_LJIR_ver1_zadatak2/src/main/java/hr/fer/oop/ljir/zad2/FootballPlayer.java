package hr.fer.oop.ljir.zad2;

import java.util.Objects;

class FootballPlayer {
    private String name;
    private String surname;
    private int shootingSkill;
    private int dribblingSkill;
    private int passingSkill;
    private int overallSkill;

    public FootballPlayer(String name, String surname, int shootingSkill, int dribblingSkill, int passingSkill) {
        this.name = name;
        this.surname = surname;
        this.shootingSkill = shootingSkill;
        this.dribblingSkill = dribblingSkill;
        this.passingSkill = passingSkill;
        this.overallSkill = (shootingSkill + dribblingSkill + passingSkill) / 3;
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

    public int getShootingSkill() {
        return shootingSkill;
    }

    public void setShootingSkill(int shootingSkill) {
        this.shootingSkill = shootingSkill;
    }

    public int getDribblingSkill() {
        return dribblingSkill;
    }

    public void setDribblingSkill(int dribblingSkill) {
        this.dribblingSkill = dribblingSkill;
    }

    public int getPassingSkill() {
        return passingSkill;
    }

    public void setPassingSkill(int passingSkill) {
        this.passingSkill = passingSkill;
    }

    public int getOverallSkill() {
        return overallSkill;
    }

    public void setOverallSkill(int overallSkill) {
        this.overallSkill = overallSkill;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FootballPlayer player) {
            return this.hashCode() == player.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + Objects.hash(surname);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %d", name, surname, overallSkill);
    }
}
