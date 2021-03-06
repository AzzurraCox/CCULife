package org.zankio.ccudata.base.source.http;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.zankio.ccudata.base.model.HttpResponse;
import org.zankio.ccudata.base.model.JSON;
import org.zankio.ccudata.base.model.Request;

public abstract class HTTPJSONSource<TArgument, TData> extends HTTPSource<TArgument, TData>{

    @Override
    protected TData parse(Request<TData, TArgument> request, HttpResponse response) throws Exception {
        String jsonBody = response.string();
        JSON json;

        if ( jsonBody.startsWith("<")){
            return null;
        }
        if (jsonBody.startsWith("[")) {
            Log.d("json_log", jsonBody);
            json = new JSON(new JSONArray(jsonBody));
        }
        else {
            Log.d("json_log", jsonBody);
            json = new JSON(new JSONObject(jsonBody));
        }
        return parse(request, response, json);
    }

    protected abstract TData parse(Request<TData, TArgument> request, HttpResponse response, JSON json) throws JSONException;
}
