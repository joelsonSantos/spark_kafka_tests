name := "newJob1"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.apache.spark" %% "spark-mllib" % "2.4.3",
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.4.3",
  "org.apache.hadoop" % "hadoop-aws" % "3.2.0",
  "org.apache.hadoop" % "hadoop-auth" % "3.2.0",
  "com.amazonaws" % "aws-java-sdk" % "1.11.611"
)