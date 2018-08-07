package com.george.datastructure.list;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/7/17 16:33
 */
public class ListTest {

	private static List<Integer> getComparedList(List<Integer> data) {
		data.sort((o1, o2) -> {
			if (o1 > o2) {
				return -1;
			} else if (o1 < o2) {
				return 1;
			}
			return 0;
		});

		return data;
	}

	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		List<Integer> data = new ArrayList<>();
		data.add(4);
		data.add(3);
		data.add(10);
		data.add(8);
		data.add(1);

		System.out.println(getComparedList(data).toString());
	}
}

