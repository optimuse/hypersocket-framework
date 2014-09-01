package com.hypersocket.realm.events;

import com.hypersocket.realm.Realm;
import com.hypersocket.realm.RealmProvider;
import com.hypersocket.session.Session;

public class ChangePasswordEvent extends UserEvent {


	private static final long serialVersionUID = -3803820258071069690L;

	public static final String EVENT_RESOURCE_KEY = "event.setPassword";

	public ChangePasswordEvent(Object source, Session session, Realm realm,
			RealmProvider provider) {
		super(source, EVENT_RESOURCE_KEY, session, realm, provider, session.getPrincipal());
	}

	public ChangePasswordEvent(Object source, Throwable t, Session session,
			String realm, RealmProvider provider) {
		super(source, EVENT_RESOURCE_KEY, t, session, realm, provider,
				session.getPrincipal().getPrincipalName());
	}
}
