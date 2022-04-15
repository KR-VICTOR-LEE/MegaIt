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
			System.out.println("SPEAKER 볼륨을 1 올렸습니다 현재 "+volumeLevel);
		}else {
			System.out.println("SPEAKER 볼륨이 최대치 입니다 ");
		}
		
	}

	@Override
	public void VolumeUp(int lever) {
		if (volumeLevel + lever <= SPEAKER_MAX_VOLUME) { // lever 만큼 올림
			volumeLevel += lever;
			System.out.println("SPEAKER 볼륨을 "+ lever +"올려 현재 "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER 볼륨을 "+lever+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치 "+SPEAKER_MAX_VOLUME);
		}
		
	}

	@Override
	public void VolumeDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("SPEAKER 볼륨을 1 내렸습니다 현재 "+volumeLevel);
		}else {
			System.out.println("SPEAKER 볼륨이 ");
		}
		
	}

	@Override
	public void VolumeDown(int lever) {
		if (volumeLevel - lever >=SPEAKER_MIN_VOLUME) {
			volumeLevel-= lever;
			System.out.println("SPEAKER 볼륨을 "+ lever+ "내려 현재"+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MIN_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER 볼륨을 "+ lever+ "만큼 못 내리고 "+tempLevel+"만큼 내려 최소치"+ SPEAKER_MIN_VOLUME);
		}
		
	}
}
