organization  := "org.photoAlbum"
version       := "0.1.0"
scalaVersion  := "2.12.4"
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val sprayV = "1.3.1"
  Seq(
    "org.scala-lang" % "scala-library" % "2.12.4",
    "org.scalaj" %% "scalaj-http" % "2.3.0",
    "io.spray" %% "spray-json" % "1.3.2",
    "org.scalactic" %% "scalactic" % "2.2.2",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    //"org.scalatest" %% "scalatest" % "1.5.RC1" % Test
  )
}
resolvers += Resolver.typesafeIvyRepo("releases")
