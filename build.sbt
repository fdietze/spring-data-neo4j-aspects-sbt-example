import com.typesafe.sbt.SbtAspectj._
import com.typesafe.sbt.SbtAspectj.AspectjKeys._

name := "sdntest"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spring" at "http://repo.spring.io/milestone",
  "neo4j-releases" at "http://m2.neo4j.org/releases/"
)



libraryDependencies ++= Seq(
  "org.springframework.data" % "spring-data-neo4j"         % "3.0.0.RC1"     % "compile",
  "org.springframework.data" % "spring-data-neo4j-aspects" % "3.0.0.RC1"     % "compile",
  "org.hibernate.javax.persistence" %"hibernate-jpa-2.0-api"%"1.0.0.Final"   % "compile",
  "javax.validation"         % "validation-api"            % "1.0.0.GA"      % "compile",
  "junit"                    % "junit"                     % "4.11"          % "test",
  "com.novocode"             % "junit-interface"           % "0.9"           % "test",
  "org.springframework"      % "spring-test"               % "3.2.7.RELEASE" % "test"
)

dependencyOverrides += "org.aspectj" % "aspectjrt" % "1.7.2"

dependencyOverrides += "org.aspectj" % "aspectjweaver" % "1.7.2"

dependencyOverrides += "org.aspectj" % "aspectjtools" % "1.7.2"

//javacOptions ++= Seq("-source", "1.6",  "-target", "1.6"), also set for aspectj

// splitting sources:
// *.scala --> scalac
// *.java  --> AspectJ compiler
// all class files come back together at "products in Compile"
// TODO: managedSources are dropped right now
Seq(aspectjSettings: _*)

verbose in Aspectj := true

showWeaveInfo in Aspectj := true

// let all unmanaged java sources be compiled by ajc
sources in Aspectj <<= (unmanagedSources in Compile).map(_.filter(_.name.endsWith(".java")))

// let the rest be compiled by scalac
sources in Compile <<= (unmanagedSources in Compile).map(_.filterNot(_.name.endsWith(".java")))

sources in Compile <++= managedSources in Compile


binaries in Aspectj <++= update map { report:UpdateReport =>
  report.matching(
     moduleFilter(organization = "org.springframework.data", name = "spring-data-neo4j-aspects")
//     || moduleFilter(organization = "org.springframework", name = "spring-aspects")
  )
}

// add compiled aspectj class files to the rest
products in Compile <++= products in Aspectj

products in Runtime <<= products in Compile

