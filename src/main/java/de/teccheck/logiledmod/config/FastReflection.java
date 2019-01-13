package de.teccheck.logiledmod.config;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FastReflection {

	public static void setFieldValue(Object instance, String fieldName, Object value)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(instance, value);
	}

	public static Object getFieldValue(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(instance);
	}

	public static Object superSuperGetFieldValue(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = instance.getClass().getSuperclass().getSuperclass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(instance);
	}

	public static Object superGetFieldValue(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = instance.getClass().getSuperclass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(instance);
	}

	public static List<String> getPrivateFields(Object instance) {
		List<String> privateFields = new ArrayList<>();
		Field[] allFields = instance.getClass().getSuperclass().getSuperclass().getDeclaredFields();
		for (Field field : allFields) {
			privateFields.add(field.getName());
		}
		return privateFields;
	}

	public static Object callMethod(Object instance, String methodName, Object... parameters)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Class<?>[] classList = new Class<?>[parameters.length];
		for (Integer i = 0; i < parameters.length; i++) {
			classList[i] = parameters[i].getClass();
		}

		Method method = instance.getClass().getDeclaredMethod(methodName, classList);
		method.setAccessible(true);
		return method.invoke(instance, parameters);
	}

	public static Object callStaticMethod(Class<?> classType, String methodName, Object... parameters)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Class<?>[] classList = new Class<?>[parameters.length];
		for (Integer i = 0; i < parameters.length; i++) {
			classList[i] = parameters[i].getClass();
		}

		Method method = classType.getDeclaredMethod(methodName, classList);
		method.setAccessible(true);
		return method.invoke(null, parameters);
	}

	public static Object createInstance(Class<?> classType, Object... parameters)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
		Class<?>[] classList = new Class<?>[parameters.length];
		for (Integer i = 0; i < parameters.length; i++) {
			classList[i] = parameters[i].getClass();
		}

		Constructor<?> constructor = classType.getDeclaredConstructor(classList);
		constructor.setAccessible(true);
		return constructor.newInstance(parameters);
	}
}