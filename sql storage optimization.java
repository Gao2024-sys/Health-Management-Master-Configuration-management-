import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class DatabaseConnection {  
    private static final String URL = "jdbc:mysql://localhost:3306/health_data";  
    private static final String USER = "root";  
    private static final String PASSWORD = "password";  
  
    public static Connection getConnection() throws SQLException {  
        return DriverManager.getConnection(URL, USER, PASSWORD);  
    }  
}
public class HealthRecord {  
    private String userId;  
    private float weight;  
    private float bloodPressure;  
    private float bloodSugar;  
  
    // Getters and Setters  
    public String getUserId() {  
        return userId;  
    }  
  
    public void setUserId(String userId) {  
        this.userId = userId;  
    }  
  
    public float getWeight() {  
        return weight;  
    }  
  
    public void setWeight(float weight) {  
        this.weight = weight;  
    }  
  
    public float getBloodPressure() {  
        return bloodPressure;  
    }  
  
    public void setBloodPressure(float bloodPressure) {  
        this.bloodPressure = bloodPressure;  
    }  
  
    public float getBloodSugar() {  
        return bloodSugar;  
    }  
  
    public void setBloodSugar(float bloodSugar) {  
        this.bloodSugar = bloodSugar;  
    }  
}
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
public class HealthRecordDAO {  
  
    public void saveRecord(HealthRecord record) throws SQLException {  
        String sql = "INSERT INTO health_records (user_id, weight, blood_pressure, blood_sugar) VALUES (?, ?, ?, ?)";  
          
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {  
              
            preparedStatement.setString(1, record.getUserId());  
            preparedStatement.setFloat(2, record.getWeight());  
            preparedStatement.setFloat(3, record.getBloodPressure());  
            preparedStatement.setFloat(4, record.getBloodSugar());  
              
            preparedStatement.executeUpdate();  
        }  
    }  
  
    public List<HealthRecord> getRecords(String userId) throws SQLException {  
        List<HealthRecord> records = new ArrayList<>();  
        String sql = "SELECT * FROM health_records WHERE user_id = ?";  
          
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {  
              
            preparedStatement.setString(1, userId);  
            ResultSet resultSet = preparedStatement.executeQuery();  
              
            while (resultSet.next()) {  
                HealthRecord record = new HealthRecord();  
                record.setUserId(resultSet.getString("user_id"));  
                record.setWeight(resultSet.getFloat("weight"));  
                record.setBloodPressure(resultSet.getFloat("blood_pressure"));  
                record.setBloodSugar(resultSet.getFloat("blood_sugar"));  
                records.add(record);  
            }  
        }  
          
        return records;  
    }  
}
public class Main {  
    public static void main(String[] args) {  
        HealthRecordDAO dao = new HealthRecordDAO();  
          
        // 模拟接收到的数据  
        HealthRecord record1 = new HealthRecord();  
        record1.setUserId("user1");  
        record1.setWeight(70.5f);  
        record1.setBloodPressure(120.0f);  
        record1.setBloodSugar(90.0f);  
          
        try {  
            dao.saveRecord(record1);  
              
            // 查询历史记录  
            List<HealthRecord> records = dao.getRecords("user1");  
            for (HealthRecord record : records) {  
                System.out.println("User ID: " + record.getUserId());  
                System.out.println("Weight: " + record.getWeight());  
                System.out.println("Blood Pressure: " + record.getBloodPressure());  
                System.out.println("Blood Sugar: " + record.getBloodSugar());  
                System.out.println("------------------");  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}