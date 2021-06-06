package com.process;

import java.util.LinkedList;
import java.util.List;

import com.exception.ParseException;
import com.valueobject.BuildVo;
import com.valueobject.Constants;

/**
 * The class BuildParser is contains methods to parse
 * single and multi-line inputs into objects of type {@link com.valueobject.BuildVo}
 * 
 * @author Akshay Singh
 *
 */
public class BuildParser {
	
	public List<BuildVo> parse(String input) throws ParseException {
		
		String[] inputList = input.split(Constants.LINEBREAK);
		List<BuildVo> buildVoList = new LinkedList<>();
		
		for(String line : inputList) 
			buildVoList.add(parseLine(line));
		
		return buildVoList;
	}
	
	public BuildVo parseLine(String inputLine) throws ParseException {
		
		String[] fields = inputLine.split(Constants.BREAKPOINT);
		BuildVo buildVo = new BuildVo();
		
		try {
			buildVo.setCustomerId(fields[Constants.CUSTOMERID_POSITION]);
			buildVo.setContractId(fields[Constants.CONTRACTID_POSITION]);
			buildVo.setGeoZone(fields[Constants.GEOZONE_POSITION]);
			buildVo.setTeamCode(fields[Constants.TEAMCODE_POSITION]);
			buildVo.setProjectCode(fields[Constants.PROJECTCODE_POSITION]);
			buildVo.setDuration(fields[Constants.BUILDDURATION_POSITION]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParseException(inputLine);
		}
		
		return buildVo;
		
	}

}
