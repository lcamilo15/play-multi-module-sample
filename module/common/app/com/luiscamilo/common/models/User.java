package com.luiscamilo.common.models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by lcamilo on 1/2/16.
 */
public class User {
    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String name;

    public boolean done;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dueDate = new Date();

    public static Model.Finder<Long, User> find = new Model.Finder<Long, User>(User.class);
}
