package com.wzy.proxy.dynamics_proxy;
import com.wzy.proxy.dynamics_proxy.Dao;
public class $Proxy implements Dao {
	private Dao target;
	public $Proxy(Dao target){
		this.target = target;
	}
	public String set( String p) {
		System.out.println("log");
		return target.set(p);
	}
	public void test( ) {
		System.out.println("log");
		target.test();
	}
}