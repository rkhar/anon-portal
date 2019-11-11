package kz.anon.portal.signup.login.api.service

import java.time.LocalDate

import akka.actor.{Actor, ActorLogging, Props}
import com.sksamuel.elastic4s.ElasticClient

object RegistrationActor {

  case class Registration(firstName: String, lastName: String, age: Int, password: String)

  def props(esClient: ElasticClient) = Props(new RegistrationActor(esClient))
}

class RegistrationActor(esClient: ElasticClient) extends Actor with ActorLogging {

  import RegistrationActor._

  override def receive: Receive = {
    case Registration(firstName, lastName, age, password) => {
      log.info("Received HttpRequest first name: {}, last name: {}, age: {} and password?: {}",
               firstName,
               lastName,
               age,
               password)

    }
  }

}