package two

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2020/4/7.
  */
object WordCount {


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local[*]");
    val sc = new SparkContext(conf);
    val rdd = sc.textFile("D:\\github_project\\spark2.3.3\\data\\sparklearning.txt");
    val wordCount = rdd.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _);
    val wordsort = wordCount.map(x => (x._2, x._1)).sortByKey(false).map(x => (x._2, x._1))
    // hdfs 写入的时候没有权限 hadoop fs -chmod 777 /Diagrammatize_Spark
    wordCount.saveAsTextFile("hdfs://hadoop:9000/Diagrammatize_Spark/Two/Wordcount4");
    print(wordCount.collect())
    sc.stop();


  }
}
