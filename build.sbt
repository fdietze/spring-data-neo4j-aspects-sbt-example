import com.typesafe.sbt.SbtAspectj._
import com.typesafe.sbt.SbtAspectj.AspectjKeys._

name := "sdntest"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spring" at "http://repo.spring.io/milestone",
  "neo4j-releases" at "http://m2.neo4j.org/releases/"
)

libraryDependencies ++= Seq(
  "org.springframework.data" % "spring-data-neo4j"         % "3.0.0.M1"      % "compile",
  "org.springframework.data" % "spring-data-neo4j-aspects" % "3.0.0.M1"      % "compile",
  "javax.persistence"        % "persistence-api"           % "1.0"           % "compile",
  "javax.validation"         % "validation-api"            % "1.0.0.GA"      % "compile",
  "junit"                    % "junit"                     % "4.11"          % "test",
  "com.novocode"             % "junit-interface"           % "0.9"           % "test",
  "org.springframework"      % "spring-test"               % "4.0.0.RELEASE" % "test"
)


Seq(aspectjSettings: _*)

verbose in Aspectj := false

showWeaveInfo in Aspectj := false

inputs in Aspectj <+= compiledClasses

binaries in Aspectj <++= update map { report:UpdateReport =>
  report.matching(
     moduleFilter(organization = "org.springframework.data", name = "spring-data-neo4j-aspects")
  )
}

products in Compile <<= products in Aspectj

products in Runtime <<= products in Compile
