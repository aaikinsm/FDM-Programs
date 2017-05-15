import java.util.List;

public class Pair<K,V> {

	private List<K> key;
	private List<V> value;
	
	public List<K> getKey() {
		return key;
	}
	public void setKey(List<K> key) {
		this.key = key;
	}
	public List<V> getValue() {
		return value;
	}
	public void setValue(List<V> value) {
		this.value = value;
	}
}
