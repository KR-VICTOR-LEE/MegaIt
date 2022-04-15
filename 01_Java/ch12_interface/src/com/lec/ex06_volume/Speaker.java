package com.lec.ex06_volume;

public class Speaker implements IVolume{
	private final int SPEAKER_MAX_VOLUME = 50;
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	public Speaker() {}
	public Speaker(int volumeLever) {
		this.volumeLevel = volumeLever;
	}
	
	@Override
	public void VolumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("SPEAKER ������ 1 �÷Ƚ��ϴ� ���� "+volumeLevel);
		}else {
			System.out.println("SPEAKER ������ �ִ�ġ �Դϴ� ");
		}
		
	}

	@Override
	public void VolumeUp(int lever) {
		if (volumeLevel + lever <= SPEAKER_MAX_VOLUME) { // lever ��ŭ �ø�
			volumeLevel += lever;
			System.out.println("SPEAKER ������ "+ lever +"�÷� ���� "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER ������ "+lever+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ "+SPEAKER_MAX_VOLUME);
		}
		
	}

	@Override
	public void VolumeDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("SPEAKER ������ 1 ���Ƚ��ϴ� ���� "+volumeLevel);
		}else {
			System.out.println("SPEAKER ������ ");
		}
		
	}

	@Override
	public void VolumeDown(int lever) {
		if (volumeLevel - lever >=SPEAKER_MIN_VOLUME) {
			volumeLevel-= lever;
			System.out.println("SPEAKER ������ "+ lever+ "���� ����"+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MIN_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER ������ "+ lever+ "��ŭ �� ������ "+tempLevel+"��ŭ ���� �ּ�ġ"+ SPEAKER_MIN_VOLUME);
		}
		
	}
}
