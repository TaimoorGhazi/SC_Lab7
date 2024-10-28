package lab7;

import java.io.File;

public class RecursiveFileSearch {
    private boolean fileFound;
    private String filePath;

    public RecursiveFileSearch() {
        this.fileFound = false;
        this.filePath = null;
    }

    public boolean isFileFound() {
        return fileFound;
    }

    public String getFilePath() {
        return filePath;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory-path> <file-name>");
            System.exit(1);
        }

        String directoryPath = args[0];
        String fileName = args[1];

        RecursiveFileSearch fileSearchInstance = new RecursiveFileSearch();
        File rootDir = new File(directoryPath);

        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("Error: The specified directory path does not exist or is not a directory.");
            System.exit(1);
        }

        fileSearchInstance.searchFile(rootDir, fileName);

        if (!fileSearchInstance.isFileFound()) {
            System.out.println("File not found.");
        }
    }

    /**
     * Recursively searches for a file in the provided directory and its subdirectories.
     *
     * @param directory    The current directory being searched.
     * @param targetFile   The name of the file to locate.
     */
    public void searchFile(File directory, String targetFile) {
        File[] itemsInDirectory = directory.listFiles();

        if (itemsInDirectory != null) {
            for (File item : itemsInDirectory) {
                if (item.isDirectory()) {
                    searchFile(item, targetFile);
                } else if (item.getName().equals(targetFile)) {
                    System.out.println("File found at: " + item.getAbsolutePath());
                    fileFound = true;
                    filePath = item.getAbsolutePath();
                    return;
                }
            }
        }
    }
}
