package http;

import java.util.Map;

/**
 * Classe que implementa Map.Entry<String,String> para manipular variáveis do par <key,value>
 * @author Davi
 */
public final class PairKeyAndValue implements Map.Entry<String, String> {
	private final String key;
	private String value;

	public PairKeyAndValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String setValue(String value) {
		String old = this.value;
		this.value = value;
		return old;
	}
	@Override
	public String toString(){
		return String.format("(%s: %s)", key, value);
	}
}