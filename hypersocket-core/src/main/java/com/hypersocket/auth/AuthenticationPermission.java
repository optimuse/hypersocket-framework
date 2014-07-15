/*******************************************************************************
 * Copyright (c) 2013 Hypersocket Limited.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.hypersocket.auth;

import com.hypersocket.permissions.PermissionType;

public enum AuthenticationPermission implements PermissionType {

	LOGON("permission.logon");

	private final String val;

	private AuthenticationPermission(final String val) {
		this.val = val;
	}

	public String toString() {
		return val;
	}

	@Override
	public String getResourceKey() {
		return val;
	}

}
