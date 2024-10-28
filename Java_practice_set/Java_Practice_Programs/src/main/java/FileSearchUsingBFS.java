import java.io.File;
import java.util.LinkedList;
import java.util.Queue;


public class FileSearchUsingBFS {

    public static void main(String args[]) {
        // Given starting directory for file search
        String startDir = "C:/";
        String fileName = "exercise.txt";

        // Print whether file is found the system directory
        boolean found = BFSFileSearch(new File(startDir), fileName);
        if (found)
            System.out.println("File is found");
        else {
            System.out.println("File is not found in the system: ");
        }
    }

    // Perform condition to check file name is found in particular dir and print dir name
    public static boolean BFSFileSearch(File fileDir, String fileName) {
        Queue<File> queue = new LinkedList<>();
        queue.add(fileDir);

        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else {
                        if (file.getName().equals(fileName)) {
                            System.out.println("File found at: " + file.getAbsolutePath());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
