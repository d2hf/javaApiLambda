package lambda;

import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    private List<DailyReport> dailyReports;
    private Double totalSold;
    private HashMap<String, Double> totalSoldByVendor;
    private HashMap<String, Double> percentageSoldByVendor;

    public MonthlyReport(List<DailyReport> dailyReports) {
        this.dailyReports = dailyReports;
        this.calculateTotalSold();
        this.calculateTotalSoldByVendor();
        this.calculatePercentageSoldByVendor();
    }

    private void calculateTotalSold() {
        double monthTotal = 0.0;
        for (DailyReport dailyReport : this.getDailyReports()) {
            monthTotal += dailyReport.getTotalSold();
        }
        this.setTotalSold(monthTotal);
    }

    private void calculateTotalSoldByVendor() {
        HashMap<String, Double> totalSoldByVendor = new HashMap<>();
        for (DailyReport dailyReport : this.getDailyReports()) {
            totalSoldByVendor.merge("Anderson", dailyReport.getInputAnderson(), Double::sum);
            totalSoldByVendor.merge("Empresa", dailyReport.getInputEmpresa(), Double::sum);
            totalSoldByVendor.merge("BoaIdeia", dailyReport.getInputBoaIdeia(), Double::sum);
            totalSoldByVendor.merge("Ferronato", dailyReport.getInputFerronato(), Double::sum);
            totalSoldByVendor.merge("Juliana", dailyReport.getInputJuliana(), Double::sum);
            totalSoldByVendor.merge("Maxel", dailyReport.getInputMaxel(), Double::sum);
            totalSoldByVendor.merge("Sagrima", dailyReport.getInputSagrima(), Double::sum);
        }
        this.setTotalSoldByVendor(totalSoldByVendor);
    }

    private void calculatePercentageSoldByVendor() {
        HashMap<String, Double> percentageSoldByVendor = new HashMap<>();
        HashMap<String, Double> totalSoldByVendor = this.getTotalSoldByVendor();
        Double totalSold = this.getTotalSold();
        percentageSoldByVendor.put("Anderson", totalSoldByVendor.get("Anderson") / totalSold);
        percentageSoldByVendor.put("Empresa", totalSoldByVendor.get("Empresa") / totalSold);
        percentageSoldByVendor.put("BoaIdeia", totalSoldByVendor.get("BoaIdeia") / totalSold);
        percentageSoldByVendor.put("Ferronato", totalSoldByVendor.get("Ferronato") / totalSold);
        percentageSoldByVendor.put("Juliana", totalSoldByVendor.get("Juliana") / totalSold);
        percentageSoldByVendor.put("Maxel", totalSoldByVendor.get("Maxel") / totalSold);
        percentageSoldByVendor.put("Sagrima", totalSoldByVendor.get("Sagrima") / totalSold);
        this.setPercentageSoldByVendor(percentageSoldByVendor);
    }

    public List<DailyReport> getDailyReports() {
        return dailyReports;
    }

    public void setDailyReports(List<DailyReport> dailyReports) {
        this.dailyReports = dailyReports;
    }

    public HashMap<String, Double> getTotalSoldByVendor() {
        return totalSoldByVendor;
    }

    public void setTotalSoldByVendor(HashMap<String, Double> totalSoldByVendor) {
        this.totalSoldByVendor = totalSoldByVendor;
    }

    public Double getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Double totalSold) {
        this.totalSold = totalSold;
    }

    public HashMap<String, Double> getPercentageSoldByVendor() {
        return percentageSoldByVendor;
    }

    public void setPercentageSoldByVendor(HashMap<String, Double> percentageSoldByVendor) {
        this.percentageSoldByVendor = percentageSoldByVendor;
    }

}
