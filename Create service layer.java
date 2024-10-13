
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import java.time.LocalDate;  
import java.util.List;  
  
@Service  
public class HealthDataService {  
  
    @Autowired  
    private HealthDataRepository healthDataRepository;  
  
    public void saveHealthData(double weight, double bloodPressure, double bloodSugar, LocalDate date) {  
        HealthData healthData = new HealthData();  
        healthData.setWeight(weight);  
        healthData.setBloodPressure(bloodPressure);  
        healthData.setBloodSugar(bloodSugar);  
        healthData.setDate(date);  
        healthDataRepository.save(healthData);  
    }  
  
    public List<HealthData> getAllHealthData() {  
        return healthDataRepository.findAll();  
    }  
  
    public double calculateBMI(double weight, double height) {  
        return weight / (height * height);  
    }  
  
    // Add more methods for health risk assessment, etc.  
}