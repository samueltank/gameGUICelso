package br.senai.sp.jandira.lista;

import java.util.HashMap;

public enum TipoConsole {

	PLAYSTATION4("playstation4", 2000.00),
	PLAYSTATION5("playstation5", 4000.00), XBOX("xbox", 2000.00),
	XBOXONE("xboxone", 5000.00), PC("pc", 3000.00),
	NINTENDOSWITCH("nintendo switch", 3000.00);

	private String description;
	private double value;

	private static HashMap<String, TipoConsole> valuesEnum =
			new HashMap<String, TipoConsole>();

	static {
		for (TipoConsole i : TipoConsole.values()) {
			valuesEnum.put(i.getDescription(), i);
		}
	}

	private TipoConsole(String description, double value) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public double getValue() {
		return value;
	}

	public static TipoConsole getValueForEnum(String value) {
		return valuesEnum.get(value);
	}
}
