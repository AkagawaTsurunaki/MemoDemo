package com.github.akagawatsurunaki.memodemo.utils;


import java.lang.reflect.Type;

import com.github.akagawatsurunaki.memodemo.model.enumeration.PartOfSpeech;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Akagawa Tsurunaki
 *
 */
public class GsonUtil {

	// Regist a global gson in order to serialize and deserialize.
	public static Gson glbGson = new GsonBuilder()
	  .registerTypeAdapter(PartOfSpeech.class, new JsonSerializer<PartOfSpeech>() {
		@Override
		public JsonElement serialize(PartOfSpeech ps, Type srcType, JsonSerializationContext context) {
			return new JsonPrimitive(ps.toString());
		}
	}).create();
}
