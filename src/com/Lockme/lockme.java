package com.Lockme;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;


public class lockme {
	static String Directory;
	File folder_name;
	
	public lockme() {
		Directory = System.getProperty("user.dir");
		folder_name = new File(Directory + "/files");
		if(!folder_name.exists()) {
			folder_name.mkdirs();
		System.out.println("Directory : "+ folder_name.getAbsolutePath());
		}
	
	}
	
	private static String Welcome_prompt = 
			" /n---------------Lockme.com--------- "+
	         " -----------Saiteja-----------------\n ";
	private static String menu =
			"\n Menu - Select one of the following: \n "+
	        
			" a -> List files in directoy \n "+
			
			" b -> Add a file              \n "+
	
			" c -> Delete a file            \n "+
	
			" d -> Search a file             \n "+
	
			" e -> Go back                   \n "+
			
			" f -> Exit menu                 \n ";
	
	
	void menu() {
		System.out.println(menu);
		try {
			Scanner scanner = new Scanner(System.in);
			char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
			char option = input[0];
			
			switch (option) {
			
			case 'a' : {
				showfiles();
				menu();
			}
			case 'b' : {
				System.out.println("Adding the file....  Enter a file name :");
				String filename = scanner.next().toLowerCase();
				addFile(filename);
				break;
			}
			case 'c' : {
				 System.out.print(" Deleting a file...Please Enter a File Name : ");
                 String filename = scanner.next().trim();
                 deleteFile(filename);
                 break;
			}
			case 'd' : {
                System.out.print(" Searching a file...Please Enter a File Name : ");
                String filename = scanner.next().trim();
                searchFile(filename);
                break;
			}
			 case 'e' : {
                 System.out.println("Going Back to MAIN menu");
                 menu();
                 break;
			}
			 case 'f' : {
                 System.out.println("Thank you");
                 System.exit(0);
			
			}
			 default : System.out.println("Please enter a ,b ,c ,d ,e ,f ");
			}
			menu();
		}
		catch (Exception e) {
			System.out.println("Please enter a ,b ,c ,d ,e ,f");
			menu();
		}
		
	}
	void showfiles() {
        if (folder_name.list().length==0)
            System.out.println("The folder is empty");
        else {
            String[] list = folder_name.list();
            System.out.println("The files in "+ folder_name +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }
	void addFile(String filename) throws IOException {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " already exists at " + folder_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ folder_name);
    }

    void deleteFile(String filename) {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + folder_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String filename) {
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file)) {
                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
                return;
            }
        }
        System.out.println("File NOT found (FNF)");
    }



    public static void main(String[] args) {
        System.out.println(Welcome_prompt);
        lockme menu = new lockme();
        menu.menu();
    }
}	
	
	
	


