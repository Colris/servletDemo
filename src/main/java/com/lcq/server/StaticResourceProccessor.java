package com.lcq.server;

import java.io.IOException;

public class StaticResourceProccessor {
	public void proccess(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
