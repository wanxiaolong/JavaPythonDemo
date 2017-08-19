package com.my.py;

import java.util.Properties;

import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class CallPython {
	
	public static void main(String[] args) {
		//Set local variables for Python
		Properties properties = new Properties();
		properties.put("name", "World");
		System.out.println("1.In Java--------Start calling Python script file");
		//Call Python script
		executePythonScript("src/calljava.py", properties);
		System.out.println("6.In Java--------End Pythion call");
	}
	
	public static void executePythonScript(String scriptFile, Properties properties) {
		PythonInterpreter interpreter = getPythonInterpreter(properties);
		try {
			interpreter.execfile(scriptFile);
		} catch (Exception e) {
			System.out.println("Execute Python encounter exception:" + e);
		}
	}
	
	private static PythonInterpreter getPythonInterpreter(Properties properties) {
        PySystemState.initialize(System.getProperties(), properties, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
		
		for (Object key : properties.keySet()) {
			interpreter.set((String)key, properties.get(key));
		}
		return interpreter;
	}
}