package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import org.joda.time._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def data = Action {
    val today = DateMidnight.now().toDateTime()
    val times = for (i <- 0 until 1000) yield today.plusMinutes(i)
    val x = times.zipWithIndex map { case (x, i) => Json.arr(x.getMillis(), Math.cos(i / 180.0 * Math.PI))}
    Ok(Json.arr(x))
  }
}