/*package TestScripts.API.walletTypeController;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.FileOperations;
import Framework.JsonModify;
import Framework.OracleConnection;
import Framework.PureSoftSoftAssert;
import Framework.RestAssured;
import Framework.StringOperations;
import Login.LoginUtility;
import Login.UserIdentificationType;
import Login.UserLoginModel;

public class TestCreateWalletType extends LoginUtility {

	private PureSoftSoftAssert softAssert;
	private static final Logger log = Logger.getLogger(TestCreateWalletType.class);
	private RestAssured rest = new RestAssured();
	private StringOperations stp = new StringOperations();
	private JsonModify modify = new JsonModify();
	private FileOperations fileOperations = new FileOperations();
	private OracleConnection connection = new OracleConnection();
	private String ID = null;
	private String mainTable = "wallettype";

	@BeforeMethod()
	public void intializeForMaker() throws IOException, ParseException {
		softAssert = new PureSoftSoftAssert();
	}

	@Test(description = "Validate create wallet Type For Maker...", priority = 1, groups = { "P1", "walletType" })
	public void createWalletTypeForMaker() throws IOException, InterruptedException, SQLException, ParseException {
		prop = loadTestCaseDataFromExcel("walletTypeCreate");
		String name=stp.generateRandomString(10, "AN");
		String walletNameBody=modify.modifyBodyParameterInnerJson(prop.getProperty("Body"), "managedObject.name", name);
		String currencyID = connection.getStringValuesFromDBQuery(prop.getProperty("query"), "id");
		String walletIdBody=modify.modifyBodyParameterInnerJson(walletNameBody, "managedObject.currencyId", currencyID);
		
		UserLoginModel makerLoginModel = loginResponse.get(UserIdentificationType.maker);
		rest.hitPostAPI(rest.getUpdatedHeader(makerLoginModel.token, makerLoginModel.id), walletIdBody, prop.getProperty("URL"));
		
		String walletId= rest.fetchValueFromResponce("responseObject.id");
		
		log.info("wallet Id : "+walletId);
		softAssert.assertEquals("verifying response code is `200...", rest.fetchValueFromResponce("responseCode"),"200");
		softAssert.assertEquals("verifying responseMessage...", rest.fetchValueFromResponce("responseMessage"), "");
		softAssert.assertEquals("verifying approval Status...", rest.fetchValueFromResponce("responseObject.approvalStatus"), "PENDING");
		softAssert.assertEquals("verifying validation error...", rest.fetchValueFromResponce("validationErrors"), null);
		softAssert.assertEquals("verifying processing Errors...", rest.fetchValueFromResponce("processingErrors"), null);
		
		softAssert.assertEquals("verifying  name...", rest.fetchValueFromResponce("responseObject.managedObject.name"), name);
		String name_key=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.name_key");
		softAssert.assertEquals("verifying  name_key...", rest.fetchValueFromResponce("responseObject.managedObject.name_key"), name_key);
		String currencyId=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.currencyId");
		softAssert.assertEquals("verifying  currency id...", rest.fetchValueFromResponce("responseObject.managedObject.currencyId"), currencyId);
		String description=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.description");
		softAssert.assertEquals("verifying  description...", rest.fetchValueFromResponce("responseObject.managedObject.description"), description);
		Boolean internalWallet =(Boolean) rest.fetchValueFromRequest(walletIdBody, "managedObject.internalWallet");
		softAssert.assertEquals("verifying internalWallet ...", rest.fetchBooleanValueFromResponce("responseObject.managedObject.internalWallet"), internalWallet);
		String walletType =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.walletType"); 
		softAssert.assertEquals("verifying  wallet type...", rest.fetchValueFromResponce("responseObject.managedObject.walletType"), walletType);				
		String parentGLId =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.parentGLId");
		softAssert.assertEquals("verifying  parentGLId...", rest.fetchValueFromResponce("responseObject.managedObject.parentGLId"), parentGLId);		
//		String walletCode =(String) rest.fetchValueFromRequest(walletNameBody, "managedObject.walletCode");
//		softAssert.assertEquals("verifying  walletCode...", rest.fetchValueFromResponce("responseObject.managedObject.walletCode"), walletCode);		
		String upperLimit =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.upperLimit");
		softAssert.assertEquals("verifying  upperLimit...", rest.fetchValueFromResponce("responseObject.managedObject.upperLimit"), upperLimit);		
		String lowerLimit =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.lowerLimit");
		softAssert.assertEquals("verifying  lowerLimit...", rest.fetchValueFromResponce("responseObject.managedObject.lowerLimit"), lowerLimit);		
		String conversionParentGL =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.conversionParentGL");
		softAssert.assertEquals("verifying  conversionParentGL...", rest.fetchValueFromResponce("responseObject.managedObject.conversionParentGL"), conversionParentGL);		
		String coreGlType =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.coreGlType");
		softAssert.assertEquals("verifying  coreGlType...", rest.fetchValueFromResponce("responseObject.managedObject.coreGlType"), coreGlType);		
		String remarks =(String) rest.fetchValueFromRequest(walletIdBody, "remarks"); 
		softAssert.assertEquals("verifying  remarks...", rest.fetchValueFromResponce("responseObject.remarks"), remarks);
	
		softAssert.assertEquals("verifying  walletType status in db...", connection.fetchData(fileOperations.getConfigProperty("tempTable"), "approvalstatus", "id", walletId), "PENDING");		

		softAssert.assertAll(prop.getProperty("testCaseId"));

	}
	
	@Test(description = "Validate create wallet Type For Checker...", priority = 1, groups = { "P1", "walletType" })
	public void createWalletTypeForChecker() throws IOException, InterruptedException, SQLException, ParseException {
		prop = loadTestCaseDataFromExcel("walletTypeCreate");
		String name=stp.generateRandomString(10, "AN");
		String walletNameBody=modify.modifyBodyParameterInnerJson(prop.getProperty("Body"), "managedObject.name", name);
		String currencyID = connection.getStringValuesFromDBQuery(prop.getProperty("query"), "id");
		String walletIdBody=modify.modifyBodyParameterInnerJson(walletNameBody, "managedObject.currencyId", currencyID);

		UserLoginModel checkerLoginModel = loginResponse.get(UserIdentificationType.checker);
		rest.hitPostAPI(rest.getUpdatedHeader(checkerLoginModel.token,checkerLoginModel.id), walletIdBody, prop.getProperty("URL"));
		
		String walletId= rest.fetchValueFromResponce("responseObject.id");
		ID = walletId;

		log.info("wallet Id : "+walletId);
		softAssert.assertEquals("verifying response code is 200...", rest.fetchValueFromResponce("responseCode"),"200");
		softAssert.assertEquals("verifying responseMessage...", rest.fetchValueFromResponce("responseMessage"), "");
		softAssert.assertEquals("verifying approval Status...", rest.fetchValueFromResponce("responseObject.approvalStatus"), "APPROVED");
		softAssert.assertEquals("verifying validation error...", rest.fetchValueFromResponce("validationErrors"), null);
		softAssert.assertEquals("verifying processing Errors...", rest.fetchValueFromResponce("processingErrors"), null);
		
		softAssert.assertEquals("verifying  name...", rest.fetchValueFromResponce("responseObject.managedObject.name"), name);
		String name_key=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.name_key");
		softAssert.assertEquals("verifying  name_key...", rest.fetchValueFromResponce("responseObject.managedObject.name_key"), name_key);
		String currencyId=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.currencyId");
		softAssert.assertEquals("verifying  currency id...", rest.fetchValueFromResponce("responseObject.managedObject.currencyId"), currencyId);
		String description=(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.description");
		softAssert.assertEquals("verifying  description...", rest.fetchValueFromResponce("responseObject.managedObject.description"), description);
		Boolean internalWallet =(Boolean) rest.fetchValueFromRequest(walletIdBody, "managedObject.internalWallet");
		softAssert.assertEquals("verifying internalWallet ...", rest.fetchBooleanValueFromResponce("responseObject.managedObject.internalWallet"), internalWallet);
		String walletType =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.walletType"); 
		softAssert.assertEquals("verifying  wallet type...", rest.fetchValueFromResponce("responseObject.managedObject.walletType"), walletType);				
		String parentGLId =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.parentGLId");
		softAssert.assertEquals("verifying  parentGLId...", rest.fetchValueFromResponce("responseObject.managedObject.parentGLId"), parentGLId);		
//		String walletCode =(String) rest.fetchValueFromRequest(walletNameBody, "managedObject.walletCode");
//		softAssert.assertEquals("verifying  walletCode...", rest.fetchValueFromResponce("responseObject.managedObject.walletCode"), walletCode);		
		String upperLimit =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.upperLimit");
		softAssert.assertEquals("verifying  upperLimit...", rest.fetchValueFromResponce("responseObject.managedObject.upperLimit"), upperLimit);		
		String lowerLimit =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.lowerLimit");
		softAssert.assertEquals("verifying  lowerLimit...", rest.fetchValueFromResponce("responseObject.managedObject.lowerLimit"), lowerLimit);		
		String conversionParentGL =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.conversionParentGL");
		softAssert.assertEquals("verifying  conversionParentGL...", rest.fetchValueFromResponce("responseObject.managedObject.conversionParentGL"), conversionParentGL);		
		String coreGlType =(String) rest.fetchValueFromRequest(walletIdBody, "managedObject.coreGlType");
		softAssert.assertEquals("verifying  coreGlType...", rest.fetchValueFromResponce("responseObject.managedObject.coreGlType"), coreGlType);		
		String remarks =(String) rest.fetchValueFromRequest(walletIdBody, "remarks"); 
		softAssert.assertEquals("verifying  remarks...", rest.fetchValueFromResponce("responseObject.remarks"), remarks);
	
		softAssert.assertEquals("verifying  walletType status in db...", connection.fetchData(fileOperations.getConfigProperty("tempTable"), "approvalstatus", "id", walletId), "APPROVED");		

		softAssert.assertAll(prop.getProperty("testCaseId"));

	}
	
	@AfterMethod
	public void cleanUp() throws SQLException {
	//	connection.cleanUp(mainTable, "id", ID);
	}

}
*/