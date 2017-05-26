package com.fdmgroup.listener;

import java.util.Vector;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fdmgroup.model.User;


/**
 * Application Lifecycle Listener implementation class UserSessionListener
 *
 */
@WebListener
public class UserSessionListener implements HttpSessionAttributeListener {

    private Vector<User> users  = new Vector();
    
	public UserSessionListener() {
    }

    public void attributeAdded(HttpSessionBindingEvent e)  { 
    	if (e.getName().equals("user") && ! users.contains(e.getValue())){
    		users.add((User)e.getValue());
    		e.getSession().getServletContext().setAttribute("userCounter", users.size());
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	if (e.getName().equals("user") && users.contains(e.getValue())){
    		users.remove((User)e.getValue());
    		e.getSession().getServletContext().setAttribute("userCounter", users.size());
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent e)  { 
    }
	
}
