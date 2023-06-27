package hr.fer.oop.zad1;

public class WeatherToday extends Weather implements WeatherTodayImpl {
    private int day;
    private int month;
    private int year;
    private String sunset;
    private String sunrise;

    public WeatherToday(double[] data, Unit unit, int day, int month, int year, String sunrise, String sunset) {
        super(data, unit);
        this.day = day;
        this.month = month;
        this.year = year;
        this.sunset = sunset;
        this.sunrise = sunrise;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public static double getTempInCelsius(double fahrenheit) {
        return ((5 * (fahrenheit - 32.0)) / 9.0);
    }

    @Override
    public String makeDescription() {
        return String.format("WeatherToday [day=%s, daylightHours=%s, average=%.2f]", dateFormat(), daylight(), getUnit() == Unit.F ? getTempInCelsius(Calculation.calculateAverage(getData())) : Calculation.calculateAverage(getData()));
    }

    @Override
    public boolean avgAboveThold(double thold) {
        double[] data = getData();
        if (getUnit() == Unit.F) {
            for (int i = 0; i < data.length; i++) {
                data[i] = getTempInCelsius(data[i]);
            }
        }
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length >= thold;
    }

    @Override
    public String daylight() {
        int hrise, hset;
        int mrise, mset;
        hrise = Integer.parseInt(sunrise.substring(0, 2));
        hset = Integer.parseInt(sunset.substring(0, 2));
        mrise = Integer.parseInt(sunrise.substring(3));
        mset = Integer.parseInt(sunset.substring(3));
        int hlight = hset - hrise;
        int mlight = mset - mrise;
        if (mlight < 0) {
            mlight = 60 + mlight;
            hlight--;
        }
        return (hlight / 10 == 0 ? "0" + hlight : hlight)
                + ":" +
                (mlight / 10 == 0 ? "0" + mlight : mlight);
    }

    @Override
    public String dateFormat() {
        return year + "-" +
                (month / 10 == 0 ? "0" + month : month)
                + "-" +
                (day / 10 == 0 ? "0" + day : day);
    }
}