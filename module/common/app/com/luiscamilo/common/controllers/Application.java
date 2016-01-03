package com.luiscamilo.common.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.common_index;

public class Application extends Controller {

    public Result index() {
        return ok(common_index.render("Your new application is ready."));
    }

}
