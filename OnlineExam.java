import java.util.Scanner;
public class OnlineExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // Initialize MCQs
        Question[] mcqs = {
            new Question("What is the capital of France?",
                    new String[]{"Paris", "London", "Berlin", "Madrid"}, 1),
            new Question("Which planet is known as the 'Red Planet'?",
                    new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2),
            new Question("What is a static method in Java?",
                    new String[]{"A method that can be called on an instance of a class",
                            "A method that is part of the Object class", 
                            "A method that can be called without creating an instance of a class",
                            "A method that is used for handling exceptions"}, 3),
            new Question("What does JVM stand for?",
                    new String[]{"Java Visual Machine", "Just Virtual Machine", 
                            "Java Virtual Machine", "Just Vague Machine"}, 3),
            // Add more questions here
        };

        Exam exam = new Exam(mcqs, 600); // 10 minutes time limit

        System.out.println("Welcome to the Online Examination System!");

        // Implement login functionality
        System.out.print("Enter your username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter your password: ");
        String passwordInput = scanner.nextLine();

        // Replace the following placeholder condition with actual authentication logic
        if (isValidCredentials(usernameInput, passwordInput)) {
            user.username = usernameInput;
            user.password = passwordInput;
            user.name = "John Doe"; // Set the user's name
            System.out.println("Login successful, " + user.name + "!");
        } else {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        int totalQuestions = mcqs.length;
        int userScore = 0;

        System.out.println("You have " + totalQuestions + " questions. Please answer:");

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + mcqs[i].question);
            String[] options = mcqs[i].options;
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Enter your answer (1-" + options.length + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == mcqs[i].correctAnswer) {
                userScore++;
            }
        }

        System.out.println("\nYour score: " + userScore + "/" + totalQuestions);
    }

    // Replace this method with your actual authentication logic
    private static boolean isValidCredentials(String username, String password) {
        // Example: Hardcoded credentials for demonstration purposes
        return username.equals("admin") && password.equals("1234");
    }
}