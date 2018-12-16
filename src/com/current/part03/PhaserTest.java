package com.current.part03;

import java.util.concurrent.Phaser;
/**
 * phaser
 * @author zhanglin
 *
 */
public class PhaserTest {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("f:\\log", "log", phaser);
		FileSearch apps = new FileSearch("F:\\javatest", "test", phaser);
		FileSearch document = new FileSearch("F:\\javatest", "tomcat", phaser);
		
		Thread t1 = new Thread(system, "system");
		t1.start();
		
		Thread t2 = new Thread(apps, "apps");
		t2.start();
		
		Thread t3 = new Thread(document, "document");
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("terminated " + phaser.isTerminated());
	}
}
