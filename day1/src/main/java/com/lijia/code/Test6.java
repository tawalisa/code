package com.lijia.code;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

	static class Person{
		String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	static class Obj implements Cloneable{
		String name;
		List list;
		Person p;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
		public  Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
		public Person getP() {
			return p;
		}
		public void setP(Person p) {
			this.p = p;
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Obj obj = new Obj();
		obj.setName("test1");
		obj.setList(new ArrayList());
		obj.getList().add(1);
		obj.setP(new Person());
		obj.getP().setName("ppp");
		Obj newObj = (Obj) obj.clone();
		System.out.println(newObj.getName());
		System.out.println(newObj.getList());
		System.out.println(newObj.getP().getName());
		obj.getList().add(2);
		System.out.println(newObj.getList());
		obj.setName("newtest");
		System.out.println(newObj.getName());
		obj.getP().setName("newppp");
		System.out.println(newObj.getP().getName());
		
	}

}
