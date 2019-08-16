## Download and install Kafka

1. The information bellow is a compiled resource extracted from official [Apache Kafka site](https://kafka.apache.org/quickstart) 

[Download](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.3.0/kafka_2.12-2.3.0.tgz)

> **tar** -xzf kafka_2.12-2.3.0.tgz
> **cd** kafka_2.12-2.3.0

### Start Zookeeper server (Shell-1)

> bin/zookeeper-server-start.sh config/zookeeper.properties

### Start Kafka server (Shell-2)

> bin/kafka-server-start.sh config/server.properties

### Create a topic called 'test' (with one partition)

> bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

### Put message on test topic (Producer)

> bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
This is a message
This is another message
Soon

### Start a consumer by command line

> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

### Consumer App created in Spark Streaming

The code is located in ![github](https://github.com/joelsonSantos/spark_kafka_tests)





