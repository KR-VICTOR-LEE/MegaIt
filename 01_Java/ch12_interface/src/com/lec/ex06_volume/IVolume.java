package com.lec.ex06_volume;

public interface IVolume {
	public void VolumeUp();
	public void VolumeUp(int lever);
	public void VolumeDown();
	public void VolumeDown(int lever);
	public default void setMute(boolean mute) {
		if (mute) {
			System.out.println("���Ұ�");
		}else {
			System.out.println("���Ұ� ����");
		}
	}
	
}
