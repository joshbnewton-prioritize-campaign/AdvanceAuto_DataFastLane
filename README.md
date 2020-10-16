# Data in the Fast Lane

## What can I do with Data in the Fast Lane (DFL)?

Data in the Fast Lane (DFL) is a data-oriented tool, design to perform extract, transform, and load (ETL) operations. DFL differentiates itself from other ETL tools as it focuses on scaling thanks to its backing by Apache Spark. DFL does not require any specific infrastructure, it can run on a laptop or leveraging containers in a cloud environment. It can run standalone or embedded in an application. Finally, it is designed to be extensible, with both the data transformation recipes and extension supporting source control.


![What can I do with Data in the Fast Lane](https://github.com/AdvanceAutoParts/datafastlane/blob/master/doc/what_can_i_do_with_data_in_the_fast_lane_dfl.png?raw=true)

DFL is:

 * Easy
 * Open Source
 * Fast
 * Standalone
 * Scriptable: You can use DFL within scripts on the command line, you can start by having a look at the `dfl.sh` script and hack your way from there.
 * Embeddable: Use DFL as a framework and embed it directly in your Java/Scala apps as a Jar.
 * Scalable
 * Extensible
 * Source control
 * Container
 * Cloud-ready

## Installation and first execution

Once you have cloned the source code, run:

    mvn install -Dmaven.test.skip=true
    
Tests are working but may require external components that are not described in the requirements yet. To run Data in the Fast Lane (DFL), simply run:

    dfl.sh <recipe-filename> [--dryrun]

Where your recipe file is a YAML file, like in:

    dfl.sh ./src/test/resources/recipe-count-books.yaml
    
The execution returns: 

```
...
DataFastLaneApp is starting and will process recipe: ./src/test/resources/recipe-count-books.yaml
2020-10-16 10:23:42.666 - INFO --- [           main] peration.run(CountRowsOperation.java:36): books has 24 row(s)
DFL completed in 9.2s with a status of true.
```

## Advanced usage

DFL can also be used in an embedded way, as a Java framework. Look at the following examples:

 * `LoadShowLabApp`: executes a basic recipe.
 * `LoadShowTransformLabApp`: executes a recipe with a transformation.
 * `LoadShowJoinLabApp`: executes a recipe with a join between two CSV files.

## More documentation

### User manual

The `doc` directory contains a Microsoft Word user manual. It will be replaced by markdown pages as we move along.

### Blog posts

If you have access to Advance Auto Parts' Confluence, please check out:

 * [End-to-End DFL Tutorial](https://advanceautoparts.atlassian.net/wiki/spaces/OBMS/blog/2020/02/04/985956616/End-to-End+DFL+Tutorial)
 * [Data in the Fast Lane or moving data around at high-speed](https://advanceautoparts.atlassian.net/wiki/spaces/eng/pages/932381558/Data+in+the+Fast+Lane+or+moving+data+around+at+high-speed)
 * [Extending Data in the Fast Lane processing power](https://advanceautoparts.atlassian.net/wiki/spaces/eng/pages/971080327/Extending+Data+in+the+Fast+Lane+processing+power)
 * [Elasticsearch Query Optimization](https://advanceautoparts.atlassian.net/wiki/spaces/eng/pages/1010827890/Elasticsearch+Query+Optimization)
 
Those pages will be also converted to markdown / made available in a public way.
