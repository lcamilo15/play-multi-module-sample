
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

    """),_display_(/*3.6*/admin_main("Welcome to Play")/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""

        """),_display_(/*5.10*/play20/*5.16*/.welcome(message, style = "Java")),format.raw/*5.49*/("""

    """)))}),format.raw/*7.6*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sat Jan 02 20:45:40 EST 2016
                  SOURCE: /Users/lcamilo/Documents/Projects/personal_project/multi-module-sample-project/app/views/index.scala.html
                  HASH: 4247ae51707c240274c42f07bfcb4d8ce0df2092
                  MATRIX: 745->1|857->18|889->25|926->54|965->56|1002->67|1016->73|1069->106|1105->113
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|36->5|36->5|38->7
                  -- GENERATED --
              */
          