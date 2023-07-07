package com.lec.ex03_speaktv;
public class Speaker implements IVolume {
	private int volumeLevel;
	public Speaker() {
		volumeLevel = 5;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < IVolume.TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려현재 볼륨은"+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치(" + IVolume.TV_MAX_VOLUME+")여서 올리지 못함");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level < TV_MAX_VOLUME) {
			volumeLevel += level; //volumeLevel = volumeLevel + level;
			System.out.println("TV 볼륨을 "+level + "만큼 올려 현재 볼륨은" + volumeLevel);
		}else {
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV볼륨을"+ tempLevel + "만큼 올려도 최대치("+ TV_MAX_VOLUME+")입니다");
		}
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		
	}

	
}
