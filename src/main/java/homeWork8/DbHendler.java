package homeWork8;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHendler implements AutoCloseable {
    private final static String Path_DB =
            "jdbc:sqlite:C:\\Users\\Светлана\\IdeaProjects\\NewProject\\src\\main\\resources\\WeatherToday.db";

    private final Connection connection;

    public DbHendler() throws SQLException {

        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(Path_DB);
    }

    public void addDayWeather(DayWeather dayWeather) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO WeatherTodayTable " +
                "('cityName', 'date', 'tempMin', 'tempMax') " +
                "VALUES (?, ?, ?, ?)")) {
            statement.setObject(1, dayWeather.getNameCity());
            statement.setObject(2, dayWeather.getDate());
            statement.setObject(3, dayWeather.getTempMin());
            statement.setObject(4, dayWeather.getTempMax());
            statement.execute();
        }
    }

    public void deleteDayWeather(int id) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM WeatherTodayTable WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        }
    }

    public List<DayWeather> getAllDays() throws SQLException {
        List<DayWeather> dayWeathers = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM WeatherTodayTable")) {
                while (resultSet.next()) {
                    String cityName = resultSet.getString("cityName");
                    String date = resultSet.getString("date");
                    double tempMin = resultSet.getDouble("tempMin");
                    double tempMax = resultSet.getDouble("tempMax");

                    DayWeather dayWeather = new DayWeather(cityName, date, tempMin, tempMax);
                    dayWeathers.add(dayWeather);
                }
            }
        }
        return dayWeathers;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
