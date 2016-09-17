name := "concordance01"

version := "1.0"

scalaVersion := "2.11.7"
scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "org.specs2"    %% "specs2"    % "2.3.12" % "test" withSources(),
  "org.scalatest" %% "scalatest" % "2.2.3"  % "test" withSources(),
  "junit"         %  "junit"     % "4.12"   % "test" // Scala IDE requires this; IntelliJ IDEA does not
)