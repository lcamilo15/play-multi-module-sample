package com.luiscamilo.admin.controllers;


import com.google.inject.Inject;
import play.api.mvc.Action;
import play.api.mvc.AnyContent;

/**
 * Created by lcamilo on 1/2/16.
 */

public class Assets {
    @Inject
    controllers.Assets assets;

    public Action<AnyContent> versioned(String path, controllers.Assets.Asset file) {
        return assets.versioned(path, file);
    }
}
