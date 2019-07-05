package com.wzy.proxy.dynamics_proxy;
import com.wzy.proxy.dynamics_proxy.Dao;
public class $Proxy implements Dao {
	private Dao target;
	public $Proxy(Dao target){
		this.target = target;
	}
	public String set( String p0) {
		System.out.println("log");
		return target.set(p0);
	}
	public String set( String p0,String p1) {
		System.out.println("log");
		return target.set(p0,p1);
	}
	public void test( ) {
		System.out.println("log");
		target.test();
	}
}