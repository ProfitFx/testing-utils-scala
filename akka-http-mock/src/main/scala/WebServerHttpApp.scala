
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport.defaultNodeSeqMarshaller
import akka.http.scaladsl.server.{ HttpApp, Route }
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.ContentNegotiator.Alternative.ContentType
import spray.json._

object WebServerHttpApp extends HttpApp with App {

  case class Person(name: String, age: Int)

  case object Person extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val personFormat = jsonFormat2(Person.apply)
  }

  case class Subscribe(id: String, Ticks: String)

  case object Subscribe extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val subscribeFormat = jsonFormat2(Subscribe.apply)
  }

  def routes: Route =
    pathEndOrSingleSlash {
      get {
        complete(Person("1", 123), Person("2", 12))
      }
    } ~
      pathEndOrSingleSlash {
        post {
          entity(as[String]) { str =>
            println(str)
            complete(str)
          }
        }
      }

  startServer("localhost", 1234)
}

//def routes: Route =
//  path("ch") {
//    pathEndOrSingleSlash {
//      get {
//        complete(Person("1", 123), Person("2", 12))
//      }
//    }
//  } ~
//    path("ch" / "chh") {
//      pathEndOrSingleSlash {
//        get {
//
//          complete(Subscribe("4", "123"), Subscribe("5", "12"))
//        }
//      }
//    } ~
//    path("new") {
//      pathEndOrSingleSlash {
//        get {
//          complete(HttpEntity(ContentTypes.`application/json`, """{"wer":"456"}"""))
//        }
//      }
//    } ~
//    path("nf") {
//      pathEndOrSingleSlash {
//        get {
//          complete(HttpResponse(status = StatusCodes.NotFound, entity = "Unfortunately, the resource couldn't be found."))
//        }
//      }
