import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import java.time.LocalDate;  
  
@Entity  
public class HealthData {  
  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
  
    private double weight;  
    private double bloodPressure;  
    private double bloodSugar;  
    private LocalDate date;  
  
    // Getters and Setters  
}
