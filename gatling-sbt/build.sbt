name := "Gatling"

version := "1.0"

scalaVersion := "2.12.2"

enablePlugins(GatlingPlugin)


//libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % "test"
// https://mvnrepository.com/artifact/io.gatling.highcharts/gatling-charts-highcharts
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0"

//libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.2.2" % "test"
// https://mvnrepository.com/artifact/io.gatling/gatling-test-framework
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.3.0"

//start tests sbt gatling:test
