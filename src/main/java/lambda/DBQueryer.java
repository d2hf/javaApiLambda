package lambda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQueryer {

    DBQueryer (){

    }

    public void persistRelatorioFullJson(Connection c, DailyReport r) {
        /*
        PreparedStatement Performance

        It takes time for a database to parse an SQL string, and create a query plan for it.
        A query plan is an analysis of how the database can execute the query in the most efficient way
        If you submit a new, full SQL statement for every query or update to the database,
        the database has to parse the SQL and for queries create a query plan.
        By reusing an existing PreparedStatement you can reuse both the SQL parsing and query plan for subsequent queries.
        This speeds up query execution, by decreasing the parsing and query planning overhead of each execution.

        It is possible to reuse preparedStatements with different arguments. Check source for that.

        source: http://tutorials.jenkov.com/jdbc/preparedstatement.html
         */
        //LambdaLogger logger = this.context.getLogger();

        String query = "INSERT INTO tabela_full " +
                "(created_at, total_billed, total_sold, weight_billed, input_anderson, input_empresa, " +
                "input_boaideia, input_ferronato, input_juliana, input_maxel, input_sagrima) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON CONFLICT (created_at) DO " +
                "UPDATE SET (total_billed, total_sold, weight_billed, input_anderson, input_empresa, " +
                "input_boaideia, input_ferronato, input_juliana, input_maxel, input_sagrima) = " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = c.prepareStatement(query);

            preparedStatement.setDate(1, java.sql.Date.valueOf(r.getCreatedAt()));
            preparedStatement.setDouble(2, r.getTotalBilled());
            preparedStatement.setDouble(3, r.getTotalSold());
            preparedStatement.setDouble(4, r.getWeightBilled());
            preparedStatement.setDouble(5, r.getInputAnderson());
            preparedStatement.setDouble(6, r.getInputEmpresa());
            preparedStatement.setDouble(7, r.getInputBoaIdeia());
            preparedStatement.setDouble(8, r.getInputFerronato());
            preparedStatement.setDouble(9, r.getInputJuliana());
            preparedStatement.setDouble(10, r.getInputMaxel());
            preparedStatement.setDouble(11, r.getInputSagrima());
            preparedStatement.setDouble(12, r.getTotalBilled());
            preparedStatement.setDouble(13, r.getTotalSold());
            preparedStatement.setDouble(14, r.getWeightBilled());
            preparedStatement.setDouble(15, r.getInputAnderson());
            preparedStatement.setDouble(16, r.getInputEmpresa());
            preparedStatement.setDouble(17, r.getInputBoaIdeia());
            preparedStatement.setDouble(18, r.getInputFerronato());
            preparedStatement.setDouble(19, r.getInputJuliana());
            preparedStatement.setDouble(20, r.getInputMaxel());
            preparedStatement.setDouble(21, r.getInputSagrima());

            preparedStatement.execute();
            System.out.println("Execution ok");

        } catch (SQLException throwables) {
            //logger.log(throwables.toString());
            System.out.println(throwables.toString());
        }
    }

    public List<DailyReport> getMonthData(Connection c, int year, int month) throws SQLException {
        String dailyReportsQuery = "SELECT * FROM tabela_full WHERE EXTRACT(MONTH FROM created_at)= ?" +
                " AND EXTRACT(YEAR FROM created_at) = ?";
        PreparedStatement dailyReportsPreparedStatement = c.prepareStatement(dailyReportsQuery);
        List<DailyReport> dailyReports = new ArrayList<>();

        try{
            dailyReportsPreparedStatement.setInt(1, month);
            dailyReportsPreparedStatement.setInt(2, year);

            ResultSet dailyReportsResultSet = dailyReportsPreparedStatement.executeQuery();
            while (dailyReportsResultSet.next()){
                DailyReport r = new DailyReport();
                r.setCreatedAt(dailyReportsResultSet.getString("created_at"));
                r.setInputAnderson(dailyReportsResultSet.getDouble("input_anderson"));
                r.setInputBoaIdeia(dailyReportsResultSet.getDouble("input_boaideia"));
                r.setInputEmpresa(dailyReportsResultSet.getDouble("input_empresa"));
                r.setInputFerronato(dailyReportsResultSet.getDouble("input_ferronato"));
                r.setInputJuliana(dailyReportsResultSet.getDouble("input_juliana"));
                r.setInputMaxel(dailyReportsResultSet.getDouble("input_maxel"));
                r.setInputSagrima(dailyReportsResultSet.getDouble("input_sagrima"));
                r.setTotalBilled(dailyReportsResultSet.getDouble("total_billed"));
                r.setTotalSold(dailyReportsResultSet.getDouble("total_sold"));
                r.setWeightBilled(dailyReportsResultSet.getDouble("weight_billed"));

                dailyReports.add(r);
            }

        } catch (SQLException throwables){
            System.out.println(throwables.toString());
        }

        System.out.println(dailyReports);

        MonthlyReport monthlyReport = new MonthlyReport(dailyReports);

        return dailyReports;
    }


}
