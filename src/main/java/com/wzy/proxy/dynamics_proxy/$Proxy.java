package com.wzy.proxy.dynamics_proxy;
import com.wzy.proxy.dynamics_proxy.Dao;
import java.lang.reflect.Method;
import com.wzy.proxy.dynamics_proxy.TestInvocationHandler;
import java.lang.Exception;
public class $Proxy implements Dao {
	private TestInvocationHandler h;
	public $Proxy(TestInvocationHandler h){
		this.h = h;
	}
	public String set( String p0) {
		Method method = null;
		Object[] args = new Object[]{p0};
		Class[] argsClass = new Class[]{String.class};
		try {
			method = Dao.class.getDeclaredMethod("set", argsClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String)h.invoke(method, args);
	}
	public String set( String p0,String p1) {
		Method method = null;
		Object[] args = new Object[]{p0,p1};
		Class[] argsClass = new Class[]{String.class,String.class};
		try {
			method = Dao.class.getDeclaredMethod("set", argsClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String)h.invoke(method, args);
	}
	public void test( ) {
		Method method = null;
		try {
			method = Dao.class.getDeclaredMethod("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		h.invoke(method, new Object[0]);
	}
}