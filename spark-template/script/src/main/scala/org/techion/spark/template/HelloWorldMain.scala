package org.techion.spark.template

import org.apache.spark.sql.SparkSession

object HelloWorldMain {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession
      .builder()
      .appName("ProductSales")
      .master("local[*]")
      .getOrCreate()

    val products = sparkSession.read
      .option("header", "true")
      .csv("data/sample01/products.csv")
      .toDF("product_id", "product_name", "category", "price")

    val sales = sparkSession.read
      .option("header", "true")
      .csv("data/sample01/sales.csv")
      .toDF("product_id", "sale_id", "sale_date")

    val transformed = new Transformer().transform(sales, products)
    println("Top 3=" + transformed.take(3).toList)

  }

}
