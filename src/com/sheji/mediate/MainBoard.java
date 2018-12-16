package com.sheji.mediate;

public class MainBoard implements Mediator{

	private CDDriver cdDriver;
	private CPU cpu;
	private VedioCard vedioCard;
	private SoundCard soundCard;
	
	public void setCdDriver(CDDriver cdDriver) {
		this.cdDriver = cdDriver;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setVedioCard(VedioCard vedioCard) {
		this.vedioCard = vedioCard;
	}

	public void setSoundCard(SoundCard soundCard) {
		this.soundCard = soundCard;
	}

	@Override
	public void change(Colleague c) {
		// TODO Auto-generated method stub
		if (c instanceof CDDriver) {
			cdDriverRead((CDDriver)c);
		} else if (c instanceof CPU) {
			openCpu(cpu);
		}
	}

	private void cdDriverRead(CDDriver cd) {
		String data = cd.getData();
		cpu.executeData(data);
	}
	
	private void openCpu(CPU cpu) {
		String vedio = cpu.getVideoData();
		String sound = cpu.getSoundData();
		vedioCard.showData(vedio);
		soundCard.soundData(sound);
	}
}
