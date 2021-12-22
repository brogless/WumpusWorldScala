import akka.actor._

class HelloWorld(myName: String) extends Actor {
  def receive = {
    case "hello" => println("hello from %s".format(myName))
    case _       => println("'huh?', said %s".format(myName))
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props(new HelloWorld("Misha")), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}