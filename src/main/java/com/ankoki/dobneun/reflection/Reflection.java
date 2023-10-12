package com.ankoki.dobneun.reflection;

import com.ankoki.dobneun.misc.Misc;
import com.ankoki.dobneun.misc.Version;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reflection {

	public static final String VERSION_PACKAGE = "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];

	/**
	 * Checks if a class exists.
	 *
	 * @param clazz the class to look for.
	 * @return true if it exists.
	 */
	public static boolean classExists(String clazz) {
		try {
			Class.forName(clazz);
			return true;
		} catch (ReflectiveOperationException ex) { return false; }
	}

	/**
	 * Gets the NMS class, taking into account minecraft version.
	 *
	 * @param newPackage the 1.18+ version package.
	 * @param clazz the class name.
	 * @return the Class object.
	 */
	public static Class<?> getClass(String newPackage, String clazz) {
		try {
			return Class.forName((Version.v1_18_R1.isNewerThanCurrent() ? VERSION_PACKAGE : "net.minecraft." + newPackage) + "." + clazz);
		} catch (ReflectiveOperationException ex) { Misc.handleException(ex); }
		return null;
	}

	/**
	 * Gets a craft bukkit class.
	 *
	 * @param clazz the class to retrieve.
	 * @return the class object.
	 */
	@Nullable
	public static Class<?> getCraftBukkit(String clazz) {
		try {
			return Class.forName("org.bukkit.craftbukkit." + Version.CURRENT.name() + "." + clazz);
		} catch (ReflectiveOperationException ex) { Misc.handleException(ex); }
		return null;
	}

	/**
	 * Invokes a given method name on the given class with the parameters.
	 * Will not work on classes where the parameter types are subclasses.
	 *
	 * @param clazz the class to execute this on.
	 * @param name the name of the method.
	 * @param object the object to call it on. May be null if static.
	 * @param parameters the parameters to use. May be empty.
	 * @return the methods returned object, or null if not present.
	 */
	@Nullable
	@SafeVarargs
	public static Object invokeMethod(Class<?> clazz, String name, Object object, Pair<Class<?>, Object>... parameters) {
		Class<?>[] parameterTypes = new Class[parameters.length];
		for (int i = 0; i < parameters.length; i++)
			parameterTypes[i] = parameters[i].getLeft();
		Object[] parameterVar = new Object[parameters.length];
		for (int i = 0; i < parameters.length; i++)
			parameterVar[i] = parameters[i].getRight();
		try {
			Method method = clazz.getMethod(name, parameterTypes);
			method.trySetAccessible();
			return method.invoke(object, parameterVar);
		} catch (ReflectiveOperationException ex) { Misc.handleException(ex); }
		return null;
	}

	/**
	 * Gets the field of with the given name.
	 *
	 * @param clazz the class to get the field from.
	 * @param name the name of the field.
	 * @return the field object.
	 */
	@Nullable
	public static Field getField(Class<?> clazz, String name) {
		Field[] fields = Reflection.getFields(clazz);
		for (Field field : fields) {
			if (field.getName().equals(name))
				return field;
		}
		return null;
	}

	/**
	 * Gets all fields of a class, including the super class methods.
	 *
	 * @param clazz the class to get the fields of.
	 * @return the fields.
	 */
	@NotNull
	public static Field[] getFields(Class<?> clazz) {
		Field[] declared = clazz.getDeclaredFields();
		Field[] methods = clazz.getFields();
		List<Field> all = new ArrayList<>();
		Collections.addAll(all, declared);
		Collections.addAll(all, methods);
		return all.toArray(new Field[0]);
	}

	/**
	 * Gets the method with the given name and parameter types.
	 *
	 * @param clazz the class to get the method from.
	 * @param name the name of the method.
	 * @param parameters the parameter types. May be empty.
	 * @return the corresponding method, or null if not found.
	 */
	@Nullable
	public static Method getMethod(Class<?> clazz, String name, Class<?>... parameters) {
		Method[] methods = Reflection.getMethods(clazz);
		for (Method method : methods) {
			if (method.getName().equals(name) && method.getParameterTypes() == parameters)
				return method;
		}
		return null;
	}

	/**
	 * Gets all methods of a class, including the super class methods.
	 *
	 * @param clazz the class to get the methods of.
	 * @return the methods.
	 */
	@NotNull
	public static Method[] getMethods(Class<?> clazz) {
		Method[] declared = clazz.getDeclaredMethods();
		Method[] methods = clazz.getMethods();
		List<Method> all = new ArrayList<>();
		Collections.addAll(all, declared);
		Collections.addAll(all, methods);
		return all.toArray(new Method[0]);
	}

	/**
	 * Sets the field of this class.
	 *
	 * @param clazz the class.
	 * @param object the instance of the class, may be null if static.
	 * @param name the name of the field.
	 * @param value the value to set the field to.
	 */
	public static void setField(Class<?> clazz, Object object, String name, Object value) {
		try {
			Field field = Reflection.getField(clazz, name);
			if (field == null)
				throw new ReflectiveOperationException("Field '" + name + "' does not exist in '" + clazz.getName() + "', or any superclasses.");
			field.setAccessible(true);
			field.set(object, value);
			field.setAccessible(false);
		} catch (ReflectiveOperationException ex) { Misc.handleException(ex); }
	}

}
