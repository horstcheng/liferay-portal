/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.PasswordPolicyRel;
import com.liferay.portal.service.PasswordPolicyRelLocalServiceUtil;

/**
 * The extended model base implementation for the PasswordPolicyRel service. Represents a row in the &quot;PasswordPolicyRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PasswordPolicyRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PasswordPolicyRelImpl
 * @see com.liferay.portal.model.PasswordPolicyRel
 * @generated
 */
public abstract class PasswordPolicyRelBaseImpl
	extends PasswordPolicyRelModelImpl implements PasswordPolicyRel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a password policy rel model instance should use the {@link PasswordPolicyRel} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			PasswordPolicyRelLocalServiceUtil.addPasswordPolicyRel(this);
		}
		else {
			PasswordPolicyRelLocalServiceUtil.updatePasswordPolicyRel(this);
		}
	}
}