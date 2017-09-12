package cw3;

import java.io.IOException;
import junit.framework.TestCase;

public class TDDtest extends TestCase{
	public void testHasTest() throws IOException {
		String[] args = {"-p","PUT.jar","-o","oracle.jar","-s","7","-n","20","-a","2","-r","0.0","1.0","-1.0","0.0"};
		TestHarness.main(args);
	}
	public void testExecuteProgram(){
		Runtime run=Runtime.getRuntime();
		String cmd = "java -jar "+"PUT.jar"+" 1.0 2.0";
		assertEquals("1.5", TestHarness.executeProgram(run,cmd));
	}
	public void testGetRange(){
		String[] args1 = {"-p","PUT.jar","-o","Oracle.jar","-s","7","-n","1000000000","-a","2","-r","0.0","1.0","-1.0","0.0"};
		assertEquals(true, TestHarness.getRange(args1,4)[0]==0.0);
		assertEquals(true, TestHarness.getRange(args1,4)[1]==1.0);
		assertEquals(true, TestHarness.getRange(args1,4)[2]==-1.0);
		assertEquals(true, TestHarness.getRange(args1,4)[3]==0.0);
		assertEquals(false, TestHarness.getRange(args1,4)[3]==5.0);
		String[] args2 = {"-p","PUT.jar","-o","Oracle.jar","-n","1000000000","-a","2","-r","0.0","1.0","-1.0","0.0"};
		assertEquals(true, TestHarness.getRange(args2,4)[0]==0.0);
		assertEquals(true, TestHarness.getRange(args2,4)[1]==1.0);
		assertEquals(true, TestHarness.getRange(args2,4)[2]==-1.0);
		assertEquals(true, TestHarness.getRange(args2,4)[3]==0.0);
		assertEquals(false, TestHarness.getRange(args2,4)[3]==5.0);
		assertEquals(false, TestHarness.getRange(args2,4)[3]==9.0);
	}
	public void testCheckPoInt(){
		assertEquals(true, TestHarness.checkPoInt("1"));
		assertEquals(false, TestHarness.checkPoInt("1.0"));
		assertEquals(false, TestHarness.checkPoInt("-1"));
		assertEquals(false, TestHarness.checkPoInt("sdkjhf"));
	}
	public void testCheckFloat(){
		assertEquals(true, TestHarness.checkFloat("-1.0"));
		assertEquals(false, TestHarness.checkFloat("-1.0.0"));
		assertEquals(false, TestHarness.checkFloat("aaskldjf"));
	}
	public void testSearchParameter(){
		String[] args1 = {"-p","PUT.jar","-o","Oracle.jar","-s","7","-n","1000000000","-a","2","-r","0.0","1.0","-1.0","0.0"};
		assertEquals("PUT.jar", TestHarness.searchParameter("-p",args1));
		assertEquals("Oracle.jar", TestHarness.searchParameter("-o",args1));
		assertEquals("7", TestHarness.searchParameter("-s",args1));
		assertEquals("1000000000", TestHarness.searchParameter("-n",args1));
		assertEquals("2", TestHarness.searchParameter("-a",args1));
		String[] args2 = {"-p","PUT.jar","-o","Oracle.jar","-n","10","-a","2","-r","0.0","1.0","-1.0","0.0"};
		assertEquals("null", TestHarness.searchParameter("-s",args2));
	}
	public void testGetParameter() {
		String[] args1 = {"-p","PUT.jar","-o","Oracle.jar","-s","7","-n","1000000000","-a","2","-r","0.0","1.0","-1.0","0.0"};
		assertEquals("PUT.jar", TestHarness.getParameter("-p",args1));
		assertEquals("Oracle.jar", TestHarness.getParameter("-o",args1));
		assertEquals("7", TestHarness.getParameter("-s",args1));
		assertEquals("1000000000", TestHarness.getParameter("-n",args1));
		assertEquals("2", TestHarness.getParameter("-a",args1));
	}
}