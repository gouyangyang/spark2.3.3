import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2020/4/6.
  */
object SparkDemo {

  def main(args: Array[String]): Unit = {

    val sparkconf = new SparkConf().setAppName("SparkDemo").setMaster("local[1]")

    //spark配置，建议保留setMaster(local)

    //调试的时候需要，在实际集群上跑的时候可在命令行自定义

    val sc = new SparkContext(sparkconf)

    val rdd = sc.parallelize(List(1, 2, 3, 4, 5, 6)).map(_ * 3) //将数组(1,2,3,4,5,6)分别乘3

    rdd.filter(_ > 10).collect().foreach(println) //打印大于10的数字

    println(rdd.reduce(_ + _)) //打印 和

    println("hello world") // demo必备的一句代码!!! [认真脸]

    sc.stop();

  }


}
