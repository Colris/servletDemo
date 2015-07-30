package com.lcq.server;

import java.io.IOException;

import com.lcq.http.Request;
import com.lcq.http.Response;

public class StaticResourceProccessor {
	public void proccess(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
