package test.data;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class dataTest {
    private final static String USER_DATA_FILE = "user_data.csv";
    private final static String DATA_FILE_FOLDER = "diary_data";
    //The following method is for creating file folder diary_data
    static {
        File folder = new File(DATA_FILE_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    //The following method is for writing user data to user_data.csv each time the method is called (Use it for create user account)
    static void saveUserData (String username, String password ) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("user_data.csv", true));
        bw.write(username + "," + password);

    } catch (IOException e) {
        System.out.println("Error saving user data: " + e.getMessage());
        throw new RuntimeException(e);
    }
    }

    //the following method is for reading the saved user data (When called, It creates an arraylist containing all the user credentials. use it for authenticating user login detail)
    public static ArrayList<String> ReadUserData () {
        ArrayList<String> UserCredentials = new ArrayList<>();
        try( BufferedReader br = new BufferedReader(new FileReader("user_data.csv"))){
            String line;
            while ((line = br.readLine())!= null){
                UserCredentials.add(line);
            }
        }
        catch (IOException e){
            System.out.println("Error reading user data: " + e.getMessage());
        }

        return UserCredentials;
    }
    public static void main(String[] args) {

    }
}
