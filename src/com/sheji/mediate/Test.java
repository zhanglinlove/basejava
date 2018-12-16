package com.sheji.mediate;

public class Test {

	public static void main(String[] args) {
		MainBoard board = new MainBoard();
		
		CDDriver cd = new CDDriver(board);
		CPU cpu = new CPU(board);
		VedioCard vedio = new VedioCard(board);
		SoundCard sound = new SoundCard(board);
		
		board.setCdDriver(cd);
		board.setCpu(cpu);
		board.setSoundCard(sound);
		board.setVedioCard(vedio);
		
		cd.readCD();
	}
}
