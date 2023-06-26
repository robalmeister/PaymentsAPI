package io.github.robalmeister.payments.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;
import okhttp3.MediaType;

@UtilityClass
public class Json {
    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static final MediaType TYPE_JSON = MediaType.get("application/json; charset=utf-8");
}
