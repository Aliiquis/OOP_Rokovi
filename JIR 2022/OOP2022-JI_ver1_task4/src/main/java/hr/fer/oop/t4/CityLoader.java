package hr.fer.oop.t4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CityLoader {

    public static List<City> load(String path) {

        Path filePath = Path.of(path);

        List<City> list = new ArrayList<>();

        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            String[] args = line.split("\"\",\"\"");
            String name = args[0].substring(1, args[0].indexOf(","));
            String asciiName = args[0].substring(args[0].indexOf("\"\"") + 2);
            double lat = Double.parseDouble(args[1]);
            double lng = Double.parseDouble(args[2]);
            String countryName = args[3];
            String countryISO2 = args[4];
            String countryISO3 = args[5];
            CityType capitalType;
            if (args[7].equals("primary")) capitalType = CityType.PRIMARY;
            else if (args[7].equals("minor")) capitalType = CityType.MINOR;
            else if (args[7].equals("unknown")) capitalType = CityType.UNKNOWN;
            else capitalType = null;
            int population = Integer.parseInt(args[8]);
            int id = Integer.parseInt(args[9].substring(0, args[9].length() - 3));
            list.add(new City(
                    name,
                    asciiName,
                    lat,
                    lng,
                    countryName,
                    countryISO2,
                    countryISO3,
                    capitalType,
                    population,
                    id
            ));
        }

        return list;

    }
}
