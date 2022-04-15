package com.lec.ex02_store;
// implements ·Î ¼öÁ¤, str Ãß°¡ , »ı¼ºÀÚ ¼öÁ¤, getterÃß°¡
//1È£Á¡: ±èÄ¡Âî°³-4,500 ºÎ´ëÂî°³-5,000 ºñºö¹ä-6,000 ¼ø´ë±¹-¾ÈÆÈ¾Æ °ø±â¹ä-1,000¿ø
public class Store1 implements HeadQuarterStore{
	private String str;
	public Store1(String str) {
		this.str = str;
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ - 5,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ ¾È ÆÈ¾Æ");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ - 4,500¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä - 6,000¿ø");
	}
	@Override
	public void gonggibab() {
		System.out.println("ºñºö¹ä - 1,000¿ø");
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
