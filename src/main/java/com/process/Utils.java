package com.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.valueobject.BuildVo;
import com.valueobject.Constants;
import com.valueobject.Pair;

/**
 * Utils contains methods used for generating individual report components
 * 
 * @author Akshay Singh
 *
 */
public class Utils {
	
	List<BuildVo> builds;
	
	public Utils(List<BuildVo> builds) {
		this.builds = builds;
	}
	
	public String getUnqCustIdsContracts() {

		Map<String, Integer> map = new HashMap<>();
		for(BuildVo build : builds) {
			if(map.containsKey(build.getContractId()))
				map.put(build.getContractId(), map.get(build.getContractId())+1);
			else
				map.put(build.getContractId(), 1);
		}

		StringBuffer str = new StringBuffer();
		str.append("The number of unique customerId for each contractId:");
		str.append(System.lineSeparator());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			str.append(entry.getKey() + " : " + entry.getValue());
			str.append(Constants.LINEBREAK);
	    }
		return str.toString();

	}

	public String getUnqCustIdsGeoZone() {

		Map<String, Integer> map = new HashMap<>();
		for(BuildVo build : builds) {
			if(map.containsKey(build.getGeoZone()))
				map.put(build.getGeoZone(), map.get(build.getGeoZone())+1);
			else
				map.put(build.getGeoZone(), 1);
		}

		StringBuffer str = new StringBuffer();
		str.append("The number of unique customerId for each Geo Zone:");
		str.append(System.lineSeparator());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			str.append(entry.getKey() + " : " + entry.getValue());
			str.append(Constants.LINEBREAK);
	    }
		return str.toString();

	}

	public String getAvgBuildGeoZone() {

		Map<String, Pair> map = new HashMap<>();
		for(BuildVo build: builds) {
			if(map.containsKey(build.getGeoZone())) {
				Pair pair = map.get(build.getGeoZone());
				pair.increaseFrequency();
				pair.increaseTotal(build.getDuration());
				map.put(build.getGeoZone(), pair);
			}
			else {
				Pair pair = new Pair(build.getDuration());
				map.put(build.getGeoZone(), pair);
			}
		}
		
		StringBuffer str = new StringBuffer();
		str.append("The average buildduration for each geozone:");
		str.append(System.lineSeparator());
		for (Map.Entry<String, Pair> entry : map.entrySet()) {
			str.append(entry.getKey() + ":" + entry.getValue().getAverage());
			str.append(Constants.LINEBREAK);
	    }
		
		return str.toString();
	}

	public String getUnqCustIdsGeoZoneList() {

		Map<String, Set<String>> map = new HashMap<>();
		
		for(BuildVo build : builds) {
			if(map.containsKey(build.getGeoZone())) {
				Set<String> set = map.get(build.getGeoZone());
				set.add(build.getCustomerId());
				map.put(build.getGeoZone(), set);
			}
			else {
				Set<String> set = new HashSet<>();
				set.add(build.getCustomerId());
				map.put(build.getGeoZone(), set);
			}
		}
		
		StringBuffer str = new StringBuffer();
		str.append("The list of unique customerId for each geozone:");
		str.append(System.lineSeparator());
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			str.append(entry.getKey() + ":" + entry.getValue().toString());
			str.append(Constants.LINEBREAK);
	    }
		
		return str.toString();
		
	}

}
