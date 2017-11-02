package com.xz.drip.service.util;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;

import java.util.*;

/**
 * Created by MABIAO on 2017/11/2.
 */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isNotNullOrEmptyArray(T[] array) {
        return array != null && array.length != 0;
    }

    public static <T> List<T> mergeAll(List<T>... lists) {
        ArrayList mergedList = new ArrayList();
        int i = 0;

        for(int len = lists.length; i < len; ++i) {
            List list = lists[i];
            if(list != null && !list.isEmpty()) {
                int j = 0;

                for(int lenj = list.size(); j < lenj; ++j) {
                    Object obj = list.get(j);
                    if(obj != null) {
                        mergedList.add(obj);
                    }
                }
            }
        }

        return mergedList;
    }

    public static <T> List<T> asList(T... objs) {
        if(objs == null) {
            return Collections.EMPTY_LIST;
        } else {
            ArrayList list = new ArrayList();
            Collections.addAll(list, objs);
            return list;
        }
    }

    public static <K, V> Map<K, V> makeMap(K key, V value) {
        HashMap map = new HashMap();
        map.put(key, value);
        return map;
    }

    public static <K, V> Map<K, V> makeMapFromLists(List<K> list1, List<V> list2) {
        HashMap map = new HashMap();
        if(list1.size() != list2.size()) {
            return null;
        } else {
            for(int i = 0; i < list1.size(); ++i) {
                map.put(list1.get(i), list2.get(i));
            }

            return map;
        }
    }

    public static <K, V> Map<K, V> makeMap(K key1, V value1, K key2, V value2) {
        HashMap map = new HashMap();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }

    public static <T> boolean contains(T[] array, T val) {
        Object[] var5 = array;
        int var4 = array.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Object t = var5[var3];
            if(val.equals(t)) {
                return true;
            }
        }

        return false;
    }

    public static String join(Object[] words, String seperator) {
        StringBuilder sb = new StringBuilder();
        if(words != null) {
            for(int i = 0; i < words.length; ++i) {
                sb.append(words[i]);
                if(i < words.length - 1) {
                    sb.append(seperator);
                }
            }
        }

        return sb.toString();
    }

    public static String join(Collection<?> collection, String seperator) {
        Object[] objs = new Object[collection.size()];
        collection.toArray(objs);
        return join((Object[])objs, seperator);
    }

    public static String join(List<?> list, String seperator) {
        Object[] objs = new Object[list.size()];
        list.toArray(objs);
        return join((Object[])objs, seperator);
    }

//    public static <T> T find(Collection<T> collection, String propertyName, Object propertyValue) {
//        return org.apache.commons.collections.CollectionUtils.find(collection, new BeanPropertyValueEqualsPredicate(propertyName, propertyValue));
//    }
//
//    public static <T> T find(Collection<T> collection, Map<String, Object> propertyValueMap) {
//        BeanPropertyValueEqualsPredicate[] predicates = new BeanPropertyValueEqualsPredicate[propertyValueMap.size()];
//        Set propertyNameSet = propertyValueMap.keySet();
//        int index = 0;
//
//        for(Iterator var6 = propertyNameSet.iterator(); var6.hasNext(); ++index) {
//            String allPredicate = (String)var6.next();
//            predicates[index] = new BeanPropertyValueEqualsPredicate(allPredicate, propertyValueMap.get(allPredicate));
//        }
//
//        AllPredicate var7 = new AllPredicate(predicates);
//        return org.apache.commons.collections.CollectionUtils.find(collection, var7);
//    }
//
//    public static <T, PropType> Collection<PropType> collect(Collection<T> collection, String propertyName) {
//        BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer(propertyName);
//        return org.apache.commons.collections.CollectionUtils.collect(collection, transformer);
//    }

    public static <T> T[] copy(T[] sourceArray) {
        return sourceArray == null?null:Arrays.copyOf(sourceArray, sourceArray.length);
    }
}
