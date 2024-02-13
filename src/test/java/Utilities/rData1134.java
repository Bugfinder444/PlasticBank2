package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readString;

public class rData1134 {

    public static ArrayList<String> members = new ArrayList<String>();

    public static ArrayList<String> numbers = new ArrayList<String>();

    public static ArrayList<String> branches = new ArrayList<String>();
    public static ArrayList<String> processors = new ArrayList<String>();
    public static ArrayList<String> branchIds = new ArrayList<String>();
    public static ArrayList<String> processorIds = new ArrayList<String>();
    public static ArrayList<String> branchPCG = new ArrayList<String>();
    public static ArrayList<String> branchPCW = new ArrayList<String>();
    public static ArrayList<String> branchLRW = new ArrayList<String>();
    public static ArrayList<String> branchPC_CB = new ArrayList<String>();

    public static ArrayList<String> processorPCG = new ArrayList<String>();
    public static ArrayList<String> processorPCW = new ArrayList<String>();
    public static ArrayList<String> processorLRW = new ArrayList<String>();
    public static ArrayList<String> processorPC_CB = new ArrayList<String>();
    public static String bonusOrderName;
    public static String bonusOrderName2;
    public static String id1;
    public static String id2;
    public static String id3;
    public static String id4;
    public static String id5;
    public static String id6;
    public static String id7;
    public static String id8;
    public static String id9;
    public static String token1;
    public static String token2;
    public static String token3;
    public static String token7;
    public static String token8;
    public static String tokenP;

    public static String branchPCGidB1;


    Instant now = Instant.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSX").withZone(ZoneOffset.UTC);
    String formattedDateTime = formatter.format(now);

    public static String getRandomProcessorName() {
        String prefix = "process_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public static String getRandomBranch1Name() {
        String prefix = "brancha_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        int length = 8;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public static String getRandomBranch2Name() {
        String prefix = "branchb_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        int length = 8;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public static String getRandomBranch3Name() {
        String prefix = "branchc_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        int length = 8;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public static String getRandomBranch4Name() {
        String prefix = "branchd_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        int length = 8;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public static String getRandomBranch5Name() {
        String prefix = "branche_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(prefix);

        int length = 8;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }


    public static String getRandomStringWithChars(int length, String characters) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }

        return result.toString();
    }

    public static String generateUniqueDeviceID() {
        String format = "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX";
        String characters = "ABCDEF0123456789";

        StringBuilder deviceId = new StringBuilder();

        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == 'X') {
                char randomChar = characters.charAt(new Random().nextInt(characters.length()));
                deviceId.append(randomChar);
            } else {
                deviceId.append(format.charAt(i));
            }
        }

        return deviceId.toString();
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

    public void sendPostRequest() throws IOException {


        RestAssured.baseURI = "https://qapb.cognitionfoundry.io"; // Your API endpoint


//MEMBER CREATION------------------------------------------------------------------------------------------------------------------------------------------------
// Generate random username starting with "Fleek"
        String memberName1 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName1);
        System.out.println("member name is " + memberName1);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber1 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber1);
        numbers.add(memberNumber1);
// Generate unique device ID
        String deviceID1 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath1 = ".\\src/test/java/dataFiles687/m1.json"; // Update the path
        String templateContent1 = Files.readString(Paths.get(templatePath1));

// Replace placeholders with actual values
        String requestBody1 = templateContent1
                .replace("{{m1randomUsername}}", memberName1)
                .replace("{{m1randomNumber}}", memberNumber1)
                .replace("{{m1deviceID}}", deviceID1);

// Send the REST Assured request
        Response response1 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody1)
                .post("/register"); // Endpoint
        id1 = response1.path("id");
        System.out.println("id " + id1);
// Process the response as needed
        System.out.println("Response: " + response1.body().asString());


// Generate random username starting with "Fleek" M2
        String memberName2 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName2);
        System.out.println("member name is " + memberName2);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber2 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber2);
        numbers.add(memberNumber2);
// Generate unique device ID
        String deviceID2 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath2 = ".\\src/test/java/dataFiles687/m2.json"; // Update the path
        String templateContent2 = Files.readString(Paths.get(templatePath2));

// Replace placeholders with actual values
        String requestBody2 = templateContent2
                .replace("{{m2randomUsername}}", memberName2)
                .replace("{{m2randomNumber}}", memberNumber2)
                .replace("{{m2deviceID}}", deviceID2);

// Send the REST Assured request
        Response response2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody2)
                .post("/register"); // Endpoint
        id2 = response2.path("id");
        System.out.println("id " + id2);
// Process the response as needed
        System.out.println("Response: " + response2.body().asString());


// Generate random username starting with "Fleek" M3
        String memberName3 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName3);
        System.out.println("member name is " + memberName3);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber3 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber3);
        numbers.add(memberNumber3);
// Generate unique device ID
        String deviceID3 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath3 = ".\\src/test/java/dataFiles687/m3.json"; // Update the path
        String templateContent3 = Files.readString(Paths.get(templatePath3));

// Replace placeholders with actual values
        String requestBody3 = templateContent3
                .replace("{{m3randomUsername}}", memberName3)
                .replace("{{m3randomNumber}}", memberNumber3)
                .replace("{{m3deviceID}}", deviceID3);

// Send the REST Assured request
        Response response3 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody3)
                .post("/register"); // Endpoint
        id3 = response3.path("id");
        System.out.println("id " + id3);
// Process the response as needed
        System.out.println("Response: " + response3.body().asString());


        //Create member for Branch 1....    M4 ---> B1

        // Generate random username starting with "Fleek" M2
        String memberName4 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName4);
        System.out.println("member name is " + memberName4);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber4 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber4);
        numbers.add(memberNumber4);
// Generate unique device ID
        String deviceID4 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath4 = ".\\src/test/java/dataFiles687/m4.json"; // Update the path
        String templateContent4 = Files.readString(Paths.get(templatePath4));

// Replace placeholders with actual values
        String requestBody4 = templateContent4
                .replace("{{b1randomUsername}}", memberName4)
                .replace("{{b1randomNumber}}", memberNumber4)
                .replace("{{b1deviceID}}", deviceID4);

// Send the REST Assured request
        Response response4 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody4)
                .post("/register"); // Endpoint
        id4 = response4.path("id");
        System.out.println("id " + id4);
// Process the response as needed
        System.out.println("Response: " + response4.body().asString());


//LOGIN----FOR-----BRANCH-----------B1-----------------------------------------------------------------------------------------------------------------

        String loginPath1 = ".\\src/test/java/dataFiles687/loginB1.json"; // Update the path
        String loginContent1 = readString(Paths.get(loginPath1));
        String requestBodyloginB1 = loginContent1
                .replace("{{b1randomNumber}}", memberNumber4)
                .replace("{{b1deviceID}}", deviceID4);

        Response responseloginB1 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginB1)
                .post("/login"); // Endpoint
        token1 = responseloginB1.jsonPath().getString("token");
        System.out.println("Response: " + responseloginB1.body().asString());

//CREATE BRANCH------------------------------------------------------------------------------------------------
        String branchnameB1 = getRandomBranch1Name();
        branches.add(branchnameB1);
        System.out.println("branch name is " + branchnameB1);
        String branchPath = ".\\src/test/java/dataFiles687/createB1.json"; // Update the path
        String branchContent = readString(Paths.get(branchPath));
        String requestBodybranchB1 = branchContent
                .replace("{{b1randomBranchName}}", branchnameB1)
                .replace("{{b1id}}", id4)
                .replace("{{b1randomNumber}}", memberNumber4);
        Response responsebranchB1 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1) // Set the Authorization header
                .body(requestBodybranchB1)
                .post("/cp"); // Endpoint
        System.out.println("Response: " + responsebranchB1.body().asString());
        String branchidB1 = responsebranchB1.path("id");
        branchIds.add(branchidB1);
        System.out.println("branchid " + branchidB1);
//ADD MATERIALS----BRANCH------------------------------------------------------------------------------------------------

        String itemB1PCG = ".\\src/test/java/dataFiles687/itemB1.json"; // Update the path
        String itemContentPCG = readString(Paths.get(itemB1PCG));
        String requestBodyItemB1 = itemContentPCG
                .replace("{{b1branchid}}", branchidB1);
        Response responseItem1 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1) // Set the Authorization header
                .body(requestBodyItemB1)
                .post("/cp/" + branchidB1 + "/item"); // Endpoint
        branchPCGidB1 = responseItem1.path("id");
        branchPCG.add(branchPCGidB1);
        System.out.println("Response: " + responseItem1.body().asString());


        //Create member for Branch 2....    M5 ---> B2

        // Generate random username starting with "Fleek" M2
        String memberName5 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName5);
        System.out.println("member name is " + memberName5);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber5 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber5);
        numbers.add(memberNumber5);
// Generate unique device ID
        String deviceID5 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath5 = ".\\src/test/java/dataFiles687/m5.json"; // Update the path
        String templateContent5 = Files.readString(Paths.get(templatePath5));

// Replace placeholders with actual values
        String requestBody5 = templateContent5
                .replace("{{b2randomUsername}}", memberName5)
                .replace("{{b2randomNumber}}", memberNumber5)
                .replace("{{b2deviceID}}", deviceID5);

// Send the REST Assured request
        Response response5 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody5)
                .post("/register"); // Endpoint
        id5 = response5.path("id");
        System.out.println("id " + id5);
// Process the response as needed
        System.out.println("Response: " + response5.body().asString());
        //LOGIN----FOR-----BRANCH------B2----------------------------------------------------------------------------------------------------------------------

        String loginPath2 = ".\\src/test/java/dataFiles687/loginB2.json"; // Update the path
        String loginContent2 = readString(Paths.get(loginPath2));
        String requestBodyloginB2 = loginContent2
                .replace("{{b2randomNumber}}", memberNumber5)
                .replace("{{b2deviceID}}", deviceID5);

        Response responseloginB2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginB2)
                .post("/login"); // Endpoint
        token2 = responseloginB2.jsonPath().getString("token");
        System.out.println("Response: " + responseloginB2.body().asString());

        //CREATE BRANCH------------------------------------------------------------------------------------------------

//CREATE BRANCH---------------------------b2---------------------------------------------------------------------
        String branchnameB2 = getRandomBranch2Name();
        branches.add(branchnameB2);
        System.out.println("branch name is " + branchnameB2);
        String branchPath2 = ".\\src/test/java/dataFiles687/createB2.json"; // Update the path
        String branchContent2 = readString(Paths.get(branchPath2));
        String requestBodybranchB2 = branchContent2
                .replace("{{b2randomBranchName}}", branchnameB2)
                .replace("{{b2id}}", id5)
                .replace("{{b2randomNumber}}", memberNumber5);
        Response responsebranchB2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token2) // Set the Authorization header
                .body(requestBodybranchB2)
                .post("/cp"); // Endpoint
        System.out.println("Response: " + responsebranchB2.body().asString());
        String branchidB2 = responsebranchB2.path("id");
        branchIds.add(branchidB2);
        System.out.println("branchid " + branchidB2);
//ADD MATERIALS----BRANCH------------------b2------------------------------------------------------------------------------

        String itemB2PCG = ".\\src/test/java/dataFiles687/itemB2.json"; // Update the path
        String itemContentB2 = readString(Paths.get(itemB2PCG));
        String requestBodyItemB2 = itemContentB2
                .replace("{{b2branchid}}", branchidB2);
        Response responseItem2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token2) // Set the Authorization header
                .body(requestBodyItemB2)
                .post("/cp/" + branchidB2 + "/item"); // Endpoint
        String branchPCGidB2 = responseItem2.path("id");
        branchPCG.add(branchPCGidB2);
        System.out.println("Response: " + responseItem2.body().asString());


////////////////////////////////////////Create member for Branch 3....    M6 ---> B3

        // Generate random username starting with "Fleek" M2
        String memberName6 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName6);
        System.out.println("member name is " + memberName6);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber6 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber6);
        numbers.add(memberNumber6);
// Generate unique device ID
        String deviceID6 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath6 = ".\\src/test/java/dataFiles687/m6.json"; // Update the path
        String templateContent6 = Files.readString(Paths.get(templatePath6));

// Replace placeholders with actual values
        String requestBody6 = templateContent6
                .replace("{{b3randomUsername}}", memberName6)
                .replace("{{b3randomNumber}}", memberNumber6)
                .replace("{{b3deviceID}}", deviceID6);

// Send the REST Assured request
        Response response6 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody6)
                .post("/register"); // Endpoint
        id6 = response6.path("id");
        System.out.println("id " + id6);
// Process the response as needed
        System.out.println("Response: " + response6.body().asString());


        ////////////LOGIN----FOR-----BRANCH-----3-----------------------------------------------------------------------------------------------------------------------

        String loginPath3 = ".\\src/test/java/dataFiles687/loginB3.json"; // Update the path
        String loginContent3 = readString(Paths.get(loginPath3));
        String requestBodyloginB3 = loginContent3
                .replace("{{randomNumber}}", memberNumber6)
                .replace("{{deviceID}}", deviceID6);

        Response responseloginB3 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginB3)
                .post("/login"); // Endpoint
        token3 = responseloginB3.jsonPath().getString("token");
        System.out.println("Response: " + responseloginB3.body().asString());

        //CREATE BRANCH------------------------------------------------------------------------------------------------
        String branchnameB3 = getRandomBranch3Name();
        branches.add(branchnameB3);
        System.out.println("branch name is " + branchnameB3);
        String branchPathB3 = ".\\src/test/java/dataFiles687/createB3.json"; // Update the path
        String branchContentB3 = readString(Paths.get(branchPathB3));
        String requestBodybranchB3 = branchContentB3
                .replace("{{b3randomBranchName}}", branchnameB3)
                .replace("{{b3id}}", id6)
                .replace("{{b3randomNumber}}", memberNumber6);
        Response responsebranchB3 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token3) // Set the Authorization header
                .body(requestBodybranchB3)
                .post("/cp"); // Endpoint
        System.out.println("Response: " + responsebranchB3.body().asString());
        String branchidB3 = responsebranchB3.path("id");
        branchIds.add(branchidB3);
        System.out.println("branchid " + branchidB3);

        //ADD MATERIALS----BRANCH------------------------------------------------------------------------------------------------

        String itemB3PCG = ".\\src/test/java/dataFiles687/itemB3PCG.json"; // Update the path
        String itemB3PCGContent = readString(Paths.get(itemB3PCG));
        String requestBodyPCG = itemB3PCGContent
                .replace("{{b3branchid}}", branchidB3);
        Response responsePCG = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token3) // Set the Authorization header
                .body(requestBodyPCG)
                .post("/cp/" + branchidB3 + "/item"); // Endpoint
        String b3item1id = responsePCG.path("id");
        branchPCG.add(b3item1id);
        System.out.println("Response: " + responsePCG.body().asString());

        String itemB3PCW = ".\\src/test/java/dataFiles687/itemB3PCW.json"; // Update the path
        String itemB3PCWContent = readString(Paths.get(itemB3PCW));
        String requestBodyPCW = itemB3PCWContent
                .replace("{{b3branchid}}", branchidB3);
        Response responsePCW = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token3) // Set the Authorization header
                .body(requestBodyPCW)
                .post("/cp/" + branchidB3 + "/item"); // Endpoint
        String b3item2id = responsePCW.path("id");
        branchPCW.add(b3item2id);
        System.out.println("Response: " + responsePCW.body().asString());

        String itemB3LRW = ".\\src/test/java/dataFiles687/itemB3LRW.json"; // Update the path
        String itemB3LRWContent = readString(Paths.get(itemB3LRW));
        String requestBodyLRW = itemB3LRWContent
                .replace("{{b3branchid}}", branchidB3);
        Response responseLRW = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token3) // Set the Authorization header
                .body(requestBodyLRW)
                .post("/cp/" + branchidB3 + "/item"); // Endpoint
        String b3item3id = responseLRW.path("id");
        branchLRW.add(b3item3id);
        System.out.println("Response: " + responseLRW.body().asString());


/////////////////////////////////////////Create member for Branch 4...    M7 ---> B4///////////////////////////////////////////////////////////////

        // Generate random username starting with "Fleek" M2
        String memberName7 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName7);
        System.out.println("member name is " + memberName7);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber7 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber7);
        numbers.add(memberNumber7);
// Generate unique device ID
        String deviceID7 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath7 = ".\\src/test/java/dataFiles687/m7.json"; // Update the path
        String templateContent7 = Files.readString(Paths.get(templatePath7));

// Replace placeholders with actual values
        String requestBody7 = templateContent7
                .replace("{{b4randomUsername}}", memberName7)
                .replace("{{b4randomNumber}}", memberNumber7)
                .replace("{{b4deviceID}}", deviceID7);

// Send the REST Assured request
        Response response7 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody7)
                .post("/register"); // Endpoint
        id7 = response7.path("id");
        System.out.println("id " + id7);
// Process the response as needed
        System.out.println("Response: " + response7.body().asString());

        //LOGIN----FOR-----BRANCH-----B4-----------------------------------------------------------------------------------------------------------------------


        String loginPath4 = ".\\src/test/java/dataFiles687/loginB4.json"; // Update the path
        String loginContent4 = readString(Paths.get(loginPath4));
        String requestBodyloginB4 = loginContent4
                .replace("{{randomNumber}}", memberNumber7)
                .replace("{{deviceID}}", deviceID7);

        Response responseloginB4 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginB4)
                .post("/login"); // Endpoint
        token7 = responseloginB4.jsonPath().getString("token");
        System.out.println("Response: " + responseloginB4.body().asString());

        //CREATE BRANCH------------------------------------------------------------------------------------------------
        String branchnameB4 = getRandomBranch4Name();
        branches.add(branchnameB4);
        System.out.println("branch name is " + branchnameB4);
        String branchPathB4 = ".\\src/test/java/dataFiles687/createB4.json"; // Update the path
        String branchContentB4 = readString(Paths.get(branchPathB4));
        String requestBodybranchB4 = branchContentB4
                .replace("{{b4randomBranchName}}", branchnameB4)
                .replace("{{b4id}}", id7)
                .replace("{{b4randomNumber}}", memberNumber7);
        Response responsebranchB4 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token7) // Set the Authorization header
                .body(requestBodybranchB4)
                .post("/cp"); // Endpoint
        System.out.println("Response: " + responsebranchB4.body().asString());
        String branchidB4 = responsebranchB4.path("id");
        branchIds.add(branchidB4);
        System.out.println("branchid " + branchidB4);

        //ADD MATERIALS----BRANCH------------------------------------------------------------------------------------------------

        String itemB4PCG = ".\\src/test/java/dataFiles687/itemB4PCG.json"; // Update the path
        String itemB4PCGContent = readString(Paths.get(itemB4PCG));
        String requestBodyPCG2 = itemB4PCGContent
                .replace("{{b4branchid}}", branchidB4);
        Response responsePCG2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token7) // Set the Authorization header
                .body(requestBodyPCG2)
                .post("/cp/" + branchidB4 + "/item"); // Endpoint
        String b4item1id = responsePCG2.path("id");
        branchPCG.add(b4item1id);
        System.out.println("Response: " + responsePCG2.body().asString());

        String itemB4PCW = ".\\src/test/java/dataFiles687/itemB4PCW.json"; // Update the path
        String itemB4PCWContent = readString(Paths.get(itemB4PCW));
        String requestBodyPCW2 = itemB4PCWContent
                .replace("{{b4branchid}}", branchidB4);
        Response responsePCW2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token7) // Set the Authorization header
                .body(requestBodyPCW2)
                .post("/cp/" + branchidB4 + "/item"); // Endpoint
        String b4item2id = responsePCW2.path("id");
        branchPCW.add(b4item2id);
        System.out.println("Response: " + responsePCW2.body().asString());

        String itemB4LRW = ".\\src/test/java/dataFiles687/itemB4LRW.json"; // Update the path
        String itemB4LRWContent = readString(Paths.get(itemB4LRW));
        String requestBodyLRW2 = itemB4LRWContent
                .replace("{{b4branchid}}", branchidB4);
        Response responseLRW2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token7) // Set the Authorization header
                .body(requestBodyLRW2)
                .post("/cp/" + branchidB4 + "/item"); // Endpoint
        String b4item3id = responseLRW2.path("id");
        branchLRW.add(b4item3id);
        System.out.println("Response: " + responseLRW2.body().asString());

/////////////////////////////////////////////Create member for Branch 5....    M8 ---> B5/////////////////////////////////////////////////

        // Generate random username starting with "Fleek" M8
        String memberName8 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName8);
        System.out.println("member name is " + memberName8);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber8 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber8);
        numbers.add(memberNumber8);
// Generate unique device ID
        String deviceID8 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath8 = ".\\src/test/java/dataFiles687/m8.json"; // Update the path
        String templateContent8 = Files.readString(Paths.get(templatePath8));

// Replace placeholders with actual values
        String requestBody8 = templateContent8
                .replace("{{b5randomUsername}}", memberName8)
                .replace("{{b5randomNumber}}", memberNumber8)
                .replace("{{b5deviceID}}", deviceID8);

// Send the REST Assured request
        Response response8 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody8)
                .post("/register"); // Endpoint
        id8 = response8.path("id");
        System.out.println("id " + id8);
// Process the response as needed
        System.out.println("Response: " + response8.body().asString());
        //LOGIN----FOR-----BRANCH-----B5------------------------------------------------
        String loginPath5 = ".\\src/test/java/dataFiles687/loginB5.json"; // Update the path
        String loginContent5 = readString(Paths.get(loginPath5));
        String requestBodyloginB5 = loginContent5
                .replace("{{b5randomNumber}}", memberNumber8)
                .replace("{{b5deviceID}}", deviceID8);

        Response responseloginB5 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginB5)
                .post("/login"); // Endpoint
        token8 = responseloginB5.jsonPath().getString("token");
        System.out.println("Response: " + responseloginB5.body().asString());

        //CREATE BRANCH------------------------------------------------------------------------------------------------

//CREATE BRANCH------------------------------------------------------------------------------------------------
        String branchnameB5 = getRandomBranch5Name();
        branches.add(branchnameB5);
        System.out.println("branch name is " + branchnameB5);
        String branchPath5 = ".\\src/test/java/dataFiles687/createB5.json"; // Update the path
        String branchContent5 = readString(Paths.get(branchPath5));
        String requestBodybranchB5 = branchContent5
                .replace("{{b5randomBranchName}}", branchnameB5)
                .replace("{{b5id}}", id8)
                .replace("{{b5randomNumber}}", memberNumber8);
        Response responsebranchB5 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token8) // Set the Authorization header
                .body(requestBodybranchB5)
                .post("/cp"); // Endpoint
        System.out.println("Response: " + responsebranchB5.body().asString());
        String branchidB5 = responsebranchB5.path("id");
        branchIds.add(branchidB5);
        System.out.println("branchid " + branchidB5);
//ADD MATERIALS----BRANCH------------------------------------------------------------------------------------------------

        String itemB5PCCB = ".\\src/test/java/dataFiles687/itemB5.json"; // Update the path
        String itemContentB5 = readString(Paths.get(itemB5PCCB));
        String requestBodyItemB22 = itemContentB5
                .replace("{{b5branchid}}", branchidB5);
        Response responseItem22 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token8) // Set the Authorization header
                .body(requestBodyItemB22)
                .post("/cp/" + branchidB5 + "/item"); // Endpoint
        String branchPCCBidB5 = responseItem22.path("id");
        branchPC_CB.add(branchPCCBidB5);
        System.out.println("Response: " + responseItem22.body().asString());


/////////////////////Create member for Processor....   M9 ---> P1  //////////////////////////////////////////////////////////////

        // Generate random username starting with "Fleek" M2
        String memberName9 = "Fleek" + getRandomStringWithChars(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        members.add(memberName9);
        System.out.println("member name is " + memberName9);
// Generate random phone number starting with "+63" and numbers only
        String memberNumber9 = "+63" + getRandomStringWithChars(10, "0123456789");
        System.out.println("member number is " + memberNumber9);
        numbers.add(memberNumber9);
// Generate unique device ID
        String deviceID9 = generateUniqueDeviceID();

// Read the JSON template file
        String templatePath9 = ".\\src/test/java/dataFiles687/m9.json"; // Update the path
        String templateContent9 = Files.readString(Paths.get(templatePath9));

// Replace placeholders with actual values
        String requestBody9 = templateContent9
                .replace("{{p1randomUsername}}", memberName9)
                .replace("{{p1randomNumber}}", memberNumber9)
                .replace("{{p1deviceID}}", deviceID9);

// Send the REST Assured request
        Response response9 = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody9)
                .post("/register"); // Endpoint
        id9 = response9.path("id");
        System.out.println("id " + id9);
// Process the response as needed
        System.out.println("Response: " + response9.body().asString());
//LOGIN FOR PROCESSOR-----------------------------------------------------------------------------------------------
        String loginPathP = ".\\src/test/java/dataFiles687/loginP1.json"; // Update the path
        String loginContentP = readString(Paths.get(loginPathP));
        String requestBodyloginP = loginContentP
                .replace("{{p1randomNumber}}", memberNumber9)
                .replace("{{p1deviceID}}", deviceID9);

        Response responseloginP = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBodyloginP)
                .post("/login"); // Endpoint
        tokenP = responseloginP.jsonPath().getString("token");


        System.out.println("Response: " + responseloginP.body().asString());

//CREATE PROCESSOR-----------------------------------------------------------------------------------------------
        String processorname = getRandomProcessorName();
        processors.add(processorname);
        System.out.println("processor name is " + processorname);
        String processorPath = ".\\src/test/java/dataFiles687/createP1.json"; // Update the path
        String processorContent = readString(Paths.get(processorPath));
        String requestBodyprocessor = processorContent
                .replace("{{p1randomProcessorName}}", processorname)
                .replace("{{p1userId}}", id9)
                .replace("{{p1randomNumber}}", memberNumber9);
        Response responseprocessor = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenP) // Set the Authorization header
                .body(requestBodyprocessor)
                .post("/rc"); // Endpoint
        System.out.println("Response: " + responseprocessor.body().asString());
        String processorid = responseprocessor.path("id");
        processorIds.add(processorid);
        System.out.println("processorid " + processorid);

//ADD MATERIALS---PROCESSOR-------------------------------------------------------------------------------------------------
        ///////////////////////////////////PET CLEAN GREEN//////////////////////////////////////////////////////
        String pcgPathP = ".\\src/test/java/dataFiles687/itemP1PCG.json"; // Update the path
        String pcgContentP = readString(Paths.get(pcgPathP));
        String requestBodyPCG_P = pcgContentP
                .replace("{{id}}", processorid);
        Response responsePCG_P = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenP) // Set the Authorization header
                .body(requestBodyPCG_P)
                .post("/rc/" + processorid + "/item"); // Endpoint
        String pitemPCGid = responsePCG_P.path("id");
        processorPCG.add(pitemPCGid);
        System.out.println("Response: " + responsePCG_P.body().asString());

        ////////////////////////////////PET CLEAN White///////////////////////////////////////////////////////

        String pcwPathP = ".\\src/test/java/dataFiles687/itemP1PCW.json"; // Update the path
        String pcwContentP = readString(Paths.get(pcwPathP));
        String requestBodyPCW_P = pcwContentP
                .replace("{{id}}", processorid);
        Response responsePCW_P = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenP) // Set the Authorization header
                .body(requestBodyPCW_P)
                .post("/rc/" + processorid + "/item"); // Endpoint
        String pitemPCWid = responsePCG_P.path("id");
        processorPCW.add(pitemPCWid);
        System.out.println("Response: " + responsePCW_P.body().asString());

        String lrwPathP = ".\\src/test/java/dataFiles687/itemP1LRW.json"; // Update the path
        String lrwContentP = readString(Paths.get(lrwPathP));
        String requestBodyLRW_P = lrwContentP
                .replace("{{id}}", processorid);
        Response responseLRW_P = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenP) // Set the Authorization header
                .body(requestBodyLRW_P)
                .post("/rc/" + processorid + "/item"); // Endpoint
        String pitemLRWid = responseLRW_P.path("id");
        processorLRW.add(pitemLRWid);
        System.out.println("Response: " + responseLRW_P.body().asString());

        String PC_CBPathP = ".\\src/test/java/dataFiles687/itemP1PC_CB.json"; // Update the path
        String PC_CBContentP = readString(Paths.get(PC_CBPathP));
        String requestBodyPCCB_P = PC_CBContentP
                .replace("{{id}}", processorid);
        Response responsePCCB_P = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenP) // Set the Authorization header
                .body(requestBodyPCCB_P)
                .post("/rc/" + processorid + "/item"); // Endpoint
        String pitemPCCBid = responsePCCB_P.path("id");
        processorPC_CB.add(pitemPCCBid);
        System.out.println("Response: " + responsePCG_P.body().asString());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Alchemy/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JSONObject data = new JSONObject();
        data.put("phoneNumber", "+919560071590");
        data.put("pin", "123456a");
        data.put("app", "ADMIN");
        Response responsealchemylogin = RestAssured.given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("/pl/admin/login");

        String sessioncode = responsealchemylogin.path("sessionCode");

        JSONObject data1 = new JSONObject();
        data1.put("smsCode", "778899");
        data1.put("sessionCode", sessioncode);
        Response responsealchemy2fal = RestAssured.given()
                .contentType("application/json")
                .body(data1.toString())
                .when()
                .post("/admin/two_factor_auth_login");
        String alchemytoken = responsealchemy2fal.path("token");
        System.out.println("Alchemy Token_____" + alchemytoken);

        for (int i = 0; i < 2; i++) {
            JSONObject data2 = new JSONObject();
            data2.put("offsetEligible", true);
            given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + alchemytoken)
                    .body(data2.toString())
                    .post("/admin/cp/" + branchIds.get(i) + "/item/" + branchPCG.get(i));


        }

        String editbranch = ".\\src/test/java/dataFiles687/editB1.json"; // Update the path
        String editBranch1 = Files.readString(Paths.get(editbranch));
        String requestEditBranch = editBranch1
                .replace("{{b1randomBranchName}}", branches.get(0))
                .replace("{{b1randomNumber}}", numbers.get(3));
        Response responseEditBranch = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken) // Set the Authorization header
                .body(requestEditBranch)
                .post("/admin/cp/" + branchIds.get(0)); // Endpoint

        System.out.println("Response for branch1 edit: " + responseEditBranch.body().asString());


        String editbranch2 = ".\\src/test/java/dataFiles687/editB2.json"; // Update the path
        String editBranch22 = Files.readString(Paths.get(editbranch2));
        String requestEditBranch2 = editBranch22
                .replace("{{b2randomBranchName}}", branches.get(1))
                .replace("{{b2randomNumber}}", numbers.get(4));
        Response responseEditBranch2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken) // Set the Authorization header
                .body(requestEditBranch2)
                .post("/admin/cp/" + branchIds.get(1)); // Endpoint

        System.out.println("Response for branch2 edit: " + responseEditBranch2.body().asString());


        String editprocessor = ".\\src/test/java/dataFiles687/editProcessor.json"; // Update the path
        String editProcessor = Files.readString(Paths.get(editprocessor));
        String requestEditProcessor = editProcessor
                .replace("{{p1randomProcessorName}}", processors.get(0))
                .replace("{{p1randomNumber}}", numbers.get(8));
        Response responseEditProcessor = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken) // Set the Authorization header
                .body(requestEditProcessor)
                .post("/admin/rc/" + processorIds.get(0)); // Endpoint

        System.out.println("Response for processor edit: " + responseEditProcessor.body().asString());

        JSONObject data5 = new JSONObject();
        data5.put("type", "CREATE_OFFSET");
        Response twofafb = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken)
                .body(data5.toString())
                .post("/admin/init_two_factor_auth");

        String bonusordersessionCode = twofafb.path("sessionCode");

        System.out.println("Bsession code  --" + bonusordersessionCode);
        System.out.println("Response for two fac auth for bonus order: " + twofafb.body().asString());


        //String randomText = generateRandomString(6);
        bonusOrderName = "Fleek" + generateRandomString(6);
        String bonus = ".\\src/test/java/dataFiles687/bonusordercreation.json"; // Update the path
        String bonuscreate = Files.readString(Paths.get(bonus));
        String bonusCreationbody = bonuscreate
                .replace("{{bonusOrderName}}", bonusOrderName)
                .replace("{{formattedDateTime}}", formattedDateTime)
                .replace("{{b1branchid}}", branchIds.get(0))
                .replace("{{b2branchid}}", branchIds.get(1))
                .replace("{{bonusordersessionCode}}", bonusordersessionCode);
        System.out.println("Bonus Creation Body" + bonusCreationbody);
        Response responseBonusOrderCreation = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken) // Set the Authorization header
                .body(bonusCreationbody)
                .post("/pl/admin/offset"); // Endpoint
        String bonusorderid = responseBonusOrderCreation.path("id");
        System.out.println("Response for bonus order creation: " + responseBonusOrderCreation.body().asString());


        JSONObject data6 = new JSONObject();
        data6.put("type", "UPDATE_OFFSET");
        Response twofafboe = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken)
                .body(data6.toString())
                .post("/admin/init_two_factor_auth");
        String addprosessionCode = twofafboe.path("sessionCode");
        System.out.println("Response for two factor auth for bonus order edit : " + twofafboe.body().asString());

        String last = "src/test/java/dataFiles687/addprocessorinbonusorder.json";
        String lAst = Files.readString(Paths.get(last));

        String lastbody = lAst
                .replace("{{addprosessionCode}}", addprosessionCode)
                .replace("{{p1processorid}}", processorIds.get(0));
        Response responselast = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + alchemytoken) // Set the Authorization header
                .body(lastbody)
                .post("/pl/admin/offset/" + bonusorderid + "/addParticipants");
        System.out.println("Response for last request: " + responselast.body().asString());


        System.out.println("----------------------------------------------------------------------------------------");
        for (String number : numbers) {
            System.out.println(number);
        }
        for (String branch : branches) {
            System.out.println(branch);
        }
        for (String pro : processors) {
            System.out.println(pro);
        }

        System.out.println("bonus order name-----" + bonusOrderName);


////////////////////////////////////////////Transactions////////////////////////////////////////////////////////////////////////////////////////////////////////

        String tM1B1_1 = ".\\src/test/java/dataFiles687/transaction_M1_B1_1.json"; // Update the path
        String tM1B1_1_Read = Files.readString(Paths.get(tM1B1_1));
        String tM1B1_1_Body = tM1B1_1_Read
                .replace("{{b1id}}", id4)
                .replace("{{b1branchid}}", branchIds.get(0))
                .replace("{{m1id}}", id1)
                .replace("{{b1item1Id}}", branchPCGidB1);


        Response tM1B1_1_Response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1) // Set the Authorization header
                .body(tM1B1_1_Body)
                .post("/pl/transaction"); // Endpoint
        String t1id = tM1B1_1_Response.path("id");
        System.out.println("Response for tM1B1_1 : " + tM1B1_1_Response.body().asString());


    }
}
