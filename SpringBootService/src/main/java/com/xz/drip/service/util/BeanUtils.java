package com.xz.drip.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MABIAO on 2017/11/2.
 */
public final class BeanUtils {
    private static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);
    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap();

    private BeanUtils() {
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> destClass) {
        String key = sourceClass.getCanonicalName() + ":" + destClass.getCanonicalName();
        BeanCopier beanCopier = (BeanCopier)BEAN_COPIER_CACHE.get(key);
        if(beanCopier == null) {
            beanCopier = BeanCopier.create(sourceClass, destClass, false);
            BEAN_COPIER_CACHE.putIfAbsent(key, beanCopier);
        }

        return beanCopier;
    }

    public static <T> T copyAs(Object source, Class<T> destType) throws Exception {
        if(source != null && destType != null) {
            try {
                BeanCopier e = getBeanCopier(source.getClass(), destType);
                T dest = destType.newInstance();
                e.copy(source, dest, (Converter)null);
                return dest;
            } catch (Exception var4) {
                throw var4;
            }
        } else {
            return null;
        }
    }

    public static <T, K> List<K> copyAs(Collection<T> source, Class<K> destType) throws Exception {
        if(!CollectionUtils.isNullOrEmpty(source) && destType != null) {
            ArrayList result = new ArrayList();
            if(source.isEmpty()) {
                return result;
            } else {
                try {
                    Iterator var4 = source.iterator();

                    while(var4.hasNext()) {
                        Object e = var4.next();
                        BeanCopier beanCopier = getBeanCopier(e.getClass(), destType);
                        Object dest = destType.newInstance();
                        beanCopier.copy(e, dest, (Converter)null);
                        result.add(dest);
                    }

                    return result;
                } catch (Exception var7) {
                    throw var7;
                }
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static void copy(Object source, Object target) {
        if(source != null && target != null) {
            BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
            beanCopier.copy(source, target, (Converter)null);
        }
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    public static void copyMapToObject(Map<?, ?> source, Object target) throws Exception {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(target, source);
        } catch (Exception var3) {
            throw var3;
        }
    }

    public static void setProperty(Object bean, String name, Object value) throws Exception {
        try {
            org.apache.commons.beanutils.BeanUtils.setProperty(bean, name, value);
        } catch (Exception var4) {
            throw var4;
        }
    }

    public static Object getProperty(Object bean, String name) throws Exception {
        try {
            return org.apache.commons.beanutils.BeanUtils.getProperty(bean, name);
        } catch (Exception var3) {
            throw var3;
        }
    }

    public static void setFieldValue(Object bean, String fieldName, Object value) throws Exception {
        try {
            Field e = findField(bean.getClass(), fieldName);
            e.setAccessible(true);
            e.set(bean, value);
        } catch (Exception var4) {
            throw var4;
        }
    }

    public static Field findField(Class<?> clz, String fieldName) {
        Field f = null;

        try {
            f = clz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException var4) {
            if(clz.getSuperclass() != null) {
                f = findField(clz.getSuperclass(), fieldName);
            }

            if(LOG.isTraceEnabled()) {
                LOG.trace(var4.getMessage(), var4);
            }
        }

        return f;
    }

    public static void copyNotNullProperties(Object srcModel, Object destModel) throws Exception {
        if(srcModel != null && destModel != null) {
            try {
                PropertyDescriptor[] e = Introspector.getBeanInfo(srcModel.getClass()).getPropertyDescriptors();
                PropertyDescriptor[] destDescriptors = Introspector.getBeanInfo(destModel.getClass()).getPropertyDescriptors();
                HashMap destPropertyNameDescriptorMap = new HashMap();
                PropertyDescriptor[] var8 = destDescriptors;
                int var7 = destDescriptors.length;

                PropertyDescriptor srcDescriptor;
                int var6;
                for(var6 = 0; var6 < var7; ++var6) {
                    srcDescriptor = var8[var6];
                    destPropertyNameDescriptorMap.put(srcDescriptor.getName(), srcDescriptor);
                }

                var8 = e;
                var7 = e.length;

                for(var6 = 0; var6 < var7; ++var6) {
                    srcDescriptor = var8[var6];
                    PropertyDescriptor destDescriptor = (PropertyDescriptor)destPropertyNameDescriptorMap.get(srcDescriptor.getName());
                    if(destDescriptor != null && destDescriptor.getPropertyType() == srcDescriptor.getPropertyType() && destDescriptor.getPropertyType() != Class.class && srcDescriptor.getReadMethod() != null) {
                        Object val = srcDescriptor.getReadMethod().invoke(srcModel, new Object[0]);
                        if(val != null && destDescriptor.getWriteMethod() != null) {
                            destDescriptor.getWriteMethod().invoke(destModel, new Object[]{val});
                        }
                    }
                }

            } catch (Exception var11) {
                throw var11;
            }
        }
    }

    public static void copyNonCollectionProperties(Object source, Object target) {
        ArrayList ignoreProperties = new ArrayList();
        Field[] declaredFields = target.getClass().getDeclaredFields();
        Field[] var7 = declaredFields;
        int var6 = declaredFields.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            Field field = var7[var5];
            if(Collection.class.isAssignableFrom(field.getType()) || Map.class.isAssignableFrom(field.getType())) {
                ignoreProperties.add(field.getName());
            }
        }

        org.springframework.beans.BeanUtils.copyProperties(source, target, (String[])ignoreProperties.toArray(new String[ignoreProperties.size()]));
    }
}
