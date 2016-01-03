package com.luiscamilo.admin.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin;

public class Application extends Controller {

    public Result index() {
        return ok(admin.render("Your new application is ready."));
    }

}
