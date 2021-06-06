package com.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.valueobject.BuildVo;
import com.valueobject.Constants;

/**
 * ReportGenerator class contains method to generate the final report
 * that will be accessed by the user with the expected data format.
 * 
 * @author Akshay Singh
 *
 */
public class ReportGenerator {
	
	public void generateReport(List<BuildVo> builds) {
		
		Path newFilePath = Paths.get(Constants.FILE_NAME);
		Utils utils = new Utils(builds);
		
	    try {
			Path path = Files.createFile(newFilePath);
			
			StringBuffer str = new StringBuffer();
			str.append(utils.getUnqCustIdsContracts());
			str.append(System.lineSeparator());
			str.append(System.lineSeparator());

			str.append(utils.getUnqCustIdsGeoZone());
			str.append(System.lineSeparator());
			str.append(System.lineSeparator());
			
			str.append(utils.getAvgBuildGeoZone());
			str.append(System.lineSeparator());
			str.append(System.lineSeparator());
			
			str.append(utils.getUnqCustIdsGeoZoneList().toString());
			
			Files.write(path, str.toString().getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
	}

}
