package com.gentle;

import com.gentle.helper.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Smith on 2017/5/17.
 */
public final class Loader {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void load() {
        Class[] classes = {
                ClassHelper.class,
                ControllerHelper.class,
                BeanHelper.class,
                AopHelper.class,
                DbHelper.class,
        };

        for (Class cls: classes) {
            loadClass(cls);
        }
    }

    private static void loadClass(Class cls) {
        try {
            Class.forName(cls.getName(), true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("class not found");
        }
    }
}
