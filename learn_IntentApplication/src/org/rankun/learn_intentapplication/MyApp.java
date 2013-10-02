package org.rankun.learn_intentapplication;

import android.app.Application;

public class MyApp extends Application {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
