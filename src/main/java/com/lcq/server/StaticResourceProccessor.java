package com.lcq.server;

import java.io.IOException;

public class StaticResourceProccessor {
	public void proccess(HttpRequest request, HttpResponse response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
