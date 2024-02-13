package Utilities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data extends BaseClass {

	//ALC-4357*
	public static String bonusName;
	public static String password = "123456a";

	public static String member_Name;
	public static String member_Number;

	public static String branch1_Name;
	public static String branch1_Number;

	public static String branch2_Name;
	public static String branch2_Number;

	public static String branch3_Name;
	public static String branch3_Number;

	public static String processor_Name;
	public static String processor_Number;

	/////////////////

	public static String member1_Name1134;
	public static String member1_Number1134;
	public static String branch1_Name1134;
	public static String branch1_Number1134;
	public static String branch2_Name1134;
	public static String branch2_Number1134;
	public static String processor1_Number1134;
	public static String processor1_Name1134;
	public static String p1id1134;
	public static String processor2_Number1134;
	public static String processor2_Name1134;
	public static String p2id1134;
	public static String bonus1Name1134;
	public static String bonus1Id1134;
	public static String bonus2Name1134;
	public static String bonus2Id1134;
	public static String branch1Id_1134;
	public static String branch2Id_1134;

	//*ALC-4357/

	public static ArrayList<String> values = new ArrayList<String>();
	public static ArrayList<String> values1 = new ArrayList<String>();
	public static ArrayList<String> values_ALC_4361 = new ArrayList<String>();
	public static ArrayList<String> values380 = new ArrayList<String>();
	public static ArrayList<String> values1711 = new ArrayList<String>();
	public static ArrayList<String> values4360 = new ArrayList<String>();
	public static ArrayList<String> values4352 = new ArrayList<String>();
	public static ArrayList<String> valuesMB = new ArrayList<String>();
	public static ArrayList<String> values4359 = new ArrayList<String>();
	public static ArrayList<String> values_ALC_4360 = new ArrayList<String>();
	public static ArrayList<String> values666 = new ArrayList<String>();
	public static ArrayList<String> values687 = new ArrayList<String>();
	public static ArrayList<String> values1134_1 = new ArrayList<String>();
	public static ArrayList<String> values1134_2 = new ArrayList<String>();
	public static ArrayList<String> values687_2 = new ArrayList<String>();




	public static String member_Name1711;
	public static String member_Number1711;
	public static String branch1_Name1711;
	public static String branch1_Number1711;
	public static String branch2_Name1711;
	public static String branch2_Number1711;
	public static String processor_Name1711;
	public static String processor_Number1711;
	public static String bonusName1711;
	public static String member_Id1711;
	public static String branch1_Id1711;
	public static String branch2_Id1711;
	public static String processor_Id1711;
	public static String bonusOrderId1711;

	public static String member_Name_4352;
	public static String member_Number_4352;

	public static String member_NameMB;
	public static String member_NumberMB;
	public static String branch1_NameMB;
	public static String branch1_NumberMB;

	public static String member_Name4359;
	public static String member_Number4359;
	public static String branch1_Name4359;
	public static String branch1_Number4359;
	public static String processor_Name4359;
	public static String processor_Number4359;
	public static String bonusName4359;

	public static String member1_Number380;
	public static String member2_Number380;
	public static String member1_Name380;
	public static String member2_Name380;

	public static String mname4360;
	public static String mnum4360;
	public static String b1number4360;
	public static String b1name4360;
	public static String b1id4360;
	public static String b2number4360;
	public static String b2name4360;
	public static String b2id4360;
	public static String pnumber4360;
	public static String pname4360;
	public static String pid4360;
	public static String bonusname4360;
	public static String bonusid4360;
	public int count = 0;

	public static String member1_Name666;
	public static String member1_Number666;
	public static String member2_Name666;
	public static String member2_Number666;
	public static String member3_Name666;
	public static String member3_Number666;
	public static String member4_Name666;
	public static String member4_Number666;

	public static String branch1_Name666;
	public static String branch1_Number666;
	public static String branch2_Name666;
	public static String branch2_Number666;
	public static String processor_Name666;
	public static String processor_Number666;
	public static String bonusName666;
	public static String b2id666;

	//
	public static String member1_Name687;
	public static String member1_Number687;
	public static String member2_Name687;
	public static String member2_Number687;
	public static String member3_Name687;
	public static String member3_Number687;
	public static String member4_Name687;
	public static String member4_Number687;

	public static String branch1_Name687;
	public static String branch1_Number687;
	public static String branch2_Name687;
	public static String branch2_Number687;
	public static String branch3_Name687;
	public static String branch3_Number687;
	public static String branch4_Name687;
	public static String branch4_Number687;
	public static String branch5_Name687;
	public static String branch5_Number687;

	public static String m2id687;
	public static String m3id687;
	public static String b1id687;
	public static String b2id687;
	public static String b3id687;
	public static String b4id687;
	public static String b5id687;


	public static String processor_Name687;
	public static String processor_Number687;
	public static String p1id687;
	public static String bonusName687;
	public static String bonusOrderId687;

	public static String bonusId1134_2;
	public static String bonusName1134_2;
	public static String processor_Name1134_2;

	public static String processor_Name687_2;
	public static String bonusName687_2;


	public void runNewman() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_4357QA.postman_collection.json --export-environment variable.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);

			if (count == 0) {
				runNewman();
			}
			count = 0;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "b3randomBranchName".equals(key) || "b3randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key)) {
						System.out.println(key + ": " + value);
						values.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name = values.get(0);
		member_Number = values.get(1);
		branch1_Name = values.get(3);
		branch1_Number = values.get(2);
		branch2_Name = values.get(5);
		branch2_Number = values.get(4);
		branch3_Name = values.get(7);
		branch3_Number = values.get(6);
		processor_Name = values.get(9);
		processor_Number = values.get(8);
		bonusName = values.get(10);


	}

	public void data_ALC_4356() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run PlasticBank4357.postman_collection.json --export-environment variable.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);

			if (count == 0) {
				runNewman();
			}
			count = 0;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "b3randomBranchName".equals(key) || "b3randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key)) {
						System.out.println(key + ": " + value);
						values.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name = values.get(0);
		member_Number = values.get(1);
		branch1_Name = values.get(3);
		branch1_Number = values.get(2);
		branch2_Name = values.get(5);
		branch2_Number = values.get(4);
		branch3_Name = values.get(7);
		branch3_Number = values.get(6);
		processor_Name = values.get(9);
		processor_Number = values.get(8);
		bonusName = values.get(10);


	}

	public void runNewmanALC_4362_4363() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run Alc_4362_63.postman_collection.json --export-environment variable_ALC_4362_4363.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				runNewmanALC_4362_4363();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_ALC_4362_4363.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "b3randomBranchName".equals(key) || "b3randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key)) {
						System.out.println(key + ": " + value);
						values1.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name = values1.get(0);
		member_Number = values1.get(1);
		branch1_Name = values1.get(3);
		branch1_Number = values1.get(2);
		branch2_Name = values1.get(5);
		branch2_Number = values1.get(4);
		branch3_Name = values1.get(7);
		branch3_Number = values1.get(6);
		processor_Name = values1.get(9);
		processor_Number = values1.get(8);
		bonusName = values1.get(10);


	}

	public void runNewmanFor_ALC_4361() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_4361.postman_collection.json --export-environment variable_ALC_4361.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				runNewmanFor_ALC_4361();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_ALC_4361.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key)) {
						System.out.println(key + ": " + value);
						values_ALC_4361.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void runNewman_ALC380() throws IOException {


		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run dtt.postman_collection.json --export-environment variable380.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				runNewman_ALC380();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable380.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "m2randomUsername".equals(key) || "m2randomNumber".equals(key)) {
						System.out.println(key + ": " + value);
						values380.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		member1_Name380 = values380.get(0);
		member1_Number380 = values380.get(1);
		member2_Name380 = values380.get(2);
		member2_Number380 = values380.get(3);


	}

	public void runNewman1711() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_1711.postman_collection.json --export-environment variable_1711.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				runNewman1711();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_1711.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key) || "m1id".equals(key) || "b1branchid".equals(key) || "b2branchid".equals(key) || "p1processorid".equals(key) || "bonusOrderId".equals(key)) {
						System.out.println(key + ": " + value);
						values1711.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name1711 = values1711.get(0);
		member_Number1711 = values1711.get(1);
		member_Id1711 = values1711.get(2);
		branch1_Number1711 = values1711.get(3);
		branch1_Name1711 = values1711.get(4);
		branch1_Id1711 = values1711.get(5);
		branch2_Number1711 = values1711.get(6);
		branch2_Name1711 = values1711.get(7);
		branch2_Id1711 = values1711.get(8);
		processor_Number1711 = values1711.get(9);
		processor_Name1711 = values1711.get(10);
		processor_Id1711 = values1711.get(11);
		bonusName1711 = values1711.get(12);
		bonusOrderId1711 = values1711.get(13);
	}

	public void runNewmanmb1b2pnobonuspaid() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run mb1b2p_without_bonus.postman_collection.json --export-environment variablenobonuspaid.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				runNewmanmb1b2pnobonuspaid();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variablenobonuspaid.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key) || "b1branchid".equals(key) || "b2branchid".equals(key) || "p1processorid".equals(key) || "bonusOrderId".equals(key)) {
						System.out.println(key + ": " + value);
						values_ALC_4360.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		mname4360 = values_ALC_4360.get(0);
		mnum4360 = values_ALC_4360.get(1);
		b1number4360 = values_ALC_4360.get(2);
		b1name4360 = values_ALC_4360.get(3);
		b1id4360 = values_ALC_4360.get(4);
		b2number4360 = values_ALC_4360.get(5);
		b2name4360 = values_ALC_4360.get(6);
		b2id4360 = values_ALC_4360.get(7);
		pnumber4360 = values_ALC_4360.get(8);
		pname4360 = values_ALC_4360.get(9);
		pid4360 = values_ALC_4360.get(10);
		bonusname4360 = values_ALC_4360.get(11);
		bonusid4360 = values_ALC_4360.get(12);
	}

	public void runonceFor_ALC_4360() throws IOException {

		runNewmanmb1b2pnobonuspaid();

	}

	public void createMember() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run create_Member.postman_collection.json --export-environment variable_4352.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				createMember();
			}
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_4352.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key)) {
						System.out.println(key + ": " + value);
						values4352.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name_4352 = values4352.get(0);
		member_Number_4352 = values4352.get(1);


	}

	public void createMemberBranch() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run create_Member_Branch.postman_collection.json --export-environment variableMB.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				} else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if (count == 0) {
				createMemberBranch();
			}
			count = 0;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variableMB.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key)) {
						System.out.println(key + ": " + value);
						valuesMB.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_NameMB = valuesMB.get(0);
		member_NumberMB = valuesMB.get(1);
		branch1_NumberMB = valuesMB.get(2);
		branch1_NameMB = valuesMB.get(3);

	}

	public void runNewman_1Branch() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run PlasticBankCopy1.postman_collection.json --export-environment variable4359.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// Check if the line contains the target string
//	            if (line.contains("assertions") && line.contains(" 0 ")) {
//	            	count = 1; // Set count to 1 as soon as the line is found
//	            	}
//	            else {
//
//	            }
//
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
//			if(count==0) {
//				runNewman_1Branch();
//	        }
			count = 0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable4359.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key)) {
						System.out.println(key + ": " + value);
						values4359.add(value);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		member_Name4359 = values4359.get(0);
		member_Number4359 = values4359.get(1);
		branch1_Name4359 = values4359.get(3);
		branch1_Number4359 = values4359.get(2);
		processor_Name4359 = values4359.get(5);
		processor_Number4359 = values4359.get(4);
		bonusName4359 = values4359.get(6);

	}
	public void runNewman_ALC666() throws IOException {



		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_666_DATA.postman_collection.json --export-environment variable_666.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				}
				else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if(count==0) {
				runNewman_ALC666();
			}
			count=0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_666.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "m2randomUsername".equals(key) || "m2randomNumber".equals(key) || "m3randomUsername".equals(key) || "m3randomNumber".equals(key)  || "m4randomUsername".equals(key) || "m4randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) ||"p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) ||"p1processorid".equals(key) || "bonusOrderName".equals(key) || "b2branchid".equals(key)) {
						System.out.println(key + ": " + value);
						values666.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		member1_Name666 = values666.get(0);
		member1_Number666=values666.get(1);
		member2_Name666 = values666.get(2);
		member2_Number666=values666.get(3);
		member3_Name666 = values666.get(4);
		member3_Number666=values666.get(5);
		member4_Name666 = values666.get(6);
		member4_Number666=values666.get(7);
		branch1_Name666=values666.get(9);
		branch1_Number666=values666.get(8);
		branch2_Name666=values666.get(11);
		branch2_Number666=values666.get(10);
		b2id666 = values666.get(12);
		processor_Name666=values666.get(14);
		processor_Number666=values666.get(13);
		bonusName666=values666.get(16);

	}


	public void runNewman_ALC_1134_1() throws IOException {



		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_1134_1.postman_collection.json --export-environment variable_1134_1.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				}
				else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if(count==0) {
				runNewman_ALC687_4();
			}
			count=0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_1134_1.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "b1branchid".equals(key) || "b2branchid".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) ||"p2randomProcessorName".equals(key) || "p2randomNumber".equals(key) || "bonusOrderName".equals(key) || "bonusOrderId".equals(key) || "bonusOrderName1".equals(key) || "bonusOrderId2".equals(key) ||"p1processorid".equals(key) ||"p2processorid".equals(key)) {
						System.out.println(key + ": " + value);
						values1134_1.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		member1_Name1134 = values1134_1.get(0);
		member1_Number1134=values1134_1.get(1);
		branch1_Name1134=values1134_1.get(3);
		branch1_Number1134=values1134_1.get(2);
		branch1Id_1134=values1134_1.get(4);
		branch2_Name1134=values1134_1.get(6);
		branch2_Number1134=values1134_1.get(5);
		branch2Id_1134=values1134_1.get(7);
		processor1_Number1134=values1134_1.get(8);
		processor1_Name1134=values1134_1.get(9);
		p1id1134=values1134_1.get(10);
		processor2_Number1134=values1134_1.get(11);
		processor2_Name1134=values1134_1.get(12);
		p2id1134=values1134_1.get(13);
		bonus1Name1134=values1134_1.get(14);
		bonus1Id1134=values1134_1.get(15);
		bonus2Name1134=values1134_1.get(16);
		bonus2Id1134=values1134_1.get(17);

	}

	public void runNewman_ALC_1134_2() throws IOException {



		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_1134_2_22.postman_collection.json --export-environment variable_1134_2.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				}
				else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if(count==0) {
				runNewman_ALC666();
			}
			count=0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_1134_2.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("p1randomProcessorName".equals(key)  || "bonusOrderName".equals(key) || "bonusOrderId".equals(key) ) {
						System.out.println(key + ": " + value);
						values1134_2.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}


		processor_Name1134_2=values1134_2.get(0);
		bonusName1134_2=values1134_2.get(1);
		bonusId1134_2=values1134_2.get(2);

	}

	public void runNewman_ALC687_4() throws IOException {



		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_687.postman_collection.json --export-environment variable_687_4.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				}
				else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if(count==0) {
				runNewman_ALC687_4();
			}
			count=0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_687_4.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) ||"m2randomUsername".equals(key) || "m2randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) ||"b3randomBranchName".equals(key) || "b3randomNumber".equals(key) ||"p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key) || "bonusOrderId".equals(key) || "b1branchid".equals(key) || "b2branchid".equals(key) || "b3branchid".equals(key) ||"p1processorid".equals(key)) {
						System.out.println(key + ": " + value);
						values687.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

		member1_Name687 = values687.get(0);
		member1_Number687=values687.get(1);
		branch1_Number687=values687.get(2);
		branch1_Name687=values687.get(3);
		b1id687 = values687.get(4);
		branch2_Number687=values687.get(5);
		branch2_Name687=values687.get(6);
		b2id687 = values687.get(7);
		processor_Number687=values687.get(8);
		processor_Name687=values687.get(9);
		p1id687=values687.get(10);
		bonusName687=values687.get(11);
		bonusOrderId687=values687.get(12);
		member2_Name687 = values687.get(13);
		member2_Number687=values687.get(14);
		branch3_Number687=values687.get(15);
		branch3_Name687=values687.get(16);
		b3id687 = values687.get(17);

	}
	public void runNewman_ALC687_2() throws IOException {


		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("cmd.exe");
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Send commands to the window
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("newman run ALC_687_22.postman_collection.json --export-environment variable_687_2.json\n");
			writer.flush();
			writer.close(); // Close the writer to signal the end of input

			// Read the output of the window
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Check if the line contains the target string
				if (line.contains("assertions") && line.contains(" 0 ")) {
					count = 1; // Set count to 1 as soon as the line is found
				}
				else {

				}

			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
			if(count==0) {
				runNewman_ALC687_2();
			}
			count=0;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		String jsonFilePath = ".\\variable_687_2.json"; // Replace with the actual path
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Read the JSON file
			JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			// Extract values of specific keys
			JsonNode valuesNode = rootNode.get("values");
			if (valuesNode != null && valuesNode.isArray()) {
				for (JsonNode valueEntry : valuesNode) {
					String key = valueEntry.get("key").asText();
					String value = valueEntry.get("value").asText();

					if ("p1randomProcessorName".equals(key) ||"bonusOrderName".equals(key)) {
						System.out.println(key + ": " + value);
						values687_2.add(value);

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}


		processor_Name687_2=values687_2.get(0);
		bonusName687_2=values687_2.get(1);


	}
	
}