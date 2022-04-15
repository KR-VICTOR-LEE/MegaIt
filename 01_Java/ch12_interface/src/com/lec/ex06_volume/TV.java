package com.lec.ex06_volume;

public class TV implements IVolume{
	private final int TV_MAX_VOLUME = 50;
	private final int TV_MIN_VILUME = 0;
	private int volumeLevel;
	public TV() {}
	public TV(int volumeLever) {
		this.volumeLevel = volumeLever;
	}
	
	@Override
	public void VolumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("TV ������ 1 �÷Ƚ��ϴ� ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ �Դϴ� ");
		}
		
	}

	@Override
	public void VolumeUp(int lever) {
		if (volumeLevel + lever <= TV_MAX_VOLUME) { // lever ��ŭ �ø�
			volumeLevel += lever;
			System.out.println("TV ������ "+ lever +"�÷� ���� "+volumeLevel);
		}else {
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+lever+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ "+TV_MAX_VOLUME);
		}
		
	}

	@Override
	public void VolumeDown() {
		if (volumeLevel > TV_MIN_VILUME) {
			volumeLevel --;
			System.out.println("TV ������ 1 ���Ƚ��ϴ� ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ ");
		}
		
	}

	@Override
	public void VolumeDown(int lever) {
		if (volumeLevel - lever >=TV_MIN_VILUME) {
			volumeLevel-= lever;
			System.out.println("TV ������ "+ lever+ "���� ����"+volumeLevel);
		}else {
			int tempLevel = TV_MIN_VILUME - volumeLevel;
			volumeLevel = TV_MIN_VILUME;
			System.out.println("TV ������ "+ lever+ "��ŭ �� ������ "+tempLevel+"��ŭ ���� �ּ�ġ"+ TV_MIN_VILUME);
		}
		
	}

}
