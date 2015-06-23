package com.photify;

import java.io.IOException;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import scenic3.ScenicPage;
import scenic3.annotation.ActionPath;
import scenic3.annotation.Default;
import scenic3.annotation.GET;
import scenic3.annotation.POST;
import scenic3.annotation.Page;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.photify.meta.ImageMeta;
import com.photify.meta.UserMeta;
import com.photify.model.Image;
import com.photify.model.User;


@Page("/user")
public class UserPage extends ScenicPage {

    @POST
    @ActionPath("add")
    public Navigation add() throws IOException {
        
        User user = new User();
        BeanUtil.copy(new RequestMap(request), user);
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(user);
        tx.commit();
        
        return response("00");
    }

    @POST
    @ActionPath("delete")
    public Navigation delete() throws IOException {
        String imageKey = "" + request.getAttribute("image_key");
        String userKey = "" + request.getAttribute("user_key");
        
        UserMeta USERMETA = UserMeta.get();
        User user = Datastore.get(USERMETA, KeyFactory.stringToKey(userKey));
        ImageMeta IMAGEMETA = ImageMeta.get();
        Image image = Datastore.get(IMAGEMETA, KeyFactory.stringToKey(imageKey));
        
        if(image.getOwner()!=user.getKey()){
            return response("01");
        }
        
        Datastore.delete(image.getKey());
        return response("00");
    }
    
    @GET
    @ActionPath("list")
    public Navigation getUsers() throws IllegalStateException, NullPointerException, IOException {
            UserMeta USERMETA = UserMeta.get();
        return response(USERMETA.modelsToJson(Datastore.query(USERMETA).asIterable()));
    }

    // /
    @Default
    public Navigation index() {
        return forward("/index.jsp");
    }
}