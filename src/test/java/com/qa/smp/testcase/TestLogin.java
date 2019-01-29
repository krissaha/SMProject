package com.qa.smp.testcase;

import org.testng.annotations.Test;
import com.qa.smp.base.TestBase;
import com.qa.smp.pages.CustomerCorporatePage;
import com.qa.smp.pages.Loginpage;

import com.qa.smp.util.*;

public class TestLogin extends TestBase
{
	Loginpage lp;
	CustomerCorporatePage cc;
	Util u;
	
	@Test(priority=1)
	public void validLogin() throws Exception
	{
		lp = new Loginpage();
		lp.verify_loginpage_title();
		lp.verify_logo_loginpage();
		lp.verify_termsofuse();
		u = new Util(prop.getProperty("Excelpath"));
		cc = lp.logIn(Util.vloginemail(1, 1, 0), Util.vloginemail(1, 1, 1) );
		
		
	}
	
	@Test(priority=2)
	public void invalidLogin()
	{
		
		
	}

	
}
