package demo.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class LoadDB implements Serializable {

    public static SparkConf sparkConf;
    public static SparkContext sc;
    public static SQLContext sqlContext;

    public static void main(String[] args) throws IOException, InterruptedException {
//        RealTimeRowReading();
//        getMysqlTableToFile();
        String warehouseLocation = System.getProperty("user.dir");
        sparkConf = new SparkConf()
                .setAppName("from-to-mysql")
                .set("spark.sql.warehouse.dir", warehouseLocation)
                .setMaster("local[*]");
        sc = new SparkContext(sparkConf);
        SparkSession session = new SparkSession(sc);
        sqlContext = new SQLContext(session);
        Dataset<Row> df = sqlContext
                .read()
                .format("jdbc")
                .option("url", "jdbc:mysql://139.199.0.169:23306/lacesar?serverTimezone=Asia/Shanghai")
                .option("user", "huangdaoyong")
                .option("password", "OhUYxLYxaaURUV3SSn0D")
                .option("query", "select * from sos_order limit 500,500")
                .load();
        df.filter((FilterFunction<Row>) row -> "00211811130001".equals(row.getAs("ORDER_ID"))).show();
    }

    private static void RealTimeRowReading() throws InterruptedException, IOException {
        Map res = new HashMap<>(90);
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            FileReader fr = new FileReader("D:/电信.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                if (res.get(s) == null) {
                    res.put(s, s);
                    System.out.println(s);
                }else{
                    System.out.println("没有新增行");
                }
            }
            br.close();
            fr.close();
        }
    }

    /**
     * 从mysql获取表数据然后转为json存储
     *
     * @author: Nevernow
     * @Date: 11:28 2019/6/13
     */
    private static void getMysqlTableToFile() {
        String url = "jdbc:mysql://139.199.0.169:23306/lacesar?serverTimezone=Asia/Shanghai";

        Dataset<Row> df = sqlContext
                .read()
                .format("jdbc")
                .option("url", url)
                .option("database", "lacesar")
                .option("db", "lacesar")
                .option("user", "huangdaoyong")
                .option("password", "OhUYxLYxaaURUV3SSn0D")
                .option("dbtable", "sos_order")
                .load();
        // Looks the schema of this DataFrame.
        df.printSchema();
        Dataset dataset = df.select("*").limit(1000);
        System.out.println("开始查询");
        dataset.foreach(o -> {
            System.out.println(o);
        });
        System.out.println("开始保存");
        dataset.write().format("json").mode(SaveMode.Overwrite).save("D:/save.txt");
    }
}