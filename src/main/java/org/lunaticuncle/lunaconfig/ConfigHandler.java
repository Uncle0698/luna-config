package org.lunaticuncle.lunaconfig;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;


public class ConfigHandler<T extends IConfig> {
	private static final Gson GSON = new Gson();
	private final String modID;
	private final Class<T> configClass;
	private T config;
	public final String defaultPath;
	public String filePath;

	public ConfigHandler(String modID, Class<T> config) {
		this.modID = modID;
		this.configClass = config;
		this.defaultPath = FabricLoader.getInstance().getConfigDir() + "/" + this.modID + ".json";
		this.filePath = defaultPath;
	}

	public void readConfig() {
		T loadedConfig;

		File configFile = new File(this.filePath);
		try {
			if(configFile.exists()) {
				BufferedReader bufReader = new BufferedReader(new FileReader(configFile));
				loadedConfig = GSON.fromJson(bufReader, configClass);
				this.config = loadedConfig;
			}

			if(!configFile.exists()) {
				loadedConfig = configClass.getDeclaredConstructor().newInstance();
				this.config = loadedConfig;
				writeConfig();
			}
		} catch (InstantiationException    |
				 IllegalAccessException    |
				 InvocationTargetException |
				 NoSuchMethodException     |
                 FileNotFoundException e)
		{
			System.err.println("Reading from config failed, file path: " + this.filePath);
			e.printStackTrace();
		}
	}

	public void writeConfig() {
		String jsonString = GSON.toJson(this.config);
		File configFile = new File(this.filePath);
		try(FileWriter fileWriter = new FileWriter(configFile)) {
			fileWriter.write(jsonString);
		} catch (IOException e) {
			System.err.println("Writing to config failed, file path: " + this.filePath);
            e.printStackTrace();
        }
    }

	public T getConfig() {
		return this.config;
	}
}
