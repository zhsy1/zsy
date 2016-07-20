package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Title;
import excel.ExcelUtil;

public class Test1 {
	
	
	
	public static <K, V> Map<K, V> asMap( Object...objs ){
		if( objs == null || objs.length == 0 ){
			return new HashMap<K, V>();
		}
		
		Map<K, V> map = new HashMap<K, V>();
		for( int i = 0; i < objs.length; i +=2 ){
			int j = i + 1;
			map.put( (K)objs[i], j >= objs.length? null : (V)objs[j] );
		}
		System.out.println(map.toString());
		return map;
	}
	
	public static void main(String[] args) throws Exception{
		//asMap("apprecordId","123");
		
		List<Title> ts = new ArrayList<Title>();
		
		Title t1 = new Title();
		t1.setName("zsy");
		t1.setAge(26);
		ts.add(t1);
		
		Title t2 = new Title();
		t2.setName("czw");
		t2.setAge(27);
		ts.add(t2);
		
		
		ExcelUtil.createExcel(ts);
	}

}
