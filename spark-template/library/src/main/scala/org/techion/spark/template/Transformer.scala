package org.techion.spark.template

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class Transformer {

  def transform(sales: DataFrame, products: DataFrame): DataFrame = {
    val joineddf = products.join(sales, "product_id")
    joineddf
      .groupBy("product_id")
      .agg(sum("price").alias("total_sale"))
      .orderBy(desc("total_sale"))
      .join(products, "product_id")
      .select("product_name")
  }


}
