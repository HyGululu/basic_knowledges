package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GsonUtil
 */
public class GsonUtil {
	private static Gson gson;

	static {
		if(Objects.isNull(gson)){
			gson = new Gson();
		}
	}

	private GsonUtil(){}

	/**
	 * 将object对象转成json字符串
	 *
	 * @param o
	 * @return
	 */
	public static String toJsonString(Object o){
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(o);
		}
		return gsonString;
	}

	/**
	 * 将gsonString转成泛型bean
	 *
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T toObject(String gsonString, Class<T> cls) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, cls);
		}
		return t;
	}

	/**
	 * 转成list
	 * 解决泛型在编译期类型被擦除导致报错
	 *
	 * @param json
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> jsonToList(String json, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for (final JsonElement elem : array) {
			list.add(gson.fromJson(elem, cls));
		}
		return list;
	}





}
