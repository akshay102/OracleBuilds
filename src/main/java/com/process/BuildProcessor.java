package com.process;

import java.util.List;

import com.exception.ParseException;
import com.valueobject.BuildVo;

/**
 * The entry point for the program. This contains a method process(String input) 
 * which accepts an input String and generates a report on average build time and other parameters.
 * 
 * @author Akshay Singh
 * @throws ParseException
 *
 */
public class BuildProcessor {

	public void process(String input) throws ParseException {

		BuildParser parser = new BuildParser();
		List<BuildVo> builds = parser.parse(input);
		ReportGenerator rg = new ReportGenerator();
		rg.generateReport(builds);

	}


}
