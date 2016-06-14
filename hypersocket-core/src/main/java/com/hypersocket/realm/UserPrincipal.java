/*******************************************************************************
 * Copyright (c) 2013 Hypersocket Limited.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.hypersocket.realm;

import java.util.Date;

public abstract class UserPrincipal extends Principal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6916181436630638375L;

	public abstract Date getLastPasswordChange();
	
	public abstract Date getLastSignOn();
}
