package com.luiscamilo.user.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.user_index;

public class Application extends Controller {

    public Result index() {
        return ok(user_index.render("Your new application is ready."));
    }

}
