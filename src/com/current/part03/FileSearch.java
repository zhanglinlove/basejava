package com.current.part03;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
/**
 * arriveAndAwaitAdvance().当一个线程调用此方法时，Phaser
 * 对象将减1，并把这个线程至于休眠状态，直到所有其他线程完成
 * 这个阶段。
 * arriveAndDeregister().当一个线程调用此方法时，Phaser对象
 * 将减1，并且通知这个线程已经完成了当前语句，不会参加到下一个
 * 阶段中，因此phaser对象在开始下一个阶段时不会等待这个线程。
 * @author zhanglin
 *
 */
public class FileSearch implements Runnable{

	private String initPath;
	private String end;
	private List<String> results;
	private Phaser phaser;
	
	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		results = new ArrayList<String>();
		this.phaser = phaser;
	}
	
	private void directoryProcess(File file) {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
	}
	
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}
	
	private void filterFile() {
		List<String> newResult = new ArrayList<>();
		long time = new Date().getTime();
		File file;
		for (int i = 0; i < results.size(); i++) {
			file = new File(results.get(i));
			long lastTime = file.lastModified();
			if ((time - lastTime) < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
				newResult.add(results.get(i));
			}
		}
		results = newResult;
	}
	
	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.println(Thread.currentThread().getName()
					+ " phaser " + phaser.getPhase() + ": 0 result.");
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.println(Thread.currentThread().getName()
					+ " phaser " + phaser.getPhase() + " " 
					+ results.size() + "  result.");
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	public void showInfo() {
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			System.out.println(Thread.currentThread().getName()
						+ " : " + file.getAbsolutePath());
			phaser.arriveAndAwaitAdvance();
		}
	}
	
	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName()+ " starting...");
		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		}
		if (!checkResults()) {
			return;
		}
		filterFile();
		if (!checkResults()) {
			return;
		}
		showInfo();
		phaser.arriveAndDeregister();
		System.out.println(Thread.currentThread().getName()
					+ " work end.");
	}

}
