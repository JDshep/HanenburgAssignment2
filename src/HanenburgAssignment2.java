import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HanenburgAssignment2 {

	public static void main(String[] args) {

		Scanner Scanner = new Scanner(System.in);
		String username;
		String password;
		String name = "Welcome";
		boolean access = false;
		String[] readLine = new String[3];
		User[] users = new User[4];

		// Read file
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 4; i++) {
				readLine = fileReader.readLine().split(",");
				users[i] = new User(readLine[0], readLine[1], readLine[2]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// user entry and verification
		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter a Username");
			username = Scanner.next();
			System.out.println("please enter a password");
			password = Scanner.next();
			System.out.println("Determining a Match");

			for (int j = 0; j < 4; j++) {
				if (users[j].verify(username, password)) {
					name = "Welcome " + users[j].getName();
					access = true;
					break;
				}
			}
			if (!access) {
				System.out.println("Invalid login, please try again.");
			} else if (access) {
				break;
			}
		}

		// finishing up
		Scanner.close();
		if (!access) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		} else if (access) {
			System.out.println(name);
		}

	}
}
