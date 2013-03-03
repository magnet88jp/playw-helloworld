package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello = Action {
    Ok(views.html.hello())
  }

  def hello2(name: String) = Action {
    Ok("Hello " + name)
  }

  val echo = Action { request =>
    Ok("Got request [" + request + "]")
  }

  val echo2 = Action(parse.json) { implicit request =>
    Ok("Got request [" + request + "]")
  }

  val htmlResult = Action {
  	Ok(<h1>Hello World!</h1>).as(HTML)
  }

  def index2 = Action { request =>
    request.session.get("connected").map { user =>
     Ok("Hello " + user)
    }.getOrElse {
      Unauthorized("Oops, you are not connected")
    }
  }
  
}