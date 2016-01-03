
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/lcamilo/Documents/Projects/personal_project/multi-module-sample-project/conf/routes
// @DATE:Sat Jan 02 21:07:43 EST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
