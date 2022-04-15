package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume[] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(7)};
		for(IVolume temp : volumes) {
			temp.VolumeDown();
			temp.VolumeDown(20);
			temp.VolumeUp(10);
			temp.VolumeUp(45);
			temp.setMute(true); // default ¸Þ¼Òµå d
			System.out.println("===============================");
		}
	}

}
