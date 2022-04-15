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
			System.out.println("TV 볼륨을 1 올렸습니다 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치 입니다 ");
		}
		
	}

	@Override
	public void VolumeUp(int lever) {
		if (volumeLevel + lever <= TV_MAX_VOLUME) { // lever 만큼 올림
			volumeLevel += lever;
			System.out.println("TV 볼륨을 "+ lever +"올려 현재 "+volumeLevel);
		}else {
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+lever+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치 "+TV_MAX_VOLUME);
		}
		
	}

	@Override
	public void VolumeDown() {
		if (volumeLevel > TV_MIN_VILUME) {
			volumeLevel --;
			System.out.println("TV 볼륨을 1 내렸습니다 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 ");
		}
		
	}

	@Override
	public void VolumeDown(int lever) {
		if (volumeLevel - lever >=TV_MIN_VILUME) {
			volumeLevel-= lever;
			System.out.println("TV 볼륨을 "+ lever+ "내려 현재"+volumeLevel);
		}else {
			int tempLevel = TV_MIN_VILUME - volumeLevel;
			volumeLevel = TV_MIN_VILUME;
			System.out.println("TV 볼륨을 "+ lever+ "만큼 못 내리고 "+tempLevel+"만큼 내려 최소치"+ TV_MIN_VILUME);
		}
		
	}

}
