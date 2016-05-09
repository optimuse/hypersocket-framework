package com.hypersocket.jobs.events;

import org.apache.commons.lang3.ArrayUtils;

import com.hypersocket.jobs.JobResource;
import com.hypersocket.session.Session;

public class JobResourceCreatedEvent extends
		JobResourceEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3888399996190675339L;
	/**
	 * TODO rename to suit your resource and replace job with lower case
	 * name of your resource.
	 * 
	 * You typically add attributes to the base JobResourceEvent class
	 * so these can be reused across all resource events.
	 */
	public static final String EVENT_RESOURCE_KEY = "job.created";
	
	public JobResourceCreatedEvent(Object source,
			Session session,
			JobResource resource) {
		super(source, EVENT_RESOURCE_KEY, session, resource);
	}

	public JobResourceCreatedEvent(Object source,
			JobResource resource, Throwable e,
			Session session) {
		super(source, EVENT_RESOURCE_KEY, resource, e, session);
	}

	public String[] getResourceKeys() {
		return ArrayUtils.add(super.getResourceKeys(), EVENT_RESOURCE_KEY);
	}
}
