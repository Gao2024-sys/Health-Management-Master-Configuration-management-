import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartUtils;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
import java.io.File;  
import java.io.IOException;  
import java.util.List;  
  
public class ChartService {  
  
    public void generateWeightChart(List<HealthData> healthDataList, String outputPath) throws IOException {  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
        for (HealthData data : healthDataList) {  
            dataset.addValue(data.getWeight(), "Weight", data.getDate().toString());  
        }  
  
        JFreeChart chart = ChartFactory.createLineChart(  
                "Weight Over Time",  
                "Date",  
                "Weight (kg)",  
                dataset,  
                PlotOrientation.VERTICAL,  
                true, true, false  
        );  
  
        ChartUtils.saveChartAsPNG(new File(outputPath), chart, 800, 600);  
    }  
}