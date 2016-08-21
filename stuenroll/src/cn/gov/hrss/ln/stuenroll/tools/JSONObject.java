package cn.gov.hrss.ln.stuenroll.tools;

/**
 * 生成一个json对象
 * @author LiYadong
 * @version 1.0
 */

public class JSONObject {
	
	private StringBuffer json = new StringBuffer();
	private int file = 0;

	public JSONObject() {
		super();
		json.append("{");
	}
	
	public void put(Object key, Object value) {
		file += 1;
		if (file > 1) {
			file = 1;
			json.append(",");
		}
		json.append("\"");
		json.append(key.toString());
		json.append("\"");
		json.append(":");
		json.append("\"");
		json.append(value.toString());
		json.append("\"");
	}
	
	@Override
	public String toString() {
		json.append("}");
		return json.toString();
	}
	
}
