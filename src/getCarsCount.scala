import org.apache.spark.{SparkConf, SparkContext}


object getCarsCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("getCarsCount")//.setMaster("local[*]")
    val sc = new SparkContext(conf)
    val carsInfo = sc.textFile(args(0)).map(line => line.split(",")).groupBy(_(0))
    println(carsInfo.count())
  }
}
