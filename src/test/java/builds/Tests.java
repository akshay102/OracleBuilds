package builds;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.exception.ParseException;
import com.process.Utils;
import com.process.BuildParser;
import com.valueobject.BuildVo;
import com.valueobject.Constants;

public class Tests {
	
	@Test
	public void parseLineTest() throws IOException, ParseException {
		Path path = Paths.get("testcases.txt");
	    String read = Files.readAllLines(path).get(0);
	    BuildParser bp = new BuildParser();
	    BuildVo buildVo = bp.parseLine(read);
	    assertEquals(buildVo.getCustomerId(),"2343225");
	    assertEquals(buildVo.getContractId(),"2345");
	    assertEquals(buildVo.getGeoZone(),"us_east");
	    assertEquals(buildVo.getTeamCode(),"RedTeam");
	    assertEquals(buildVo.getProjectCode(),"ProjectApple");
	    assertEquals(buildVo.getDuration(),3445);
	}

	@Test
	public void getUnqCustIdsContractsTest() throws IOException, ParseException {
		
		Path path = Paths.get("testcases.txt");
	    List<String> lines = Files.readAllLines(path);
	    StringBuffer str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    BuildParser bp = new BuildParser();
	    Utils utils = new Utils(bp.parse(str.toString()));
	    String output = utils.getUnqCustIdsContracts();
	    
	    Path path_sol = Paths.get("getUnqCustIdsContractsTest.txt");
	    lines = Files.readAllLines(path_sol);
	    str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    String output_sol = str.toString();
	    
	    assertEquals(output,output_sol);
	    
	}
	
	@Test
	public void getUnqCustIdsGeoZoneTest() throws IOException, ParseException {
		
		Path path = Paths.get("testcases.txt");
	    List<String> lines = Files.readAllLines(path);
	    StringBuffer str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    BuildParser bp = new BuildParser();
	    Utils utils = new Utils(bp.parse(str.toString()));
	    String output = utils.getUnqCustIdsGeoZone();
	    
	    Path path_sol = Paths.get("getUnqCustIdsGeoZoneTest.txt");
	    lines = Files.readAllLines(path_sol);
	    str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    String output_sol = str.toString();
	    
	    assertEquals(output,output_sol);
	    
	    
	}
	
	@Test
	public void getAvgBuildGeoZoneTest() throws IOException, ParseException {
		
		Path path = Paths.get("testcases.txt");
	    List<String> lines = Files.readAllLines(path);
	    StringBuffer str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    BuildParser bp = new BuildParser();
	    Utils utils = new Utils(bp.parse(str.toString()));
	    String output = utils.getAvgBuildGeoZone();
	    
	    Path path_sol = Paths.get("getAvgBuildGeoZoneTest.txt");
	    lines = Files.readAllLines(path_sol);
	    str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    String output_sol = str.toString();
	    assertEquals(output,output_sol);
	    
	}
	
	@Test
	public void getUnqCustIdsGeoZoneListTest() throws IOException, ParseException {
		
		Path path = Paths.get("testcases.txt");
	    List<String> lines = Files.readAllLines(path);
	    StringBuffer str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    BuildParser bp = new BuildParser();
	    Utils utils = new Utils(bp.parse(str.toString()));
	    String output = utils.getUnqCustIdsGeoZoneList();
	    
	    Path path_sol = Paths.get("getUnqCustIdsGeoZoneListTest.txt");
	    lines = Files.readAllLines(path_sol);
	    str = new StringBuffer();
	    for(String line : lines) {
	    	str.append(line);
	    	str.append(Constants.LINEBREAK);
	    }
	    String output_sol = str.toString();
	    assertEquals(output,output_sol);
	    
	}
}
