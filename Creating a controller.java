import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.*;  
  
import java.time.LocalDate;  
import java.util.List;  
  
@RestController  
@RequestMapping("/api/health")  
public class HealthDataController {  
  
    @Autowired  
    private HealthDataService healthDataService;  
  
    @PostMapping("/submit")  
    public void submitHealthData(@RequestParam double weight,  
                                 @RequestParam double bloodPressure,  
                                 @RequestParam double bloodSugar,  
                                 @RequestParam LocalDate date) {  
        healthDataService.saveHealthData(weight, bloodPressure, bloodSugar, date);  
    }  
  
    @GetMapping("/history")  
    public List<HealthData> getHealthHistory() {  
        return healthDataService.getAllHealthData();  
    }  
  
    @GetMapping("/bmi")  
    public double calculateBMI(@RequestParam double weight, @RequestParam double height) {  
        return healthDataService.calculateBMI(weight, height);  
    }  
  
    // Add more endpoints for health risk assessment, etc.  
}