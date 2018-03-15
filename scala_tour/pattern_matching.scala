/**
 * Pattern matching is a mechanism for checking a value against a pattern
 * A successful match can also deconstruct a value into its constituent parts.
 * Its a more powerful version of the switch statement in java
 *
 * Syntax: A match expression has a value, the match keyword, and atleasr one case
 * clause
 */
import scala.util.Random

object PatternMatching extends App {

  // match expression have a value
  def matchText(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  println(matchText(Random.nextInt(10)))
  println(matchText(Random.nextInt(10)))


  // matching on case classes
  abstract class Notification
  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecorder(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) => s"Got email from $email with title: $title"
      case SMS(number, message) => s"Got SMS from $number message: $message"
      case VoiceRecorder(name, link) => s"Got voice recording from $name, click the link: $link"
    }
  }

  val email1 = Email("xyz@abc.com", "Hi...", "How are you?")
  val sms1 = SMS("12345", "you there?")
  val voiceRecord1 = VoiceRecorder("Tom", "voicerecoding.org/id/12345")

  println(showNotification(email1))
  println(showNotification(sms1))
  println(showNotification(voiceRecord1))

  
  // Pattern guards
  def showImportantNotification(notification: Notification,
                                importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(email, _, _) if(importantPeopleInfo.contains(email)) =>
          s"Got email from special someone"
      case SMS(number, _) if(importantPeopleInfo.contains(number)) =>
          s"Got SMS from special someone"
      case VoiceRecorder(name, _) if(importantPeopleInfo.contains(name)) =>
          s"Got voice recording from special someone"
      case other => 
          showNotification(other) // nothing special, delegate to original notification function
    }
  }

  val importantPeopleInfo = Seq("123-456", "xyz@abc.com", "Tom")
  val email2 = Email("xyz@abc.com", "Hi...", "How are you?")
  val sms2 = SMS("123-456", "you there?")
  val voiceRecord2 = VoiceRecorder("Tom", "voicerecoding.org/id/12345")
  println(showImportantNotification(email2, importantPeopleInfo))
  println(showImportantNotification(sms2, importantPeopleInfo))
  println(showImportantNotification(voiceRecord2, importantPeopleInfo))

  val email3 = Email("abc@abc.com", "Hi...", "How are you?")
  val sms3 = SMS("789-456", "you there?")
  val voiceRecord3 = VoiceRecorder("Jenny", "voicerecoding.org/id/12345")
  println(showImportantNotification(email3, importantPeopleInfo))
  println(showImportantNotification(sms3, importantPeopleInfo))
  println(showImportantNotification(voiceRecord3, importantPeopleInfo))


  // Matching on type only
  abstract class Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  val phone = Phone("Nokia")
  val computer = Computer("Apple")
  println(goIdle(phone))
  println(goIdle(computer))
}
