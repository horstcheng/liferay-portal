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

package com.liferay.portalweb.portal.controlpanel.users.user.restoreuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RestoreUserTest extends BaseTestCase {
	public void testRestoreUser() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Search All Users"),
					selenium.getText("//a[@id='_125_allUsersLink']"));
				selenium.clickAt("//a[@id='_125_allUsersLink']",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");

				boolean advancedVisible = selenium.isVisible(
						"//a[.='Advanced \u00bb']");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 2:
				selenium.waitForVisible("//select[@name='_125_status']");
				selenium.select("//select[@name='_125_status']",
					RuntimeVariables.replace("label=Inactive"));
				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Check All"));
				selenium.clickAt("//input[@value='Restore']",
					RuntimeVariables.replace("Restore"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Search All Users"),
					selenium.getText("//a[@id='_125_allUsersLink']"));
				selenium.clickAt("//a[@id='_125_allUsersLink']",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("Basic"));
				selenium.type("//input[@name='_125_keywords']",
					RuntimeVariables.replace("userfn"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("userfn"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("userln"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("usersn"),
					selenium.getText("//td[4]/a"));

			case 100:
				label = -1;
			}
		}
	}
}