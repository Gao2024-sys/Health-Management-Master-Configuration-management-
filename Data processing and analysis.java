import java.util.Scanner;  
  
public class HealthDataAnalysis {  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
  
        // 输入身高和体重  
        System.out.print("请输入身高（米）：");  
        double height = scanner.nextDouble();  
  
        System.out.print("请输入体重（千克）：");  
        double weight = scanner.nextDouble();  
  
        // 计算BMI  
        double bmi = calculateBMI(weight, height);  
  
        // 输出BMI  
        System.out.printf("您的BMI为：%.2f\n", bmi);  
  
        // 评估健康风险  
        String healthRisk = assessHealthRisk(bmi);  
  
        // 输出健康风险评估  
        System.out.println("健康风险评估：" + healthRisk);  
  
        scanner.close();  
    }  
  
    // 计算BMI的方法  
    public static double calculateBMI(double weight, double height) {  
        return weight / (height * height);  
    }  
  
    // 评估健康风险的方法  
    public static String assessHealthRisk(double bmi) {  
        if (bmi < 18.5) {  
            return "偏瘦";  
        } else if (bmi >= 18.5 && bmi < 24.9) {  
            return "正常";  
        } else if (bmi >= 25 && bmi < 29.9) {  
            return "超重";  
        } else {  
            return "肥胖";  
        }  
    }  
}