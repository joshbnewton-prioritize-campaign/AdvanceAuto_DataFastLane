package com.advancestores.enterprisecatalog.datafastlane.operations;

import static org.apache.spark.sql.functions.lower;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advancestores.enterprisecatalog.datafastlane.DataStore;
import com.advancestores.enterprisecatalog.datafastlane.recipe.Operation;

/**
 * Operation to change the letter case of a column to Lower case
 *
 * <pre>
 * letterCaseTest:
 * - attribute: subjectTextForLetterCase
 *   operations:
 *   - operation: lowerCase
 * </pre>
 *
 * @author gabriel.priester
 * @version 1.0.0
 */
public class LowerCaseOperation extends CoreOperation {
  private static final Logger log =
      LoggerFactory.getLogger(LowerCaseOperation.class);

  @Override
  public boolean run() {
    long runStart = System.currentTimeMillis();

    log.debug("-> {}:run()", this.getClass().getSimpleName());

    // initialization
    Operation operationDefinition = getOperationDefinition();
    if (operationDefinition == null) {
      log.error("No operation associated to this load.");
      return false;
    }

    DataStore store = getStore();
    if (store == null) {
      log.error("No data store associated to this load.");
      return false;
    }

    String dataframeName = super.getContainerName();
    Dataset<Row> df = store.get(dataframeName);
    if (df == null) {
      log.error("Could not find a dataframe called '{}' in the store",
          dataframeName);
      return false;
    }

    // Processing
    String operationColumnName = super.getAttributeName();

    log.debug("Lowercase operation applied to {}", operationColumnName);
    df = df.withColumn(operationColumnName,
        lower(df.col(operationColumnName)));

    // Save result
    store.add(dataframeName, df);

    log.debug("{} completed in {} seconds.",
        this.getClass().getSimpleName(),
        (System.currentTimeMillis() - runStart) / 1000.0);

    return true;
  }

}
