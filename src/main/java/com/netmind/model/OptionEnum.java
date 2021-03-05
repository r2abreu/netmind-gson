package com.netmind.model;

public enum OptionEnum {
	ADD_STUDENT(1), OLDEST_STUDENT(2), EXIT(3);

	private int value;

	private OptionEnum(int value) {
		this.value = value;
	}

	public static OptionEnum fromValue(int value) {
		for (OptionEnum my : OptionEnum.values()) {
			if (my.value == value) {
				return my;
			}
		}

		return null;
	}

	public int value() {
		return value;
	}

}
