package com.github.akagawatsurunaki.memodemo.utils;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.github.akagawatsurunaki.memodemo.model.enumeration.PartOfSpeech;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.time.DayOfWeek;


/**
 * @author Akagawa Tsurunaki
 *
 */
public class GsonUtil {
	
	// #region Regist Global Gson

	// Regist a global gson in order to serialize and deserialize.
	public static Gson glbGson = new GsonBuilder()
	  .registerTypeAdapter(PartOfSpeech.class, new JsonSerializer<PartOfSpeech>() {
		@Override
		public JsonElement serialize(PartOfSpeech ps, Type srcType, JsonSerializationContext context) {
			return new JsonPrimitive(ps.toString());
		}
	}).create();
	
//	public static String fromRegularBusTableToJson(Table<RegularBus> regularBusTable) {
//		return glbGson.toJson(regularBusTable, new TypeToken<Table<RegularBus>>() {}.getType());
//	}
//	
//	public static Table<RegularBus> fromJsonToRegularBusTable(String json){
//		return glbGson.fromJson(json, new TypeToken<Table<RegularBus>>() {}.getType());
//	}
	
}
