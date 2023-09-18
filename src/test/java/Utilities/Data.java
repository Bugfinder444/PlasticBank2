package Utilities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data extends BaseClass{
	
	public ArrayList<String> values=new ArrayList<String>();
	public ArrayList<String> values1=new ArrayList<String>();
	public static ArrayList<String> values_ALC_4361=new ArrayList<String>();
	public static ArrayList<String> values380=new ArrayList<String>();
	public static ArrayList<String> values1711=new ArrayList<String>();
	public static ArrayList<String> values4360=new ArrayList<String>();
	public static ArrayList<String> values4352=new ArrayList<String>();
	public static ArrayList<String> valuesMB=new ArrayList<String>();
	public ArrayList<String> values4359=new ArrayList<String>();

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

	    
	  
	  
	public void runNewman() throws IOException {
	    try {
	        // Start the command prompt window
	        ProcessBuilder builder = new ProcessBuilder("cmd.exe");
	        builder.redirectErrorStream(true);
	        Process process = builder.start();
	        
	        // Send commands to the window
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
	        writer.write("newman run PlasticBankonlytillmemberbranchesandprocessors.postman_collection.json --export-environment variable.json\n");
	        writer.flush();
	        writer.close(); // Close the writer to signal the end of input
	        
	        // Read the output of the window
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
		  member_Number=values.get(1);
		  branch1_Name = values.get(3); 
		  branch1_Number =values.get(2);
		  branch2_Name = values.get(5);
		  branch2_Number =values.get(4); 
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
		  member_Number=values1.get(1);
		  branch1_Name = values1.get(3); 
		  branch1_Number =values1.get(2);
		  branch2_Name = values1.get(5);
		  branch2_Number =values1.get(4); 
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
          member1_Number380=values380.get(1);
          member2_Name380 = values380.get(2); 
          member2_Number380=values380.get(3);
          
          
	}
	public void runNewman1711() throws IOException {
	    try {
	        // Start the command prompt window
	        ProcessBuilder builder = new ProcessBuilder("cmd.exe");
	        builder.redirectErrorStream(true);
	        Process process = builder.start();
	        
	        // Send commands to the window
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
	        writer.write("newman run mb1b2p_with_paid_bonus.postman_collection.json --export-environment variablebonuspaid.json\n");
	        writer.flush();
	        writer.close(); // Close the writer to signal the end of input
	        
	        // Read the output of the window
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    String jsonFilePath = ".\\variablebonuspaid.json"; // Replace with the actual path
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
		  member_Number1711=values1711.get(1);
		  member_Id1711=values1711.get(2);
		  branch1_Number1711 =values1711.get(3);
		  branch1_Name1711 = values1711.get(4); 
		  branch1_Id1711 =values1711.get(5);
		  branch2_Number1711 =values1711.get(6);
		  branch2_Name1711 = values1711.get(7);
		  branch2_Id1711 =values1711.get(8);
		  processor_Number1711 = values1711.get(9);
		  processor_Name1711 = values1711.get(10);  
		  processor_Id1711 = values1711.get(11);
		  bonusName1711 = values1711.get(12);    
		  bonusOrderId1711 = values1711.get(13);
	}
	
	public void runNewman4360() throws IOException {
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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

                    if ("m1randomUsername".equals(key) || "m1randomNumber".equals(key) || "b1randomBranchName".equals(key) || "b1randomNumber".equals(key) || "b2randomBranchName".equals(key) || "b2randomNumber".equals(key) || "p1randomProcessorName".equals(key) || "p1randomNumber".equals(key) || "bonusOrderName".equals(key)) {
                        System.out.println(key + ": " + value);
                        values4360.add(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
		member_Number_4352=values4352.get(1);
		
	    
	    
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
	        }
	        
	        // Wait for the process to complete
	        int exitCode = process.waitFor();
	        System.out.println("Process completed with exit code: " + exitCode);
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
		  member_NumberMB=valuesMB.get(1);
		  branch1_NumberMB =valuesMB.get(2);
		  branch1_NameMB = valuesMB.get(3); 
		  
	}
	
	public void runNewman_1Branch() throws IOException {
		try {
			// Start the command prompt window
			ProcessBuilder builder = new ProcessBuilder("/bin/bash");
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
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process completed with exit code: " + exitCode);
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
		member_Number4359=values4359.get(1);
		branch1_Name4359 = values4359.get(3);
		branch1_Number4359 =values4359.get(2);
		processor_Name4359 = values4359.get(5);
		processor_Number4359 = values4359.get(4);
		bonusName4359 = values4359.get(6);

	}
	
}