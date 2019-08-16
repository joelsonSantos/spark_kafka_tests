import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{StreamingContext, Durations}
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object Job1 {
  def main(args: Array[String]) : Unit = {

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "test-consumer-group",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    val conf = new SparkConf().setMaster("local[2]").setAppName("Job1")

    //Read messages in batch of 30 seconds
    val streamingContext = new StreamingContext(conf, Durations.seconds(30))

    //Configure Spark to listen messages in topic test
    val topics = Array("test")
    val stream = KafkaUtils.createDirectStream(
      streamingContext,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    ).map(x => (x.key, x.value))
    // salvar na S3
    stream.map(x => x._2).saveAsTextFiles("/to/path/")
    streamingContext.start()
    streamingContext.awaitTermination()
  }
}
