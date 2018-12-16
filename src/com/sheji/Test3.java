package com.sheji;

public class Test3 {

	public static void main(String[] args) {
		IFamilyFactory cn = new ChineseFactory();
		IFamilyFactory us = new AmericanFactory();
		
		IFather cnFather = new ChineseFather("cn father test");
		IMother cnMother = new ChineseMother("cn mother test");
		
		IFather usFather = new AmericanFather("us father test");
		IMother usMother = new AmericanMother("us mother test");
		
		cnFather.printName();
		cnMother.printName();
		
		usFather.printName();
		usMother.printName();
	}
}
